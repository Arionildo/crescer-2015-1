--CRIAÇÃO DA TABELA DE CADASTRO DE FILMES
create table filmes(
	idFilme int not null auto_increment primary key,
	nome varchar(40) not null,
	genero varchar(30) not null,
	ano int(4) not null,
	foto varchar not null,
	sinopse varchar not null
);


--CRIAÇÃO DA TABELA DE CADASTRO DE USUARIOS
create table usuarios (
idUsuario int not null auto_increment primary key,
nome varchar(20) not null,
senha varchar(30) not null,
email varchar(40) not null,
tipoAcesso char not null
);


--USUÁRIO ADMINISTRADOR
insert into usuarios ( nome, senha, email, tipoAcesso ) values ( 'admin', 'zxcvb', 'arionildo.escouto@cwi.com.br', 'A' );


--USUÁRIO COMUM
insert into usuarios ( nome, senha, email, tipoAcesso ) values ( 'fulano', 'qwert', 'fulano.meirelles@ymail.com.br', 'C' );