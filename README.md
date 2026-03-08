# airBnb

A scalable Airbnb-like reference implementation with:

- `backend/`: Spring Boot 3 backend using ports-and-adapters architecture.
- `frontend/`: modern React/Vite UI that replicates core Airbnb-style search/listing experience.
- `docs/`: HLD and LLD architecture documents.

## Run backend
Default mode uses in-memory H2 (no external database required):
```bash
cd backend
mvn spring-boot:run
```

Use PostgreSQL profile when your DB is available:
```bash
cd backend
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
```

## Run frontend
```bash
cd frontend
npm install
npm run dev
```

## API endpoints
- `POST /api/v1/listings`
- `GET /api/v1/listings?location=&guests=`
- `POST /api/v1/reservations`
