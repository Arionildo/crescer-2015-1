select
	Nome,
   --(YEAR(DataNascimento)+50),                                                                   --RETORNA APENAS O ANO
	DataNascimento + to_yminterval('50-0') "Completa 50 Anos",                --RETORNA A DATA E HORA
	case
		when DAYOFWEEK(ADD_MONTHS(DataNascimento, 600)) = 1 then 'Domingo'
		when DAYOFWEEK(ADD_MONTHS(DataNascimento, 600)) = 2 then 'Segunda-Feira'
		when DAYOFWEEK(ADD_MONTHS(DataNascimento, 600)) = 3 then 'Ter�a-Feira'
		when DAYOFWEEK(ADD_MONTHS(DataNascimento, 600)) = 4 then 'Quarta-Feira'
		when DAYOFWEEK(ADD_MONTHS(DataNascimento, 600)) = 5 then 'Quinta-Feira'
		when DAYOFWEEK(ADD_MONTHS(DataNascimento, 600)) = 6 then 'Sexta-Feira'
		else 'S�bado'
	end "Dia da Semana"
from Associado;


select
	UF,
	COUNT(1) as "Cidade(s) por Estado"
from Cidade
Group by UF;


select
	UF,
   Nome,
	COUNT(1) as "Mesmo Nome e UF"
from Cidade
Group by UF, Nome
having COUNT(1) >1;


select isNull(MAX(IDAssociado), 0)+1 as "Próximo ID"
from Associado;
/*
select top 1
    (count(1)+1) as "Próximo ID"
from Associado;
*/


insert into CidadeAux(
    select *
    from Cidade
    where IDCidade in (
        select MIN(IDCidade)
        from Cidade
        group by Nome)
);


MERGE INTO cidade A
USING (
    select 
        IDCidade,
        Nome
    from Cidade
    where IDCidade in (
        select MAX(IDCidade)
        from Cidade
        group by Nome
        having count(1) >1)) B
ON (A.IDCIDADE = B.IDCIDADE)
WHEN MATCHED THEN UPDATE
SET A.Nome = '*'+B.Nome;
/*
update Cidade
set Nome = '*'+Nome
where Nome in(
				select UF, Nome
				from Cidade
				group by nome, UF
				having count(1)>1
			)
*/


select
	IDAssociado,
	Nome,
	Case
		when sexo = 'F' then 'Feminino'
		else 'Masculino'
	end Sexo
from Associado;


select
	IDEmpregado,
	Salario,
	Case
		when Salario < 1164 then '0%'
		when Salario between 1164 and 2326 then '15%'
		else '27,5%'
	end "Desconto IR"
from Empregado;


insert into CidadeAux(
    select *
    from Cidade
    where IDCidade in (
        select MIN(IDCidade)
        from Cidade
        group by Nome)
);


alter table Cidade
add constraint UK_Cidade_NomeUF
unique(Nome, UF);