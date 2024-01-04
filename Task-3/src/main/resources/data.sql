CREATE SEQUENCE aircraft_sequence START WITH 1;

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'GliderOne');
INSERT INTO Glider (id, NUM_WINGS) VALUES (CURRVAL('aircraft_sequence') , 2);

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'GliderTwo');
INSERT INTO Glider (id, NUM_WINGS) VALUES (CURRVAL('aircraft_sequence') , 4);

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'HelicopterOne');
INSERT INTO Helicopter (id, NUM_BLADES,  NUM_ENGINES) VALUES (CURRVAL('aircraft_sequence') , 5 , 2);

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'HelicopterTwo');
INSERT INTO Helicopter (id, NUM_BLADES,  NUM_ENGINES) VALUES (CURRVAL('aircraft_sequence') , 7 , 3);

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'JetOne');
INSERT INTO Jet (id, NUM_WINGS,  NUM_ENGINES) VALUES (CURRVAL('aircraft_sequence') , 2 , 4);

INSERT INTO Aircraft (id, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'JetTwo');
INSERT INTO Jet (id, NUM_WINGS,  NUM_ENGINES) VALUES (CURRVAL('aircraft_sequence') , 4 , 6);