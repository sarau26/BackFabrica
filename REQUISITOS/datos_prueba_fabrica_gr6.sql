
# DECANOS
insert into decano values(
	109648521,#id_decano numeric(15),
    'María Alejandra Gutierrez Jimenez',#nombre varchar(50),
    'maria.gutierrezj@udea.edu.co',#email varchar(50) UNIQUE,
    '6-408',#oficina varchar(20),    
    'Ciencias Exactas'#name_facultad varchar(20),
);

insert into decano values(
	46821506,#id_decano numeric(15),
    'Juan Esteban Ramirez Higuita',#nombre varchar(50),
    'juan.ramirezh24@udea.edu.co',#email varchar(50) UNIQUE,
    '20-401',#oficina varchar(20),    
    'Ingeniería'#name_facultad varchar(20),
);
-------------------------------------------------------------------
# VICEDECANOS
insert into vice_decano values(
    67511384,#id_vicedecano numeric(15),
    'José Antonio Álvarez Herrera',#nombre varchar(50),
    'josea.alvarezh4@udea.edu.co',#email varchar(50) UNIQUE,
    '6-407',#oficina varchar(20),    
    'Ciencias Exactas'#name_facultad varchar(20),
);

insert into vice_decano values(
	97012546,#id_vicedecano numeric(15),
    'Laura Valentina Vergara Hincapie',#nombre varchar(50),
    'laurav.vergarah1@udea.edu.co',#email varchar(50) UNIQUE,
    '20-402',#oficina varchar(20),    
    'Ingeniería'#name_facultad varchar(20),
);
-------------------------------------------------------------------
# ESTUDIANTES
insert into estudiante values(
	1024679532,#id_estudiante numeric(15),
    'Alberto Yepes',#nombre varchar(50),
    'alberto.yepes13@udea.edu.co',#email varchar(50) UNIQUE,
    105,#id_programa numeric(5),    
    4, #semestre numeric(2),
    3 #nivel numeric(2) UNIQUE,
);

insert into estudiante values(
	1506348952,#id_estudiante numeric(15),
    'Manuela Echeverri',#nombre varchar(50),
    'manuela.echeverri3@udea.edu.co',#email varchar(50) UNIQUE,
    503,#id_programa numeric(5),    
    7, #semestre numeric(2),
    5 #nivel numeric(2) UNIQUE,
);
-------------------------------------------------------------------
# DOCENTE
insert into docente values(
	97643250,#id_persona numeric(15),
    'Planta',#tipo_contrato varchar(30),
    'Eduardo Alvarez Ramirez',#nombre varchar(50),
    'eduardo.ar@udea.edu.co'#email varchar(50),
);

insert into docente values(
	79462187,#id_persona numeric(15),
    'Cátedra',#tipo_contrato varchar(30),
    'Luis Emilio Gonzalez Rodriguez',#nombre varchar(50),
    'luise.gonzalezr@udea.edu.co'#email varchar(50),
);
-------------------------------------------------------------------
# MATERIAS
insert into materia values(
	495,#id_materia numeric(3),
    'Algebra',#nombre varchar(30),
    null#linea_enfasis varchar(10),
);

insert into materia values(
	611,#id_materia numeric(3),
    'Optimizacion',#nombre varchar(30),
    'C datos'#linea_enfasis varchar(10),
);
-------------------------------------------------------------------
# AULAS
insert into aula values(
	'20-308',#id_aula varchar(6),
    20,#bloque numeric(2),
    308,#salon numeric(3),
    30#capacidad numeric(3),
);

insert into aula values(
	'18-210',#id_aula varchar(6),
    18,#bloque numeric(2),
    210,#salon numeric(3),
    50#capacidad numeric(3),
);
------------------------------------------------------------------
# FACULTAD
insert into facultad values(
	10,#id numeric(2),
    'Ciencias Exactas',#nombre varchar(20),    
    109648521,#id_decano numeric(15),
    67511384#id_vicedecano numeric(15),
);

insert into facultad values(
	25,#id numeric(2),
    'Ingeniería',#nombre varchar(20),
    46821506,#id_decano numeric(15),
    97012546#id_vicedecano numeric(15),
);
select * from facultad;
------------------------------------------------------------------
# CALENDARIOS
insert into calendario values(
	'10-2023-1', #id varchar(9),
    10, #id_facultad numeric(2),
    '2023-1', #semestre varchar(6),
    '2022-12-08', #publicacion_oferta date,
    '2022-12-12', #inicio_matriculas date,
    '2022-12-13', #fin_matriculas date,
    '2022-12-15', #inicio_ajustes date,
    '2023-01-27', #fin_ajustes date,
    '2023-02-01', #inicio_clases date,
    '2023-05-27', #fin_clases date,
    '2023-05-29', #inicio_examenes_finales date,
    '2023-06-03', #fin_examenes_finales date,
    '2022-12-12', #inicio_validaciones date,
    '2023-06-05', #fin_validaciones date,
    '2023-06-05', #inicio_habilitaciones date,
    '2023-06-10', #fin_habilitaciones date,    
    '2023-06-13'  #terminacion_oficinal date,    
);

