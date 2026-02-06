package com.portfolio.bookingsim.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookingDto(
        Long id,
        Long propertyId,
        String propertyName,
        String guestName,
        String guestEmail,
        LocalDate checkIn,
        LocalDate checkOut,
        int guests,
        BigDecimal totalPrice
) {}
