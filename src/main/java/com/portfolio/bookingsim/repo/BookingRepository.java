package com.portfolio.bookingsim.repo;

import com.portfolio.bookingsim.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByProperty_IdAndCheckInLessThanAndCheckOutGreaterThan(Long propertyId, LocalDate checkOut, LocalDate checkIn);

    @Query("select count(b) > 0 from Booking b where b.property.id = :propertyId")
    boolean existsForProperty(Long propertyId);
}
