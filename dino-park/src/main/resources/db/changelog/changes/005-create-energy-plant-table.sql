CREATE TABLE energy_plant (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    current_energy INT NOT NULL,

    max_capacity INT NOT NULL,

    status VARCHAR(50) NOT NULL

);