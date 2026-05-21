CREATE TABLE zone (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    capacity INT NOT NULL,

    current_visitors INT NOT NULL,

    active BOOLEAN NOT NULL

);