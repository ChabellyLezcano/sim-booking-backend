package com.portfolio.bookingsim.web;

import com.portfolio.bookingsim.dto.PropertyDto;
import com.portfolio.bookingsim.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final BookingService bookingService;

    @GetMapping
    public Page<PropertyDto> search(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        return bookingService.searchProperties(city, minPrice, maxPrice, page, size);
    }

    @GetMapping("/{id}")
    public PropertyDto get(@PathVariable Long id) {
        return bookingService.getProperty(id);
    }
}
