CREATE DATABASE oakBarDB;

USE oakBarDB;

CREATE TABLE brands (
  brand_id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  brand_name VARCHAR(25),
  flag_state BOOLEAN,
  PRIMARY KEY(brand_id)
);

CREATE TABLE products (
  product_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(40),
  actual_price DECIMAL,
  flag_state BOOLEAN,
  brand_id TINYINT UNSIGNED,
  PRIMARY KEY(product_id)
);

CREATE TABLE product_items (
  product_item_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  elaboration_date DATETIME,
  price DECIMAL,
  flag_state BOOLEAN,
  product_id SMALLINT UNSIGNED,
  detail_id BIGINT UNSIGNED,
  PRIMARY KEY(product_item_id)
);

CREATE TABLE details (
  detail_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sale_date DATETIME,
  flag_state BOOLEAN,
  way_pay_id TINYINT UNSIGNED,
  PRIMARY KEY(detail_id)
);

CREATE TABLE ways_pay (
  way_pay_id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  denomination VARCHAR(15),
  flag_state BOOLEAN,
  PRIMARY KEY(way_pay_id)
);


/*
se agregan las claves foraneas de las tablas creadas
(tabla origen) -> (tabla destino)
tabla origen: la que será referenciada
tabla destino: la que tendrá la clave foranea
*/
ALTER TABLE products
  ADD CONSTRAINT fk__brands__products
  FOREIGN KEY(brand_id) REFERENCES brands(brand_id);

ALTER TABLE details
  ADD CONSTRAINT fk__ways_pay__details
  FOREIGN KEY(way_pay_id) REFERENCES ways_pay(way_pay_id);

ALTER TABLE product_items
  ADD CONSTRAINT fk__products__product_items
  FOREIGN KEY(product_id) REFERENCES products(product_id),
  ADD CONSTRAINT fk__details__product_items
  FOREIGN KEY(detail_id) REFERENCES details(detail_id);
