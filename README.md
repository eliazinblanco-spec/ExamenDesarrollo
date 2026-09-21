USE sauap;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS horario;
DROP TABLE IF EXISTS asignacion_docente;
DROP TABLE IF EXISTS profesor;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS asignatura;
DROP TABLE IF EXISTS grupo;

SET FOREIGN_KEY_CHECKS = 1;

-- Tabla persona
CREATE TABLE persona (
id_persona INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
apellido_paterno VARCHAR(50) NOT NULL,
apellido_materno VARCHAR(50) NOT NULL,
PRIMARY KEY (id_persona)
) ENGINE=InnoDB;

INSERT INTO persona VALUES
(1,'juan','rojo','lara');

-- Tabla profesor
CREATE TABLE profesor (
id_profesor INT NOT NULL AUTO_INCREMENT,
id_persona INT NOT NULL,
RFC VARCHAR(13) NOT NULL,
tipo_contrato VARCHAR(20) NOT NULL,
PRIMARY KEY (id_profesor),
UNIQUE KEY (RFC),
KEY (id_persona),
CONSTRAINT profesor_ibfk_1
FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
) ENGINE=InnoDB;

INSERT INTO profesor VALUES
(14,1,'abcdqwertyuio');

-- Tabla asignatura
CREATE TABLE asignatura (
id_asignatura INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
num_horas_clase INT NOT NULL,
num_horas_taller INT NOT NULL,
num_horas_laboratorio INT NOT NULL,
PRIMARY KEY (id_asignatura)
) ENGINE=InnoDB;

INSERT INTO asignatura VALUES
(1414,'español',1,3,2);

-- Tabla grupo
CREATE TABLE grupo (
id_grupo INT NOT NULL AUTO_INCREMENT,
codigo_grupo INT NOT NULL,
numero_grupo INT NOT NULL,
PRIMARY KEY (id_grupo),
UNIQUE KEY (codigo_grupo,numero_grupo)
) ENGINE=InnoDB;

INSERT INTO grupo VALUES
(2,3,210);

-- Tabla asignacion_docente
CREATE TABLE asignacion_docente (
id_asignacion_docente INT NOT NULL AUTO_INCREMENT,
id_profesor INT NOT NULL,
id_asignatura INT NOT NULL,
id_grupo INT NOT NULL,
fecha_asignacion DATE NOT NULL,
estado_asignacion VARCHAR(20) NOT NULL,
PRIMARY KEY (id_asignacion_docente),
KEY (id_profesor),
KEY (id_asignatura),
KEY (id_grupo),
CONSTRAINT asignacion_docente_ibfk_1
FOREIGN KEY (id_profesor) REFERENCES profesor(id_profesor),
CONSTRAINT asignacion_docente_ibfk_2
FOREIGN KEY (id_asignatura) REFERENCES asignatura(id_asignatura),
CONSTRAINT asignacion_docente_ibfk_3
FOREIGN KEY (id_grupo) REFERENCES grupo(id_grupo)
) ENGINE=InnoDB;

INSERT INTO asignacion_docente VALUES
(10,14,1414,2,'2003-02-02','mexicali','planta');

-- Tabla horario
CREATE TABLE horario (
id_horario INT NOT NULL AUTO_INCREMENT,
id_asignacion_docente INT NOT NULL,
dia_semana ENUM('Lunes','Martes','Miércoles','Jueves','Viernes','Sábado') NOT NULL,
hora_inicio TIME NOT NULL,
hora_fin TIME NOT NULL,
aula VARCHAR(20),
PRIMARY KEY (id_horario),
KEY (id_asignacion_docente),
CONSTRAINT horario_ibfk_1
FOREIGN KEY (id_asignacion_docente)
REFERENCES asignacion_docente(id_asignacion_docente)
) ENGINE=InnoDB;

-- Tabla usuario
CREATE TABLE usuario (
id_usuario INT NOT NULL AUTO_INCREMENT,
nombre_usuario VARCHAR(50) NOT NULL,
contrasena_hash VARCHAR(255) NOT NULL,
rol ENUM('administrador','profesor') NOT NULL,
id_profesor INT DEFAULT NULL,
PRIMARY KEY (id_usuario),
UNIQUE KEY (nombre_usuario),
KEY (id_profesor),
CONSTRAINT usuario_ibfk_1
FOREIGN KEY (id_profesor) REFERENCES profesor(id_profesor)
) ENGINE=InnoDB;