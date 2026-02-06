package com.portfolio.bookingsim.web;

import com.portfolio.bookingsim.dto.BookingDto;
import com.portfolio.bookingsim.dto.CreateBookingRequest;
import com.portfolio.bookingsim.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingDto create(@Valid @RequestBody CreateBookingRequest req) {
        return bookingService.createBooking(req);
    }

    @GetMapping("/{id}")
    public BookingDto get(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @GetMapping
    public Page<BookingDto> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return bookingService.listBookings(page, size);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}
