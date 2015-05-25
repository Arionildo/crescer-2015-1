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
email varchar(40) not null,
senha varchar(30) not null
)