create database sistema_bancario;

use sistema_bancario;

create table pessoas (
	id int auto_increment,
	nome varchar(255),
	endereco varchar(255),
	cep varchar(255),
	telefone varchar(255),
	renda decimal(10,2),
	situacao boolean,
	primary key (id)
);

create table pessoas_fisicas(
	id_pessoa int,
	cpf varchar(255),
	rg varchar(255),
	sexo varchar(50),
	primary key(id_pessoa),
	foreign key (id_pessoa) references pessoas(id) on delete cascade
);

create table pessoas_juridicas(
	id_pessoa int,
	cnpj varchar(255),
	primary key(id_pessoa),
	foreign key (id_pessoa) references pessoas(id) on delete cascade
);