CREATE TABLE customers(
  client_id int(11) NOT NULL,
  username varchar(20) NOT NULL,
  first_name varchar(20) NOT NULL,
  last_name varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  email varchar(20) NOT NULL,
  city varchar(20) NOT NULL,
  contact varchar(20) NOT NULL,
  UNIQUE KEY client_id (client_id)
);