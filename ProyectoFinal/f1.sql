DROP DATABASE IF EXISTS f1;
CREATE DATABASE f1;
USE f1;

-- TABLAS PRINCIPALES

CREATE TABLE proveedores (
    identificador INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE indumentaria (
    nombre VARCHAR(100) PRIMARY KEY
);

CREATE TABLE motores (
    numero_de_chasis VARCHAR(30) PRIMARY KEY
);

CREATE TABLE piloto (
    codigo VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(60) NOT NULL,
    fecha_de_nacimiento DATE NOT NULL
);

CREATE TABLE auto (
    identificador INT PRIMARY KEY,
    ano_de_fabricacion INT NOT NULL,
    modelo VARCHAR(100) NOT NULL
);

CREATE TABLE escuderia (
    identificador INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE temporada (
    ano INT PRIMARY KEY
);

CREATE TABLE circuito (
    identificador INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais VARCHAR(60) NOT NULL,
    longitud DECIMAL(6,3) NOT NULL,
    cantidad_de_vueltas INT NOT NULL
);

CREATE TABLE gran_premio (
    identificador INT PRIMARY KEY,
    fecha DATE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    CONSTRAINT fk_gp_temporada
        FOREIGN KEY (ano) REFERENCES temporada(ano)
);


-- RESULTADO


CREATE TABLE resultado (
    codigo_piloto VARCHAR(20) NOT NULL,
    identificador_auto INT NOT NULL,
    identificador_gran_premio INT NOT NULL,
    resultado INT NOT NULL,

    PRIMARY KEY (
        codigo_piloto,
        identificador_auto,
        identificador_gran_premio
    ),

    CONSTRAINT fk_resultado_piloto
        FOREIGN KEY (codigo_piloto) REFERENCES piloto(codigo),

    CONSTRAINT fk_resultado_auto
        FOREIGN KEY (identificador_auto) REFERENCES auto(identificador),

    CONSTRAINT fk_resultado_gran_premio
        FOREIGN KEY (identificador_gran_premio)
        REFERENCES gran_premio(identificador)
);

-- TABLAS DE RELACIONES

CREATE TABLE provee_indumentaria (
    identificador_proveedor INT NOT NULL,
    nombre_indumentaria VARCHAR(100) NOT NULL,

    PRIMARY KEY (
        identificador_proveedor,
        nombre_indumentaria
    ),

    CONSTRAINT fk_pi_proveedor
        FOREIGN KEY (identificador_proveedor)
        REFERENCES proveedores(identificador),

    CONSTRAINT fk_pi_indumentaria
        FOREIGN KEY (nombre_indumentaria)
        REFERENCES indumentaria(nombre)
);

CREATE TABLE provee_motor (
    identificador_proveedor INT NOT NULL,
    numero_de_chasis VARCHAR(30) NOT NULL,

    PRIMARY KEY (
        identificador_proveedor,
        numero_de_chasis
    ),

    CONSTRAINT fk_pm_proveedor
        FOREIGN KEY (identificador_proveedor)
        REFERENCES proveedores(identificador),

    CONSTRAINT fk_pm_motor
        FOREIGN KEY (numero_de_chasis)
        REFERENCES motores(numero_de_chasis)
);

CREATE TABLE dueno (
    identificador_auto INT NOT NULL,
    ano INT NOT NULL,
    identificador_escuderia INT NOT NULL,

    PRIMARY KEY (
        identificador_auto,
        ano
    ),

    CONSTRAINT fk_dueno_auto
        FOREIGN KEY (identificador_auto)
        REFERENCES auto(identificador),

    CONSTRAINT fk_dueno_temporada
        FOREIGN KEY (ano)
        REFERENCES temporada(ano),

    CONSTRAINT fk_dueno_escuderia
        FOREIGN KEY (identificador_escuderia)
        REFERENCES escuderia(identificador)
);

CREATE TABLE asignado (
    codigo_piloto VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    identificador_auto INT NOT NULL,

    PRIMARY KEY (
        codigo_piloto,
        ano
    ),

    CONSTRAINT fk_asignado_piloto
        FOREIGN KEY (codigo_piloto)
        REFERENCES piloto(codigo),

    CONSTRAINT fk_asignado_temporada
        FOREIGN KEY (ano)
        REFERENCES temporada(ano),

    CONSTRAINT fk_asignado_auto
        FOREIGN KEY (identificador_auto)
        REFERENCES auto(identificador)
);

CREATE TABLE pertenece (
    identificador_gran_premio INT NOT NULL,
    identificador_circuito INT NOT NULL,

    PRIMARY KEY (
        identificador_gran_premio,
        identificador_circuito
    ),

    CONSTRAINT fk_pertenece_gp
        FOREIGN KEY (identificador_gran_premio)
        REFERENCES gran_premio(identificador),

    CONSTRAINT fk_pertenece_circuito
        FOREIGN KEY (identificador_circuito)
        REFERENCES circuito(identificador)
);


USE f1;

-- DATOS DE PRUEBA
-- PROVEEDORES


INSERT INTO proveedores (identificador, nombre) VALUES
(1, 'Pirelli'),
(2, 'Sparco'),
(3, 'OMP');


-- INDUMENTARIA


INSERT INTO indumentaria (nombre) VALUES
('Guantes'),
('Casco'),
('Botas'),
('Traje');


-- MOTORES


INSERT INTO motores (numero_de_chasis) VALUES
('MTR-001'),
('MTR-002'),
('MTR-003'),
('MTR-004');


-- PILOTOS


INSERT INTO piloto
(codigo, nombre, nacionalidad, fecha_de_nacimiento)
VALUES
('P001', 'Carlos Ruiz', 'Uruguay', '2000-04-15'),
('P002', 'Mateo Silva', 'Argentina', '1999-08-21'),
('P003', 'Lucas Rossi', 'Italia', '2001-02-10'),
('P004', 'Diego Martin', 'España', '1998-11-03'),
('P005', 'Tom Brown', 'Reino Unido', '1997-06-27');

-- AUTOS


INSERT INTO auto
(identificador, ano_de_fabricacion, modelo)
VALUES
(101, 2024, 'F1-A24'),
(102, 2024, 'F1-B24'),
(103, 2025, 'F1-A25'),
(104, 2025, 'F1-B25'),
(105, 2025, 'F1-C25');


-- ESCUDERIAS


INSERT INTO escuderia (identificador, nombre) VALUES
(1, 'Escuderia Alfa'),
(2, 'Escuderia Beta'),
(3, 'Escuderia Gamma');


-- TEMPORADAS


INSERT INTO temporada (ano) VALUES
(2024),
(2025);


-- CIRCUITOS


INSERT INTO circuito
(identificador, nombre, pais, longitud, cantidad_de_vueltas)
VALUES
(1, 'Circuito del Plata', 'Uruguay', 4.326, 71),
(2, 'Circuito de Buenos Aires', 'Argentina', 5.891, 58),
(3, 'Circuito de Monza', 'Italia', 5.793, 53);

-- GRANDES PREMIOS


INSERT INTO gran_premio
(identificador, fecha, nombre, ano)
VALUES
(1, '2024-03-10', 'Gran Premio del Plata', 2024),
(2, '2024-04-21', 'Gran Premio de Buenos Aires', 2024),
(3, '2025-03-16', 'Gran Premio del Plata', 2025),
(4, '2025-09-07', 'Gran Premio de Monza', 2025);


-- RELACION PROVEEDOR-INDUMENTARIA


INSERT INTO provee_indumentaria
(identificador_proveedor, nombre_indumentaria)
VALUES
(2, 'Guantes'),
(2, 'Traje'),
(3, 'Casco'),
(3, 'Botas');


-- RELACION PROVEEDOR-MOTOR


INSERT INTO provee_motor
(identificador_proveedor, numero_de_chasis)
VALUES
(1, 'MTR-001'),
(1, 'MTR-002'),
(2, 'MTR-003'),
(3, 'MTR-004');


-- RELACION AUTO-ESCUDERIA-TEMPORADA


INSERT INTO dueno
(identificador_auto, ano, identificador_escuderia)
VALUES
(101, 2024, 1),
(102, 2024, 2),
(103, 2025, 1),
(104, 2025, 2),
(105, 2025, 3);


-- RELACION PILOTO-AUTO-TEMPORADA


INSERT INTO asignado
(codigo_piloto, ano, identificador_auto)
VALUES
('P001', 2024, 101),
('P002', 2024, 102),
('P003', 2025, 103),
('P004', 2025, 104),
('P005', 2025, 105);


-- RELACION GRAN PREMIO-CIRCUITO


INSERT INTO pertenece
(identificador_gran_premio, identificador_circuito)
VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 3);


-- RESULTADOS


INSERT INTO resultado
(codigo_piloto, identificador_auto, identificador_gran_premio, resultado)
VALUES
('P001', 101, 1, 1),
('P002', 102, 1, 2),
('P001', 101, 2, 3),
('P002', 102, 2, 1),
('P003', 103, 3, 1),
('P004', 104, 3, 2),
('P005', 105, 3, 3),
('P003', 103, 4, 2),
('P004', 104, 4, 1),
('P005', 105, 4, 3);
