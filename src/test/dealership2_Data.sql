-- customers DATA, 5 records minimum
INSERT INTO customers (name, address, phone) VALUES('Luke_Skywalker', '9999_Starwars_Ln_Los_Angeles_CA_29999', '399.377.3854');
INSERT INTO customers (name, address, phone) VALUES('Tom_Hardy', '1392_England_Blvd_Naples_FL_34101', '698.522.6363');
INSERT INTO customers (name, address, phone) VALUES('Boba_Fett', '1015_Drummond_St_Newark_NJ_07102', '973.206.1282');
INSERT INTO customers (name, address, phone) VALUES('Bob_Dylan', '3106_Olive_St_Toledo_OH_43604', '567.322.4981');
INSERT INTO customers (name, address, phone) VALUES('Eric_Forman', '3126_Sampson_St_Aurora_CO_80014', '303.568.6740');

-- vehicles DATA, 4 records minimum
INSERT INTO vehicles (locationID, is_sold, price, model, make) VALUES(2, 0, '5509000', 'Toyota', 'Supra');
INSERT INTO vehicles (locationID, is_sold, price, model, make) VALUES(2, 0, '5309000', 'Toyota', 'Tundra');
INSERT INTO vehicles (locationID, is_sold, price, model, make) VALUES(3, 0, '5690000', 'Tesla', 'Model_3');
INSERT INTO vehicles (locationID, is_sold, price, model, make) VALUES(3, 0, '9305000', 'Lexus', 'LC');
INSERT INTO vehicles (locationID, is_sold, price, model, make) VALUES(4, 0, '6090000', 'Audi', 'S5');


-- transactions DATA, 3 records minimum

-- locations DATA, 2 records minimum
INSERT INTO locations (locationID, location_name) VALUES('1', 'Boston');
INSERT INTO locations (locationID, location_name) VALUES('2', 'Manchester');
INSERT INTO locations (locationID, location_name) VALUES('3', 'Portsmouth');
INSERT INTO locations (locationID, location_name) VALUES('4', 'Hartford');
INSERT INTO locations (locationID, location_name) VALUES('5', 'Worcester');
INSERT INTO locations (locationID, location_name) VALUES('6', 'Portland');



-- employees DATA, 3 records minimum
INSERT INTO employees (employeeID, locationID, name) VALUES('1', '1', 'Matt_Millar');
INSERT INTO employees (employeeID, locationID, name) VALUES('2', '2', 'Jennifer_Lynn');
INSERT INTO employees (employeeID, locationID, name) VALUES('3', '3', 'Theresa_Beck');
INSERT INTO employees (employeeID, locationID, name) VALUES('4', '4', 'Alex_Briskman');
INSERT INTO employees (employeeID, locationID, name) VALUES('5', '5', 'Phil_Rodrigue');
INSERT INTO employees (employeeID, locationID, name) VALUES('6', '6', 'Melissa_Marchand');
INSERT INTO employees (employeeID, locationID, name) VALUES('7', '1', 'Robert_Bowers');