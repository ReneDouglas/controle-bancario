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

create table contas_bancarias(
	id int not null auto_increment,
	tipo_conta varchar(255) default 'Comum',
	nro_conta bigint not null unique,
	data_abertura datetime(6) not null,
	data_encerramento datetime(6),
	situacao int not null default 1,
	senha int(6) not null,
	saldo decimal(12,2) default 0.0,
	limite_conta decimal(12,2),
	data_aniversario date,
	pessoa_id int not null,
	primary key(id),
	foreign key (pessoa_id) references pessoas(id)
);