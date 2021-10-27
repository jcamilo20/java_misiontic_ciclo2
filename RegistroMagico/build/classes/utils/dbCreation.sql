CREATE SCHEMA registromagico;
USE registromagico;

CREATE TABLE escuela(
esc_codigo int PRIMARY KEY,
esc_nombre varchar(30) UNIQUE NOT NULL,
esc_habilidad varchar(40) NOT NULL,
esc_anios_servicio int NOT NULL,
esc_creador varchar(20) NOT NULL,
esc_fecha_fundacion date NOT NULL
);

CREATE TABLE pocion(
poc_codigo int PRIMARY KEY,
poc_nombre varchar(30) NOT NULL,
poc_litros decimal(7,2) NULL DEFAULT 0,
poc_veces_usada int NULL DEFAULT 0,
esc_codigo_fk int NOT NULL,
FOREIGN KEY (esc_codigo_fk) REFERENCES escuela(esc_codigo)
);

CREATE TABLE ingrediente(
ingredi_codigo int PRIMARY KEY AUTO_INCREMENT,
ingredi_nombre varchar(30) NOT NULL,
ingredi_peso int NULL DEFAULT 0,
ingredi_reaccion decimal(3,1) NOT NULL,
ingredi_existe tinyint NOT NULL
);

CREATE TABLE receta(
rec_id int PRIMARY KEY AUTO_INCREMENT,
poc_codigo_fk int NOT NULL,
ingredi_codigo_fk int NOT NULL,
rec_fecha timestamp NOT NULL,
FOREIGN KEY (poc_codigo_fk) REFERENCES pocion(poc_codigo),
FOREIGN KEY (ingredi_codigo_fk) REFERENCES ingrediente(ingredi_codigo)
);

-- Inserta registros en la tabla escuela
INSERT INTO escuela (esc_codigo, esc_nombre, esc_habilidad, esc_anios_servicio, esc_creador, esc_fecha_fundacion) VALUES(232, "Gauchondor", "magia pura", 20, "Ronaldinhus", "2001-12-12");
INSERT INTO escuela (esc_codigo, esc_nombre, esc_habilidad, esc_anios_servicio, esc_creador, esc_fecha_fundacion) VALUES(9865, "Parmiterin", "velocidad", 13, "Asprillini", "2008-02-28");
INSERT INTO escuela (esc_codigo, esc_nombre, esc_habilidad, esc_anios_servicio, esc_creador, esc_fecha_fundacion) VALUES(22682, "Riventus", "precisión", 10, "Pirlotes", "2011-07-21");
INSERT INTO escuela (esc_codigo, esc_nombre, esc_habilidad, esc_anios_servicio, esc_creador, esc_fecha_fundacion) VALUES(428, "Castelobruxo", "invisibilidad", 12, "Cristiano", "2010-08-25");
INSERT INTO escuela (esc_codigo, esc_nombre, esc_habilidad, esc_anios_servicio, esc_creador, esc_fecha_fundacion) VALUES(66, "Hogwarts", "embrujos", 24, "Slytherin", "1999-06-12");
INSERT INTO escuela (esc_codigo, esc_nombre, esc_habilidad, esc_anios_servicio, esc_creador, esc_fecha_fundacion) VALUES(122, "Narnia", "resistencia", 11, "Aslam", "2000-06-12");


-- Inserta registros en la tabla pocion
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (12, "Bomba AntiResaca", 278.8, 400, 232);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (872, "Borojo con Tarrito Rojo", NULL, NULL, 9865);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (510, "Amortentia", 279.4, 500, 9865);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (410, "Brebaje bocazas", 249.43, 500, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (411, "Crece-huesos", 100.14, 100, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (13, "Doxycida", 178.5, 100, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (14, "Elixir de la vida eterna", 200.5, 10, 122);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (43, "Elixir del cerebro Baruffio", 115.45, 11, 428);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (44, "Elixir para provocar euforia", 110.65, 40, 22682);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (55, "Filtro de paz", 40.53, 15, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (53, "Filtro de muertos en vida", 55.43, 12, 428);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (610, "Infusión de hipo", 33.12, 80, 232);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (611, "Infusión de felicidad", 70.12, 44, 122);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (320, "Poción para arpías", 44.33, 111, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (321, "Poción crecedora de cabello", 55.33, 10, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (329, "Poción de curación", 44.33, 1, 428);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (359, "Poción desinfladora", 10.4, 6, 428);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (369, "Poción embellecedora", 101.4, 62, 122);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (529, "Poción envejecedora", 44.3, 2, 122);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (888, "Poción limpia-heridas", 112.3, 4, 122);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (889, "Poción de matalobos", 44.3, 33, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (11, "Poción multijugos", 11.2, 45, 66);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (17, "Poción pimentónica", 22.56, 12, 428);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (18, "Veritaserum", 78.33, 7, 9865);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (19, "Poción para encoger", 33.33, 71, 9865);
INSERT INTO pocion (poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (20, "Poción para engordar", 44.42, 22, 9865);




-- Inserta registros en la tabla ingrediente
INSERT INTO ingrediente (ingredi_codigo,ingredi_nombre, ingredi_peso, ingredi_reaccion, ingredi_existe) VALUES (1, "Soda", 394, 9.3, 1);
INSERT INTO ingrediente (ingredi_codigo,ingredi_nombre, ingredi_peso, ingredi_reaccion, ingredi_existe) VALUES (2, "Borojo", 123, 8.9, 1);
INSERT INTO ingrediente (ingredi_codigo,ingredi_nombre, ingredi_peso, ingredi_reaccion, ingredi_existe) VALUES (3, "Tarrito Rojo", NULL, 0.1, 0);

-- Inserta registros en la tabla receta
INSERT INTO receta (poc_codigo_fk, ingredi_codigo_fk, rec_fecha) VALUES (12,1,CURRENT_TIMESTAMP);
INSERT INTO receta (poc_codigo_fk, ingredi_codigo_fk, rec_fecha) VALUES (872,2,CURRENT_TIMESTAMP);
INSERT INTO receta (poc_codigo_fk, ingredi_codigo_fk, rec_fecha) VALUES (872,3,CURRENT_TIMESTAMP);
