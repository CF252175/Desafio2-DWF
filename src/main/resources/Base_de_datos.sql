-- Crear la base de datos y seleccionarla
CREATE DATABASE IF NOT EXISTS clinica_db;
USE clinica_db;

-- Crear las tablas con la nueva estructura
CREATE TABLE profesor (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL
);

CREATE TABLE materia (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre_materia VARCHAR(100) NOT NULL,
                         id_profesor BIGINT,
                         FOREIGN KEY (id_profesor) REFERENCES profesor(id)
);

CREATE TABLE alumno (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombres VARCHAR(100) NOT NULL,
                        apellidos VARCHAR(100) NOT NULL
);

CREATE TABLE alumno_materia (
                                id_alumno BIGINT,
                                id_materia BIGINT,
                                PRIMARY KEY (id_alumno, id_materia),
                                FOREIGN KEY (id_alumno) REFERENCES alumno(id),
                                FOREIGN KEY (id_materia) REFERENCES materia(id)
);

-- Insertar Profesores (Docentes)
INSERT INTO profesor (nombre) VALUES
                                  ('Dr. Armando Mendoza'),
                                  ('Dra. Beatriz Pinzón'),
                                  ('Lic. Marcela Valencia'),
                                  ('Dr. Hugo Lombardi'),
                                  ('Dra. Catalina Angel');

-- Insertar Materias (Asignaturas)
INSERT INTO materia (nombre_materia, id_profesor) VALUES
                                                      ('Matemáticas Básicas', 1),
                                                      ('Literatura y Lenguaje', 2),
                                                      ('Historia Universal', 3),
                                                      ('Física Fundamental', 4),
                                                      ('Química General', 5);

-- Insertar Alumnos (Estudiantes)
INSERT INTO alumno (nombres, apellidos) VALUES
                                            ('Mario', 'Calderón'),
                                            ('Patricia', 'Fernández'),
                                            ('Nicolás', 'Mora'),
                                            ('Sandra', 'Patiño'),
                                            ('Aura Maria', 'Fuentes');

-- Relacionar Alumnos con Materias (Inscripciones)
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES
                                                       (1, 1),
                                                       (2, 2),
                                                       (3, 3),
                                                       (4, 4),
                                                       (5, 5),
                                                       (1, 4),
                                                       (3, 1);