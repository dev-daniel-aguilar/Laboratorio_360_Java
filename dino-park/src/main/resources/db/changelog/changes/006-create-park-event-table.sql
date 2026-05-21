CREATE TABLE park_event (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    event_type VARCHAR(100) NOT NULL,

    description VARCHAR(255) NOT NULL,

    active BOOLEAN NOT NULL,

    created_at TIMESTAMP NOT NULL

);