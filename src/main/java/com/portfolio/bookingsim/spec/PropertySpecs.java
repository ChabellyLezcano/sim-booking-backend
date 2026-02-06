package com.portfolio.bookingsim.spec;

import com.portfolio.bookingsim.model.Property;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class PropertySpecs {
    public static Specification<Property> cityLike(String city) {
        return (root, query, cb) ->
                city == null || city.isBlank()
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get("city")), "%" + city.toLowerCase() + "%");
    }

    public static Specification<Property> minPrice(BigDecimal min) {
        return (root, query, cb) ->
                min == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("pricePerNight"), min);
    }

    public static Specification<Property> maxPrice(BigDecimal max) {
        return (root, query, cb) ->
                max == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("pricePerNight"), max);
    }
}
