/*
  Copyright (c) 2011, CWI Software. Todos os direitos.
  Projeto Crescer - Treinamento de banco de dados 
  ---
  Laboratório 1: Comandos DDL, criação de tabelas e constraints.  
*/

Create table Cidade 
(
  IDCidade  int         not null,
  Nome      varchar(30) not null,
  UF        varchar(2)  not null,
    constraint PK_Cidade primary key (IDCidade)
);	

Create table Associado 
(
  IDAssociado    int         not null,
  Nome           varchar(50) not null,
  DataNascimento datetime    not null,
  Sexo           char(1)     not null,
  CPF            varchar(11) ,
  Endereco       varchar(35),
  Bairro         varchar(25),
  Complemento    varchar(20),
  IDCidade       int,
     constraint PK_Associado primary key (IDAssociado),
	 constraint FK_Associado foreign key (IDCidade)
	    references Cidade (IDCidade)
);

