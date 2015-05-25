--@Author Arionildo.Escouto
--@Version 22/04/2015



--Exercícios 1
select
	NomeEmpregado
from Empregado
order by DataAdmissao asc;

select
	NomeEmpregado as [Nome do Empregado],
	(Salario*12) as [Salário Anual]
from Empregado
where Cargo = 'Atendente' OR (Salario*12) < 18.500;

select IDCidade
from Cidade
where Nome = 'Uberlândia';

select
	IDCidade,
	Nome
from Cidade
where UF = 'RS';
--Fim Exercícios 1



select 
	COUNT(1) as [Total de Empregados],
	COUNT(Distinct Cargo) as [Total de Cargos]
from Empregado;

select COUNT(distinct Cargo) as [Total de Cargos]
from Empregado;

select 
	SUM(Salario) as Soma
from Empregado;

select
	SUM(Salario) as Soma,
	MIN(Salario) as Menor,
	MAX(Salario) as Maior
from Empregado
group by Cargo;

select
	Cargo,
	COUNT(1) as Total
from Empregado
Group by Cargo
having count(1) > 1;

select NomeEmpregado,
	(Salario + (ISNULL(Comissao, 0))) as [Total do Salario]
from Empregado;

select
	NomeEmpregado,
	DataAdmissao,
	DATEDIFF(MONTH, DataAdmissao, GETDATE()) [Meses Trabalhados]
from Empregado;

select
	IDAssociado,
	Nome,
	Case
		when sexo = 'F' then 'Feminino'
		when sexo = 'M' then 'Masculino'
		else 'Indefinido'
	end Sexo
from Associado;



--Exercícios 2
select
	SUBSTRING(nome, 1 ,CHARINDEX(' ', nome))
from Associado;

select
	nome,
	DATEDIFF(YEAR, DataNascimento, GETDATE()) Idade
from Associado;

select
	NomeEmpregado,
	DataAdmissao,
	DATEDIFF(MONTH, DataAdmissao, CONVERT(datetime, '31/12/2000', 103)) [Meses Trabalhados Até 2000]
from Empregado
where DataAdmissao between CONVERT(datetime, '01/05/1980', 103) and CONVERT(datetime, '20/01/1982', 103);

select top 1
	Cargo,
	COUNT(1) [Empregados no Setor]
from Empregado
group by Cargo
order by [Empregados no Setor] desc;

select
	Nome
from Associado
where LEN(Nome) =
    (select
		MAX(LEN(Nome))
     from Associado);

	 
select
	Nome,
	DataNascimento,
	DATEADD(YEAR, 50, DataNascimento) "Completa 50 anos",
	DATENAME(weekday, DATEADD(YEAR, 50, DataNascimento)) "Dia da Semana"
from Associado;
/*
select
	Nome,
	(DATEPART(YEAR, DataNascimento) + 50) [Completa 50 anos],
	case
		when DATEPART(DW, (DATEPART(YEAR, DataNascimento) + 50)) = 1 then 'Domingo'
		when DATEPART(DW, (DATEPART(YEAR, DataNascimento) + 50)) = 2 then 'Segunda-Feira'
		when DATEPART(DW, (DATEPART(YEAR, DataNascimento) + 50)) = 3 then 'Terça-Feira'
		when DATEPART(DW, (DATEPART(YEAR, DataNascimento) + 50)) = 4 then 'Quarta-Feira'
		when DATEPART(DW, (DATEPART(YEAR, DataNascimento) + 50)) = 5 then 'Quinta-Feira'
		when DATEPART(DW, (DATEPART(YEAR, DataNascimento) + 50)) = 6 then 'Sexta-Feira'
		else 'Sábado'
	end [Dia da Semana]
from Associado;*/
--Fim Exercícios 2
