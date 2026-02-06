package com.portfolio.bookingsim.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record UpsertPropertyRequest(
        @NotBlank String name,
        @NotBlank String city,
        @NotBlank String country,
        @Size(max = 2000) String description,
        @NotNull @DecimalMin("0.0") BigDecimal pricePerNight,
        @DecimalMin("0.0") @DecimalMax("10.0") Double rating,
        @NotNull @Size(min = 1) List<@NotBlank String> photoUrls,
        @NotNull List<@NotBlank String> amenities
) {}
