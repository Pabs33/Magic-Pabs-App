DROP DATABASE IF EXISTS magicpabs;

CREATE SCHEMA magicpabs DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE magicpabs;

-- Creacion de las tablas

CREATE TABLE clientes(
	id_cliente INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(255)
);


-- La idea es que un espectaculo contenga muchos juegos y cada juego puede estar en varios espectaculos si es necesario
CREATE TABLE espectaculos(
	id_espectaculo INTEGER PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
    duracion INTEGER
);

CREATE TABLE eventos(
	id_evento INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_cliente_eventos INTEGER,
    fecha VARCHAR(255),
    direccion VARCHAR(255),
    tipo_evento VARCHAR(255),
    id_espectaculo_eventos INTEGER,
    FOREIGN KEY(id_cliente_eventos) REFERENCES clientes(id_cliente),
    FOREIGN KEY(id_espectaculo_eventos) REFERENCES espectaculos(id_espectaculo)
);



-- Insetar valores de prueba

INSERT INTO clientes (id_cliente, nombre, email, telefono) VALUES
	(0, "Paco", "paco@mail.com", "123456789"),
    (0, "Mario", "mario@mail.com", "987123657");
    
INSERT INTO espectaculos (id_espectaculo, titulo, descripcion, duracion) VALUES
	(0, "Ahora", "Espectaculo de magia familiar", 30),
    (0, "Mentalismo", "Espectaulo de mentalismo", 30);

INSERT INTO eventos (id_evento, id_cliente_eventos, fecha, direccion, tipo_evento, id_espectaculo_eventos) VALUES
	(0, 1, "01/03/2022", "calle prueba 1", "cumpleaños", 1),
    (0, 2, "12/07/2022", "calle prueba 2", "Boda", 2);

