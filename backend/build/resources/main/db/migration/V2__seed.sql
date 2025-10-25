-- PostgreSQL seed data
INSERT INTO flights (origin, destination, departure_date, return_date, passengers, travel_class)
VALUES
  ('San Francisco (SFO)', 'Taipei (TPE)', '2020-01-09', '2020-01-12', 1, 'Economy'),
  ('New York (JFK)',      'London (LHR)', '2020-02-15', '2020-02-22', 2, 'Business'),
  ('Los Angeles (LAX)',   'New York (JFK)', '2020-01-15', '2020-01-19', 1, 'Premium Economy');