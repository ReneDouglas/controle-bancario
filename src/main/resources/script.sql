create database sistema_bancario;

use sistema_bancario;

create table pessoa (
	id int auto_increment,
	nome varchar(255),
	cpf varchar(255),
	rg varchar(255),
	cnpj varchar(255),
	endereco varchar(255),
	cep varchar(255),
	telefone varchar(255),
	renda decimal(4,2),
	primary key (id)
);