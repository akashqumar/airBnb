# Airbnb-like Platform — Low Level Design (LLD)

## Package Layout
- `domain.model`: immutable domain records (`Listing`, `Reservation`).
- `domain.service`: pricing behavior contract + implementation (`PricingStrategy`).
- `application.port`: outbound interfaces for persistence and notification.
- `application.service`: use-cases (`ListingService`, `ReservationService`).
- `infrastructure.persistence`: JPA entities/repositories/adapters.
- `web`: REST controllers and API contracts.

## Reservation Flow
1. `ReservationController#create` receives request.
2. `ReservationService#create` loads listing via `ListingRepositoryPort`.
3. `PricingStrategy#calculate` computes final amount.
4. `ReservationRepositoryPort#save` persists reservation.
5. `NotificationPort#sendReservationCreated` emits side-effect.

## Data Model
### listings
- `id` (UUID, PK)
- `host_id` (UUID)
- `title` (varchar)
- `location` (varchar)
- `nightly_rate` (numeric)
- `max_guests` (int)
- `active` (boolean)

### reservations
- `id` (UUID, PK)
- `listing_id` (UUID)
- `guest_id` (UUID)
- `check_in` (date)
- `check_out` (date)
- `total_price` (numeric)
- `status` (enum)

## Scaling Notes
- Controllers/services are stateless and safe for N-instance deployment.
- Search path can be optimized with Redis and read replicas.
- Booking can use optimistic locking and message queue outbox pattern for high consistency at scale.
