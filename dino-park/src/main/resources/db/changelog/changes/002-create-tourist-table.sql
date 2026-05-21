CREATE TABLE tourist (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    full_name VARCHAR(100) NOT NULL,

    age INT NOT NULL,

    ticket_type VARCHAR(50) NOT NULL,

    inside_park BOOLEAN NOT NULL

);