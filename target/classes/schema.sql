drop table if exists colaborador;
drop sequence if exists sq_id_colaborador;
create sequence sq_id_colaborador start with 1;
create table colaborador (
  id integer constraint pk_id_colaborador primary key,
  nome varchar_ignorecase(50) not null,
  cpf char(11) unique not null,
  cargo integer(10) not null,
  salario decimal(20,2) not null,
  nascimento date(10) not null
);