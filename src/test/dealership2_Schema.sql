create DATABASE if not exists dealership;
use dealership;
drop table if exists transactions;
drop table if exists employees;
drop table if exists vehicles;
drop table if exists locations;
drop table if exists customers;
CREATE TABLE customers (
  customerID int (10) NOT NULL AUTO_INCREMENT,
  name varchar(45),
  address varchar(45),
  phone varchar(20),
  PRIMARY KEY (customerID)
);
CREATE TABLE locations (
locationID int(3) NOT NULL AUTO_INCREMENT,
location_name varchar(40) NOT NULL,
PRIMARY KEY (locationID) 
);
CREATE TABLE vehicles (
  vehicleID int (10) NOT NULL AUTO_INCREMENT,
  locationID int (3) NOT NULL,
  is_sold bit NOT NULL,
  price decimal(7, 2) NOT NULL,
  model varchar(40) NOT NULL,
  make varchar(40) NOT NULL,
  PRIMARY KEY (vehicleID),
  FOREIGN KEY (locationID) REFERENCES locations(locationID)
);
CREATE TABLE employees (
employeeID int(5) NOT NULL AUTO_INCREMENT,
locationID int(3) NOT NULL,
name varchar(40) NOT NULL,
 PRIMARY KEY (employeeID),
 FOREIGN KEY (locationID) REFERENCES locations(locationID)
);
create table transactions (
  transactionID int (10) NOT NULL AUTO_INCREMENT,
  vehicleID int (10) NOT NULL,
  customerID int(10) NOT NULL,
  employeeID int(5) NOT NULL,
  locationID int(3) NOT NULL,
  datestamp date not null,
  PRIMARY KEY (transactionID),
  FOREIGN KEY (vehicleID) REFERENCES vehicles(vehicleID) ,
  FOREIGN KEY (customerID) REFERENCES customers(customerID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID),
  FOREIGN KEY (locationID) REFERENCES locations(locationID)
);

  
  -- customers DATA, 5 records minimum
INSERT INTO customers (name, address, phone) VALUES('Luke_Skywalker', '9999_Starwars_Ln_Los_Angeles_CA_29999', '399.377.3854');
INSERT INTO customers (name, address, phone) VALUES('Tom_Hardy', '1392_England_Blvd_Naples_FL_34101', '698.522.6363');
INSERT INTO customers (name, address, phone) VALUES('Boba_Fett', '1015_Drummond_St_Newark_NJ_07102', '973.206.1282');
INSERT INTO customers (name, address, phone) VALUES('Bob_Dylan', '3106_Olive_St_Toledo_OH_43604', '567.322.4981');
INSERT INTO customers (name, address, phone) VALUES('Eric_Forman', '3126_Sampson_St_Aurora_CO_80014', '303.568.6740');

-- locations DATA, 2 records minimum
INSERT INTO locations (locationID, location_name) VALUES('1', 'Boston');
INSERT INTO locations (locationID, location_name) VALUES('2', 'Manchester');
INSERT INTO locations (locationID, location_name) VALUES('3', 'Portsmouth');
INSERT INTO locations (locationID, location_name) VALUES('4', 'Hartford');
INSERT INTO locations (locationID, location_name) VALUES('5', 'Worcester');
INSERT INTO locations (locationID, location_name) VALUES('6', 'Portland');

-- vehicles DATA, 4 records minimum
INSERT INTO vehicles (locationID,is_sold, price, model, make) VALUES('1', 0, '55090.00', 'Toyota', 'Supra');
INSERT INTO vehicles (locationID,is_sold, price, model, make) VALUES('3', 0, '53090.00', 'Toyota', 'Tundra');
INSERT INTO vehicles (locationID, is_sold, price, model, make) VALUES('6', 0, '56900.00', 'Tesla', 'Model_3');
INSERT INTO vehicles (locationID,is_sold, price, model, make) VALUES('2',0, '93050.00', 'Lexus', 'LC');
INSERT INTO vehicles (locationID,is_sold, price, model, make) VALUES('4',0, '60900.00', 'Audi', 'S5');



-- employees DATA, 3 records minimum
INSERT INTO employees (employeeID, locationID, name) VALUES('1', '1', 'Matt_Millar');
INSERT INTO employees (employeeID, locationID, name) VALUES('2', '2', 'Jennifer_Lynn');
INSERT INTO employees (employeeID, locationID, name) VALUES('3', '3', 'Theresa_Beck');
INSERT INTO employees (employeeID, locationID, name) VALUES('4', '4', 'Alex_Briskman');
INSERT INTO employees (employeeID, locationID, name) VALUES('5', '5', 'Phil_Rodrigue');
INSERT INTO employees (employeeID, locationID, name) VALUES('6', '6', 'Melissa_Marchand');
INSERT INTO employees (employeeID, locationID, name) VALUES('7', '1', 'Robert_Bowers');



-- transactions DATA, 3 records minimum
INSERT INTO transactions (vehicleID, customerID, employeeID, locationID, datestamp) VALUES('4',2, '4', '3',curdate());
INSERT INTO transactions (vehicleID, customerID, employeeID, locationID, datestamp) VALUES('2',4, '4', '3',curdate());
INSERT INTO transactions (vehicleID, customerID, employeeID, locationID, datestamp) VALUES('3',3, '4', '4',curdate());
