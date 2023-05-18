CREATE TABLE patient (
  pid int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  date_of_birth date NOT NULL,
  gender varchar(10) NOT NULL,
  address varchar(200) NOT NULL,
  suburb varchar(100) NOT NULL,
  state varchar(100) NOT NULL,
  postcode varchar(20) NOT NULL,
  PRIMARY KEY (pid)
);
