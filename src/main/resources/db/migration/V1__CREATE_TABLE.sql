CREATE TABLE location (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  create_date timestamp NOT NULL default CURRENT_TIMESTAMP,
  update_date timestamp,
  code varchar(10) NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(code)
);

CREATE TABLE hotel (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  create_date timestamp NOT NULL default CURRENT_TIMESTAMP,
  update_date timestamp,
  name varchar(100) NOT NULL,
  rooms int(3) NOT NULL,
  location_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  foreign key (location_id) references location(id)
);