insert into calendario values(
	'25-2022-2', #id varchar(9),
    25, #id_facultad numeric(2),    
    '2022-2', #semestre varchar(6),
    '2022-11-27', #publicacion_oferta date,
    '2022-11-29', #inicio_matriculas date,
    '2022-11-29', #fin_matriculas date,
    '2022-12-02', #inicio_ajustes date,
    '2022-12-14', #fin_ajustes date,
    '2023-01-16', #inicio_clases date,
    '2023-05-12', #fin_clases date,
    '2023-05-15', #inicio_examenes_finales date,
    '2023-05-19', #fin_examenes_finales date,
    '2022-11-29', #inicio_validaciones date,
    '2023-05-23', #fin_validaciones date,
    '2023-05-23', #inicio_habilitaciones date,
    '2023-05-26', #fin_habilitaciones date,    
    '2023-05-26'  #terminacion_oficinal date,    
);
------------------------------------------------------------------
# CURSOS
insert into curso values(
	2515611,#codigo_curso numeric(7),
    611,#id_materia numeric(3),
    3,#credits_number numeric(2),
    null,#prerequisite varchar(10),
    '2539495'#correquisite varchar(10),
);

insert into curso values(
	2539495,#codigo_curso numeric(7),
    495,#id_materia numeric(3),
    3,#credits_number numeric(2),
    '2515611',#prerequisite varchar(10),
    null#correquisite varchar(10),
);
------------------------------------------------------------------
# GRUPOS
select * from grupo;
insert into grupo values(
    '2539495-1',#id_grupo varchar(10),
    2539495,#codigo_curso numeric(7),
    1,#numero numeric(2),
    30#cupos numeric(2),
);

insert into grupo values(
    '2539495-2',#id_grupo varchar(10),
    2539495,#codigo_curso numeric(7),
    2,#numero numeric(2),
    40#cupos numeric(2),
);

insert into grupo values(
    '2515611-1',#id_grupo varchar(10),
    2515611,#codigo_curso numeric(7),
    1,#numero numeric(2),
    20#cupos numeric(2),
);

insert into grupo values(
    '2515611-2',#id_grupo varchar(10),
    2515611,#codigo_curso numeric(7),
    2,#numero numeric(2),
    30#cupos numeric(2),
);

insert into grupo values(
    '2515611-3',#id_grupo varchar(10),
    2515611,#codigo_curso numeric(7),
    3,#numero numeric(2),
    10#cupos numeric(2),
);
------------------------------------------------------------------
# HORARIO
insert into horario values(
	'18-210',#id_aula varchar(6),
    '2515611-1',#id_grupo varchar(10),
    'L',#dia varchar(1),
    '10:00:00',#hora_inicio Time,
    '12:00:00'#hora_fin Time,
);

insert into horario values(
	'18-210',#id_aula varchar(6),
    '2515611-1',#id_grupo varchar(10),
    'W',#dia varchar(1),
    '10:00:00',#hora_inicio Time,
    '12:00:00'#hora_fin Time,
);

insert into horario values(
	'18-210',#id_aula varchar(6),
    '2515611-2',#id_grupo varchar(10),
    'L',#dia varchar(1),
    '12:00:00',#hora_inicio Time,
    '14:00:00'#hora_fin Time,
);

insert into horario values(
	'18-210',#id_aula varchar(6),
    '2515611-2',#id_grupo varchar(10),
    'W',#dia varchar(1),
    '12:00:00',#hora_inicio Time,
    '14:00:00'#hora_fin Time,
);

insert into horario values(
	'20-308',#id_aula varchar(6),
    '2539495-1',#id_grupo varchar(10),
    'V',#dia varchar(1),
    '14:00:00',#hora_inicio Time,
    '18:00:00'#hora_fin Time,
);

insert into horario values(
	'20-308',#id_aula varchar(6),
    '2539495-2',#id_grupo varchar(10),
    'V',#dia varchar(1),
    '14:00:00',#hora_inicio Time,
    '18:00:00'#hora_fin Time,
);
-------------------------------------------------------------------
# DOCENTE-GRUPO
insert into docente_grupo values(
	97643250,#id_docente numeric(15),
    '2539495-1'#id_grupo varchar(10),
);

insert into docente_grupo values(
	97643250,#id_docente numeric(15),
    '2539495-2'#id_grupo varchar(10),
);

insert into docente_grupo values(
	79462187,#id_docente numeric(15),
    '2515611-1'#id_grupo varchar(10),
);

insert into docente_grupo values(
	79462187,#id_docente numeric(15),
    '2515611-2'#id_grupo varchar(10),
);

insert into docente_grupo values(
	79462187,#id_docente numeric(15),
    '2515611-3'#id_grupo varchar(10),
);
-------------------------------------------------------------------
# ESTUDIANTE POR GRUPO
insert into estudiante_grupo values(
	1024679532,#id_estudiante numeric(15),
	'2515611-1'#id_grupo varchar(10),
);

insert into estudiante_grupo values(
	1506348952,#id_estudiante numeric(15),
	'2515611-3'#id_grupo varchar(10),
);

insert into estudiante_grupo values(
	1024679532,#id_estudiante numeric(15),
	'2539495-1'#id_grupo varchar(10),
);

insert into estudiante_grupo values(
	1506348952,#id_estudiante numeric(15),
	'2539495-2'#id_grupo varchar(10),
);