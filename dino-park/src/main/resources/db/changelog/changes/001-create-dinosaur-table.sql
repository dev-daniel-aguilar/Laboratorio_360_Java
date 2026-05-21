CREATE TABLE dinosaur (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    species VARCHAR(100) NOT NULL,

    carnivore BOOLEAN NOT NULL,

    energy INT NOT NULL

);