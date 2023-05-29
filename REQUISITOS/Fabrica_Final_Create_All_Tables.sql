CREATE SCHEMA `fabrica_g6_v2` DEFAULT CHARACTER SET utf8mb4;# COLLATE utf8mb4_0900_ai_ci ;
CREATE TABLE decano(
                       id_decano numeric(15),
                       nombre varchar(50),
                       email varchar(50) UNIQUE,
                       oficina varchar(20),
                       name_facultad varchar(20),
                       CONSTRAINT decano_pf PRIMARY KEY (id_decano)
);
CREATE TABLE vice_decano(
                            id_vicedecano numeric(15),
                            nombre varchar(50),
                            email varchar(50) UNIQUE,
                            oficina varchar(20),
                            name_facultad varchar(20),
                            CONSTRAINT vide_decano_pf PRIMARY KEY (id_vicedecano)
);
create table docente (
                         id_docente numeric(15),
                         tipo_contrato varchar(30),
                         nombre varchar(50),
                         email varchar(50),
                         primary key (id_docente)
);
create table materia (
                         id_materia numeric(3),
                         nombre varchar(30),
                         linea_enfasis varchar(30),
                         primary key (id_materia)
);

create table aula (
                      id_aula varchar(6),
                      bloque numeric(2),
                      salon numeric(3),
                      capacidad numeric(3),
                      primary key (id_aula)
);

CREATE TABLE facultad(
                         id numeric(2),
                         nombre varchar(40),
                         id_decano numeric(15),
                         id_vicedecano numeric(15),
                         FOREIGN KEY (id_vicedecano) REFERENCES vice_decano(id_vicedecano),
                         FOREIGN KEY (id_decano) REFERENCES decano(id_decano),
                         CONSTRAINT facultad_pk PRIMARY KEY (id)
);

CREATE TABLE calendario(
                           id varchar(9),
                           id_facultad numeric(2),
                           semestre varchar(6),
                           publicacion_oferta date,
                           inicio_matriculas date,
                           fin_matriculas date,
                           inicio_ajustes date,
                           fin_ajustes date,
                           inicio_clases date,
                           fin_clases date,
                           inicio_examenes_finales date,
                           fin_examenes_finales date,
                           inicio_validaciones date,
                           fin_validaciones date,
                           inicio_habilitaciones date,
                           fin_habilitaciones date,
                           terminacion_oficinal date,
                           FOREIGN KEY (id_facultad) REFERENCES facultad(id),
                           CONSTRAINT calendario_pk PRIMARY KEY (id)
);
create table curso (
                       codigo_curso int(5) auto_increment,
                       id_materia numeric(3),
                       programa_academico varchar(60),
                       creditos numeric(2),
                       version_pensum numeric(2),
                       nivel_academico numeric(2),
                       intensidad_horaria numeric(2),
                       sede varchar(50),
                       grupos_espejo boolean,
                       validable boolean,
                       obligatorio boolean,
                       habilitable boolean,
                       primary key (codigo_curso),
                       constraint fk_id_materia
                           foreign key (id_materia)
                               references materia (id_materia)
);

create table grupo
(
    id_grupo     varchar(10),
    codigo_curso int(5),
    numero       numeric(2),
    cupos        numeric(2),
    docente      numeric(15),
    constraint fk_course_code
        foreign key (codigo_curso)
            references curso (codigo_curso),
    constraint fk_docente
        foreign key (docente)
            references docente (id_docente),
    primary key (id_grupo)
);


create table horario (
                         id varchar(17),
                         id_aula varchar(6),
                         id_grupo varchar(10),
                         dia varchar(1),
                         hora_inicio Time,
                         hora_fin Time,
                         constraint fk_id_aula
                             FOREIGN KEY (id_aula)
                                 REFERENCES aula (id_aula),
                         constraint fk_id_grupo
                             FOREIGN KEY (id_grupo)
                                 REFERENCES grupo (id_grupo)
);

alter table curso add constraint unique(id_materia, programa_academico, version_pensum);
