
INSERT INTO Aircraft (ID, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'GliderOne');
INSERT INTO Glider (ID, NUM_WINGS) VALUES (1, 2);

INSERT INTO Aircraft (ID, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'GliderTwo');
INSERT INTO Glider (ID, NUM_WINGS) VALUES (2, 4);

INSERT INTO Aircraft (ID, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'HelicopterOne');
INSERT INTO Helicopter (ID, NUM_BLADES,  NUM_ENGINES) VALUES (3 , 5 , 2);

INSERT INTO Aircraft (ID, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'HelicopterTwo');
INSERT INTO Helicopter (ID, NUM_BLADES,  NUM_ENGINES) VALUES (4 , 7 , 3);

INSERT INTO Aircraft (ID, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'JetOne');
INSERT INTO Jet (ID, NUM_WINGS,  NUM_ENGINES) VALUES (5 , 2 , 4);

INSERT INTO Aircraft (ID, name) VALUES (NEXT VALUE FOR aircraft_sequence, 'JetTwo');
INSERT INTO Jet (ID, NUM_WINGS,  NUM_ENGINES) VALUES (6 , 4 , 6);