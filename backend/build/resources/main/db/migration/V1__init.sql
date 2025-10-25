
CREATE TABLE IF NOT EXISTS flights (
  id             BIGSERIAL PRIMARY KEY,
  origin         VARCHAR(100) NOT NULL,
  destination    VARCHAR(100) NOT NULL,
  departure_date DATE NOT NULL,
  return_date    DATE NOT NULL,
  passengers     INTEGER NOT NULL CHECK (passengers > 0),
  travel_class   VARCHAR(50) NOT NULL,
  created_at     TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at     TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_flights_route ON flights (origin, destination);
CREATE INDEX IF NOT EXISTS idx_flights_depart ON flights (departure_date);
