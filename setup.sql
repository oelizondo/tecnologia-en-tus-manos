DROP DATABASE tetm;
CREATE DATABASE tetm;

\c tetm

CREATE TABLE Administrador(
  ID       SERIAL PRIMARY KEY NOT NULL,
  nombre   VARCHAR(50) NOT NULL,
  telefono VARCHAR(16) NOT NULL,
  mail     VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE Estudiante (
  ID       SERIAL PRIMARY KEY NOT NULL,
  IdAdmin  INT REFERENCES Administrador(ID) NOT NULL,
  nombre   VARCHAR(50) NOT NULL,
  telefono VARCHAR(16) NOT NULL,
  mail     VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE Ejercicio (
  ID              SERIAL PRIMARY KEY NOT NULL,
  IdAdministrador INT REFERENCES Administrador(ID) NOT NULL,
  pregunta        TEXT NOT NULL,
  respuesta       VARCHAR(200) NOT NULL
);

CREATE TABLE Lectura (
  ID              SERIAL PRIMARY KEY NOT NULL,
  IdEjercicio     INT REFERENCES Ejercicio(ID) NOT NULL,
  IdAdministrador INT REFERENCES Administrador(ID) NOT NULL,
  capitulo        VARCHAR(50) NOT NULL,
  seccion         VARCHAR(50) NOT NULL,
  contenido       TEXT
);

CREATE TABLE EstudianteLectura (
  IdEstudiante INT REFERENCES Estudiante(ID) NOT NULL,
  IdLectura    INT REFERENCES Lectura(ID)    NOT NULL
);

CREATE TABLE Calificacion (
  IdEstudiante INT REFERENCES Estudiante(ID) NOT NULL,
  IdEjercicio  INT REFERENCES Ejercicio(ID)  NOT NULL,
  calificacion INT NOT NULL,
  CONSTRAINT IdCalificacion PRIMARY KEY (IdEstudiante, IdEjercicio)
);

INSERT INTO Lectura (idejercicio, idadministrador, capitulo, seccion, contenido)
       VALUES (1,1, 'capitulo 1', 'seccion 1', 'contenido de la primera lectura');

INSERT INTO Lectura (idejercicio, idadministrador, capitulo, seccion, contenido)
       VALUES (1,1, 'capitulo 2', 'seccion 2', 'contenido de la segunda lectura');