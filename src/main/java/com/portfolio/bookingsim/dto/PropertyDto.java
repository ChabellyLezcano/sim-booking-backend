package com.portfolio.bookingsim.dto;

import java.math.BigDecimal;
import java.util.List;

public record PropertyDto(
        Long id,
        String name,
        String city,
        String country,
        String description,
        BigDecimal pricePerNight,
        Double rating,
        List<String> photoUrls,
        List<String> amenities
) {}
