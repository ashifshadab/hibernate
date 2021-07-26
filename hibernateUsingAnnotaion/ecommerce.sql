CREATE DATABASE ecommerce;

USE ecommerce;

CREATE TABLE SELLER (
code VARCHAR(6) PRIMARY KEY,
name VARCHAR(64) NOT NULL,
address VARCHAR(128) NOT NULL,
UNIQUE (name)
);



CREATE TABLE PRODUCT (
sku VARCHAR(13) PRIMARY KEY,
name VARCHAR(64) NOT NULL,
price DECIMAL(8, 2),
seller VARCHAR(6),
FOREIGN KEY (SELLER) REFERENCES SELLER (code),
UNIQUE (name)
);

insert into SELLER(code, name, address) values('MAS', 'Ashif Shadab', 'Delhi');
insert into SELLER(code, name, address) values('SAM', 'Karn', 'Noida');

insert into PRODUCT(sku,name,seller,price) values('SKU001', 'Java Persistence with Hibernate', 'MAS', 2000);
insert into PRODUCT(sku,name,seller,price) values('SKU002', 'Just HibernateJust Hibernate', 'SAM', 3000);
