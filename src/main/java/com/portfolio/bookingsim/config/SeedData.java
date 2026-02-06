package com.portfolio.bookingsim.config;

import com.portfolio.bookingsim.model.Property;
import com.portfolio.bookingsim.repo.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SeedData {

    private final PropertyRepository propertyRepository;

    @Bean
    public CommandLineRunner seed() {
        return args -> {
            if (propertyRepository.count() > 0) return;

            Property p1 = Property.builder()
                    .name("Gran Vía Boutique Hotel")
                    .city("Madrid")
                    .country("Spain")
                    .description("Boutique hotel in the center, just steps from Gran Vía. Modern rooms, Wi-Fi, and breakfast.")
                    .pricePerNight(new BigDecimal("129.00"))
                    .rating(9.1)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1649731000184-7ced04998f44?q=80&w=986&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                            "https://images.unsplash.com/photo-1566073771259-6a8506099945?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1605346434674-a440ca4dc4c0?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                    ))
                    .amenities(List.of("Wi-Fi", "Breakfast", "A/C", "24h Reception"))
                    .build();

            Property p2 = Property.builder()
                    .name("Seaside Apartments Barceloneta")
                    .city("Barcelona")
                    .country("Spain")
                    .description("Apartments with kitchen and views, minutes from the beach. Ideal for long stays.")
                    .pricePerNight(new BigDecimal("155.00"))
                    .rating(8.7)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1445019980597-93fa8acb246c?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1505691938895-1758d7feb511?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Kitchen", "Wi-Fi", "Washer", "Views"))
                    .build();

            Property p3 = Property.builder()
                    .name("Sierra Verde Country House")
                    .city("Segovia")
                    .country("Spain")
                    .description("A quiet getaway surrounded by nature. Fireplace, garden, and nearby hiking routes.")
                    .pricePerNight(new BigDecimal("98.00"))
                    .rating(9.4)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1564013799919-ab600027ffc6?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1445019980597-93fa8acb246c?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Fireplace", "Parking", "Garden", "Pets allowed"))
                    .build();

            Property p4 = Property.builder()
                    .name("Bilbao Design Rooms")
                    .city("Bilbao")
                    .country("Spain")
                    .description("Minimalist rooms with excellent connectivity. Perfect for weekend trips.")
                    .pricePerNight(new BigDecimal("112.00"))
                    .rating(8.9)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1505691938895-1758d7feb511?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "A/C", "Self check-in"))
                    .build();

            Property p5 = Property.builder()
                    .name("Panorama Loft Downtown")
                    .city("Valencia")
                    .country("Spain")
                    .description("Bright loft with a spacious living area and a workspace. Perfect for remote work and city breaks.")
                    .pricePerNight(new BigDecimal("119.00"))
                    .rating(8.8)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1665249934445-1de680641f50?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1675279200694-8529c73b1fd0?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "Kitchen", "Workspace", "Smart TV"))
                    .build();

            Property p6 = Property.builder()
                    .name("Minimal Suite City View")
                    .city("Madrid")
                    .country("Spain")
                    .description("Modern suite with city views, a king bed, and premium details.")
                    .pricePerNight(new BigDecimal("179.00"))
                    .rating(9.0)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1568495248636-6432b97bd949?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1549638441-b787d2e11f14?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1711059985570-4c32ed12a12c?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("A/C", "Wi-Fi", "King bed", "Views"))
                    .build();

            Property p7 = Property.builder()
                    .name("Rooftop Boutique Stay")
                    .city("Seville")
                    .country("Spain")
                    .description("Boutique room with warm lighting and a modern aesthetic. Great location.")
                    .pricePerNight(new BigDecimal("142.00"))
                    .rating(8.6)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1611892440504-42a792e24d32?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1618773928121-c32242e63f39?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "24h Reception", "Coffee maker", "Elevator"))
                    .build();

            Property p8 = Property.builder()
                    .name("Comfort Room Downtown")
                    .city("Málaga")
                    .country("Spain")
                    .description("Comfortable, spacious room with a sitting area and lots of natural light.")
                    .pricePerNight(new BigDecimal("109.00"))
                    .rating(8.5)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1631049552057-403cdb8f0658?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1629140727571-9b5c6f6267b4?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "A/C", "Hair dryer", "Easy check-in"))
                    .build();

            Property p9 = Property.builder()
                    .name("Classic Elegance Suite")
                    .city("San Sebastián")
                    .country("Spain")
                    .description("Suite with classic decor, a warm atmosphere, and guaranteed rest.")
                    .pricePerNight(new BigDecimal("165.00"))
                    .rating(9.2)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1590490360182-c33d57733427?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1566665797739-1674de7a421a?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1596394516093-501ba68a0ba6?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "Breakfast", "Queen bed", "Soundproofing"))
                    .build();

            Property p10 = Property.builder()
                    .name("Designer Lobby & Lounge Hotel")
                    .city("Barcelona")
                    .country("Spain")
                    .description("Hotel with a designer lobby and well-kept common areas. Ideal for city trips.")
                    .pricePerNight(new BigDecimal("149.00"))
                    .rating(8.9)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1621293954908-907159247fc8?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1621293954908-907159247fc8?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "Lounge", "24h Reception", "Cafeteria"))
                    .build();

            // ⚠️ IMPORTANT:
            // p10 (above) has a repeated photo (same URL twice).
            // If you want 100% unique photos, tell me and I’ll replace 1 URL.
            // I’m keeping it as-is to avoid inventing unverified IDs.

            Property p11 = Property.builder()
                    .name("Ocean Breeze Twin Room")
                    .city("Cádiz")
                    .country("Spain")
                    .description("Twin room with a fresh, bright aesthetic. Perfect for a coastal stay.")
                    .pricePerNight(new BigDecimal("121.00"))
                    .rating(8.4)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1667125095636-dce94dcbdd96?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1578683010236-d716f9a3f461?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1576354302919-96748cb8299e?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "A/C", "Near the beach", "Towels"))
                    .build();

            Property p12 = Property.builder()
                    .name("Urban Apartment Kitchen & Light")
                    .city("Zaragoza")
                    .country("Spain")
                    .description("Functional apartment with an equipped kitchen and dining area. Very practical.")
                    .pricePerNight(new BigDecimal("104.00"))
                    .rating(8.3)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1675279200694-8529c73b1fd0?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1665249934445-1de680641f50?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Kitchen", "Wi-Fi", "Washer", "Dining table"))
                    .build();

            Property p13 = Property.builder()
                    .name("Mountain Deck Cabin Stay")
                    .city("Huesca")
                    .country("Spain")
                    .description("Mountain vibes with spectacular views. A unique experience.")
                    .pricePerNight(new BigDecimal("189.00"))
                    .rating(9.3)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1596394516093-501ba68a0ba6?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1564013799919-ab600027ffc6?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Views", "Heating", "Parking", "Nature"))
                    .build();

            Property p14 = Property.builder()
                    .name("Boutique King Room Soft Lights")
                    .city("Granada")
                    .country("Spain")
                    .description("Boutique room with soft lighting and modern details.")
                    .pricePerNight(new BigDecimal("133.00"))
                    .rating(8.7)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1566665797739-1674de7a421a?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1631049552057-403cdb8f0658?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1629140727571-9b5c6f6267b4?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "A/C", "King bed", "Flexible check-in"))
                    .build();

            Property p15 = Property.builder()
                    .name("Modern Apartment Balcony Living")
                    .city("Alicante")
                    .country("Spain")
                    .description("Living room with afternoon light and a balcony. Very cozy for medium stays.")
                    .pricePerNight(new BigDecimal("97.00"))
                    .rating(8.2)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1665249934445-1de680641f50?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1675279200694-8529c73b1fd0?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Balcony", "Wi-Fi", "Kitchen", "Coffee maker"))
                    .build();

            Property p16 = Property.builder()
                    .name("Quiet Room Near Station")
                    .city("Valladolid")
                    .country("Spain")
                    .description("Quiet room near transport. Ideal for business trips.")
                    .pricePerNight(new BigDecimal("88.00"))
                    .rating(8.1)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1576354302919-96748cb8299e?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1549638441-b787d2e11f14?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1711059985570-4c32ed12a12c?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "A/C", "Desk", "Self check-in"))
                    .build();

            Property p17 = Property.builder()
                    .name("Premium Double With Courtyard")
                    .city("Córdoba")
                    .country("Spain")
                    .description("Premium double room with an elegant style and an upscale hotel feel.")
                    .pricePerNight(new BigDecimal("158.00"))
                    .rating(8.9)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1667125095636-dce94dcbdd96?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1568495248636-6432b97bd949?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "Breakfast", "A/C", "24h Reception"))
                    .build();

            Property p18 = Property.builder()
                    .name("Smart Studio City Center")
                    .city("Murcia")
                    .country("Spain")
                    .description("Smart studio with a kitchen and optimized space. Very comfortable.")
                    .pricePerNight(new BigDecimal("92.00"))
                    .rating(8.0)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1675279200694-8529c73b1fd0?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1445019980597-93fa8acb246c?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1505691938895-1758d7feb511?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Kitchen", "Wi-Fi", "Smart TV", "Self-contained"))
                    .build();

            Property p19 = Property.builder()
                    .name("Chic Room Warm Textures")
                    .city("Santander")
                    .country("Spain")
                    .description("Chic room with warm textures, perfect for switching off.")
                    .pricePerNight(new BigDecimal("116.00"))
                    .rating(8.4)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1590490360182-c33d57733427?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1566665797739-1674de7a421a?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1576354302919-96748cb8299e?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "Heating", "Queen bed", "Towels"))
                    .build();

            Property p20 = Property.builder()
                    .name("Large Suite Open Space")
                    .city("Pamplona")
                    .country("Spain")
                    .description("Open-plan suite with a sitting area, ideal for couples.")
                    .pricePerNight(new BigDecimal("173.00"))
                    .rating(9.0)
                    .photoUrls(List.of(
                            "https://images.unsplash.com/photo-1578683010236-d716f9a3f461?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?auto=format&fit=crop&w=1600&q=80",
                            "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?auto=format&fit=crop&w=1600&q=80"
                    ))
                    .amenities(List.of("Wi-Fi", "A/C", "Sitting area", "King bed"))
                    .build();

            propertyRepository.saveAll(List.of(
                    p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                    p11, p12, p13, p14, p15, p16, p17, p18, p19, p20
            ));
        };
    }
}
