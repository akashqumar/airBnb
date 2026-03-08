# Airbnb-like Platform — High Level Design (HLD)

## Goals
- Build a Spring Boot backend that supports **horizontal scaling**.
- Replicate core Airbnb features: listing search, booking workflow, pricing, and notifications.
- Keep services stateless and cloud-native.

## Architecture Overview
- **Frontend (React/Vite)**: search UI, listing cards, and booking trigger.
- **API Layer (Spring Boot)**: REST APIs, validation, request orchestration.
- **Domain/Application Layer**: business rules (pricing, reservation lifecycle).
- **Data Layer**:
  - PostgreSQL for durable transactional storage.
  - Redis (recommended) for caching search results/session-free rate limits.
- **Async Layer**:
  - Event publishing for booking-created notifications (Kafka/SQS recommended in production).

## Horizontal Scalability Strategy
1. **Stateless API instances** behind a load balancer.
2. **Externalized state** in PostgreSQL/Redis/Kafka, no in-memory session coupling.
3. **Read scaling** with DB read replicas for high traffic listing searches.
4. **Caching** for frequent location/guest search combinations.
5. **Observability** via Spring Actuator and metrics endpoint.
6. **Containerization** with immutable deployable artifacts.

## Design Patterns Applied
- **Hexagonal (Ports & Adapters)** for clean boundaries between domain and infrastructure.
- **Strategy Pattern** for pricing calculation logic.
- **Factory/Provider style bean config** for notifier implementations.

## Core APIs
- `POST /api/v1/listings` — host creates listing.
- `GET /api/v1/listings?location=&guests=` — search listings.
- `POST /api/v1/reservations` — create reservation and trigger notification event.
