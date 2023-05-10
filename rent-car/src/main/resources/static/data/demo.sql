CREATE TABLE GAMA (
    idGama                         int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name                           varchar(200),
    description                    varchar(200)
);

CREATE TABLE CAR (
    idCar                          int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name                           varchar(200),
    brand                          varchar(200),
    year                           int,
    description                    varchar(500),
    idGama                         int,
    FOREIGN KEY (idGama) REFERENCES gama(idGama)
);

CREATE TABLE CLIENT(
    idClient int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email varchar(450),
    password varchar(450),
    name varchar(450),
    age int
);

CREATE TABLE MESSAGE(
    idMessage int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idCar int,
    idClient int,
    messageText varchar(500),
    FOREIGN KEY (idCar) REFERENCES car(idCar),
    FOREIGN KEY (idClient) REFERENCES client(idClient)
);

CREATE TABLE RESERVATION (
    idReservation                 int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idClient                      int,
    idCar                         int,
    startDate                     datetime,
    devolutionDate                datetime,
    status                        varchar(200),
    FOREIGN KEY (idClient) REFERENCES client(idClient),
    FOREIGN KEY (idCar) REFERENCES car(idCar)
);

CREATE TABLE SCORE (
    idScore                      int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idReservation                int,
    name                         varchar(200),
    score                        int,
    FOREIGN KEY (idReservation) REFERENCES reservation(idReservation)
);

CREATE TABLE ADMIN_USER (
    idAdmin                        int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name                           varchar(200),
    email                          varchar(200),
    password                       varchar(200)
);
