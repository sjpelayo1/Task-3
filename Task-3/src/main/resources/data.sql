CREATE SEQUENCE aircraft_sequence START WITH 1;

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'GliderOne');

INSERT INTO Glider (id, NUM_WINGS) VALUES (CURRVAL('aircraft_sequence') , 2);
