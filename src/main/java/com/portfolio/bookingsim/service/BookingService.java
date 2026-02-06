package com.portfolio.bookingsim.service;

import com.portfolio.bookingsim.dto.*;
import com.portfolio.bookingsim.model.Booking;
import com.portfolio.bookingsim.model.Property;
import com.portfolio.bookingsim.repo.BookingRepository;
import com.portfolio.bookingsim.repo.PropertyRepository;
import com.portfolio.bookingsim.spec.PropertySpecs;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final PropertyRepository propertyRepository;
    private final BookingRepository bookingRepository;

    // ---- SEARCH / READ ----
    public Page<PropertyDto> searchProperties(String city, BigDecimal minPrice, BigDecimal maxPrice, int page, int size) {
        Specification<Property> spec = Specification.where(PropertySpecs.cityLike(city))
                .and(PropertySpecs.minPrice(minPrice))
                .and(PropertySpecs.maxPrice(maxPrice));

        return propertyRepository.findAll(spec, PageRequest.of(page, size, Sort.by("rating").descending()))
                .map(this::toDto);
    }

    public PropertyDto getProperty(Long id) {
        Property p = propertyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Property not found"));
        return toDto(p);
    }

    // ---- PROPERTY CRUD ----
    @Transactional
    public PropertyDto createProperty(UpsertPropertyRequest req) {
        Property p = Property.builder()
                .name(req.name())
                .city(req.city())
                .country(req.country())
                .description(req.description())
                .pricePerNight(req.pricePerNight())
                .rating(req.rating() == null ? 8.5 : req.rating())
                .photoUrls(req.photoUrls())
                .amenities(req.amenities())
                .build();
        return toDto(propertyRepository.save(p));
    }

    @Transactional
    public PropertyDto updateProperty(Long id, UpsertPropertyRequest req) {
        Property p = propertyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Property not found"));
        p.setName(req.name());
        p.setCity(req.city());
        p.setCountry(req.country());
        p.setDescription(req.description());
        p.setPricePerNight(req.pricePerNight());
        p.setRating(req.rating());
        p.getPhotoUrls().clear();
        p.getPhotoUrls().addAll(req.photoUrls());
        p.getAmenities().clear();
        p.getAmenities().addAll(req.amenities());
        return toDto(p);
    }

    @Transactional
    public void deleteProperty(Long id) {
        if (bookingRepository.existsForProperty(id)) {
            throw new IllegalStateException("Cannot delete property with bookings");
        }
        if (!propertyRepository.existsById(id)) throw new EntityNotFoundException("Property not found");
        propertyRepository.deleteById(id);
    }

    // ---- BOOKING CRUD ----
    @Transactional
    public BookingDto createBooking(CreateBookingRequest req) {
        Property property = propertyRepository.findById(req.propertyId())
                .orElseThrow(() -> new EntityNotFoundException("Property not found"));

        if (!req.checkOut().isAfter(req.checkIn())) {
            throw new IllegalArgumentException("checkOut must be after checkIn");
        }

        boolean overlaps = bookingRepository.existsByProperty_IdAndCheckInLessThanAndCheckOutGreaterThan(
                req.propertyId(), req.checkOut(), req.checkIn()
        );
        if (overlaps) {
            throw new IllegalStateException("Selected dates are not available");
        }

        long nights = ChronoUnit.DAYS.between(req.checkIn(), req.checkOut());
        BigDecimal total = property.getPricePerNight().multiply(BigDecimal.valueOf(nights));

        Booking booking = Booking.builder()
                .property(property)
                .guestName(req.guestName())
                .guestEmail(req.guestEmail())
                .checkIn(req.checkIn())
                .checkOut(req.checkOut())
                .guests(req.guests())
                .totalPrice(total)
                .build();

        return toDto(bookingRepository.save(booking));
    }

    public Page<BookingDto> listBookings(int page, int size) {
        return bookingRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()))
                .map(this::toDto);
    }

    public BookingDto getBooking(Long id) {
        Booking b = bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Booking not found"));
        return toDto(b);
    }

    @Transactional
    public void cancelBooking(Long id) {
        if (!bookingRepository.existsById(id)) throw new EntityNotFoundException("Booking not found");
        bookingRepository.deleteById(id);
    }

    // ---- MAPPERS ----
    private PropertyDto toDto(Property p) {
        return new PropertyDto(
                p.getId(),
                p.getName(),
                p.getCity(),
                p.getCountry(),
                p.getDescription(),
                p.getPricePerNight(),
                p.getRating(),
                p.getPhotoUrls(),
                p.getAmenities()
        );
    }

    private BookingDto toDto(Booking b) {
        return new BookingDto(
                b.getId(),
                b.getProperty().getId(),
                b.getProperty().getName(),
                b.getGuestName(),
                b.getGuestEmail(),
                b.getCheckIn(),
                b.getCheckOut(),
                b.getGuests(),
                b.getTotalPrice()
        );
    }
}
