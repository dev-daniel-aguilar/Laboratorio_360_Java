ALTER TABLE tourist

ADD COLUMN zone_id BIGINT;

ALTER TABLE tourist

ADD CONSTRAINT fk_tourist_zone

FOREIGN KEY (zone_id)

REFERENCES zone(id);