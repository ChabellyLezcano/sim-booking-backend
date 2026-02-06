package com.portfolio.bookingsim.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateBookingRequest(
        @NotNull Long propertyId,
        @NotBlank String guestName,
        @Email String guestEmail,
        @NotNull LocalDate checkIn,
        @NotNull LocalDate checkOut,
        @Min(1) @Max(20) int guests
) {}
