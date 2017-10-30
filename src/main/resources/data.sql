INSERT INTO toughjet (carrier, base_price, tax, discount, departure_airport_name, arrival_airport_name,
outbound_date_time, inbound_date_time, available_seats) VALUES
    ('BritishAirways', 65.40, 10.00, 2.00, 'LGW', 'SVQ', '12/11/2017 10:00', '12/11/2017 12:00', 10),
    ('EasyJet', 55.40, 10.00, 2.00, 'LGW', 'SVQ', '12/11/2017 16:00', '12/11/2017 18:00', 3),
    ('Ryanair', 35.40, 10.00, 0.00, 'LGW', 'SVQ', '12/11/2017 21:00', '12/11/2017 23:00', 4),
    ('BritishAirways', 82.20, 5.00, 0.00, 'LHR', 'AMS', '12/11/2017 11:00', '12/11/2017 12:00', 15),
    ('EasyJet', 40.10, 5.00, 0.00, 'LHR', 'AMS', '12/11/2017 19:00', '12/11/2017 20:00', 4),
    ('Ryanair', 45.40, 5.00, 5.00, 'LHR', 'AMS', '12/11/2017 06:00', '12/11/2017 07:00', 2),
    ('BritishAirways', 61.40, 10.00, 2.00, 'SVQ', 'LGW', '15/11/2017 10:00', '15/11/2017 12:00', 10),
    ('EasyJet', 48.40, 10.00, 2.00, 'SVQ', 'LGW', '15/11/2017 16:00', '15/11/2017 18:00', 3),
    ('Ryanair', 39.40, 10.00, 0.00, 'SVQ', 'LGW', '15/11/2017 21:00', '15/11/2017 23:00', 4),
    ('BritishAirways', 75.20, 5.00, 0.00, 'AMS', 'LHR', '15/11/2017 11:00', '15/11/2017 12:00', 15),
    ('EasyJet', 43.10, 5.00, 0.00, 'AMS', 'LHR', '15/11/2017 19:00', '15/11/2017 20:00', 4),
    ('Ryanair', 50.40, 5.00, 5.00, 'AMS', 'LHR', '15/11/2017 06:00', '15/11/2017 07:00', 2);

INSERT INTO crazyair (airline, price, cabinclass, departure_airport_code, destination_airport_code,
departure_date, arrival_date, available_seats) VALUES
    ('KLM',55.20, 'E', 'LHR', 'AMS', '12/11/2017 08:00', '12/11/2017 09:00', 4),
    ('Transavia',60.10, 'B', 'LHR', 'AMS', '12/11/2017 13:30', '12/11/2017 14:30', 3),
    ('Ryanair',55.20, 'E', 'LHR', 'AMS', '12/11/2017 22:00', '12/11/2017 23:00', 9),
    ('Iberia',80.40, 'E', 'LGW', 'SVQ', '12/11/2017 11:00', '12/11/2017 13:00',4),
    ('AirEuropa',50.20, 'E', 'LGW', 'SVQ', '12/11/2017 19:00', '12/11/2017 21:00',2),
    ('Vueling',60.30, 'E', 'LGW', 'SVQ', '12/11/2017 7:00', '12/11/2017 9:00',7),
    ('KLM',60.20, 'E', 'AMS', 'LHR', '15/11/2017 08:00', '15/11/2017 09:00', 4),
    ('Transavia',55.10, 'B', 'AMS', 'LHR', '15/11/2017 13:30', '15/11/2017 14:30', 3),
    ('Ryanair',42.20, 'E', 'AMS', 'LHR', '15/11/2017 22:00', '15/11/2017 23:00', 9),
    ('Iberia',57.40, 'E', 'SVQ', 'LGW', '15/11/2017 11:00', '15/11/2017 13:00',4),
    ('AirEuropa',57.40, 'E', 'SVQ', 'LGW', '15/11/2017 19:00', '15/11/2017 21:00',2),
    ('Vueling',40.30, 'E', 'SVQ', 'LGW', '15/11/2017 7:00', '15/11/2017 9:00',7);