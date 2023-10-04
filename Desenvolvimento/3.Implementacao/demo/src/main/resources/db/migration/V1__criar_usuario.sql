CREATE TABLE users (
    id int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    login varchar(50) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);