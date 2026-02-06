package com.portfolio.bookingsim.web;

import com.portfolio.bookingsim.dto.PropertyDto;
import com.portfolio.bookingsim.dto.UpsertPropertyRequest;
import com.portfolio.bookingsim.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/properties")
@RequiredArgsConstructor
public class AdminPropertyController {

    private final BookingService bookingService;

    @PostMapping
    public PropertyDto create(@Valid @RequestBody UpsertPropertyRequest req) {
        return bookingService.createProperty(req);
    }

    @PutMapping("/{id}")
    public PropertyDto update(@PathVariable Long id, @Valid @RequestBody UpsertPropertyRequest req) {
        return bookingService.updateProperty(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingService.deleteProperty(id);
    }
}
