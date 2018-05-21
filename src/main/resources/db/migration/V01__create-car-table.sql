CREATE TABLE cars(
    car_id int(11) NOT NULL,
    make varchar(20) NOT NULL,
    model varchar(20) NOT NULL,
    yearbook int(11) NOT NULL,
    body_type varchar(20) NOT NULL,
    engine_size double NOT NULL,
    fuel varchar(20) NOT NULL,
    horse_power double NOT NULL,
    service_date date NOT NULL,
    car_status boolean NOT NULL DEFAULT true,
    client_id int(11) default null,
    UNIQUE KEY car_id (car_id)
    );