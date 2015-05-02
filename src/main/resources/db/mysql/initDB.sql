DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_type;

CREATE TABLE product_type (
  id int(11) NOT NULL AUTO_INCREMENT,
  type varchar(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY type_UNIQUE (type)
) ENGINE=InnoDB;

CREATE TABLE products (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(64) NOT NULL,
  type_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (type_id) REFERENCES product_type(id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB;



