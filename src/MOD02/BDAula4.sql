select
	e.IDEmpregado,
	e.NomeEmpregado,
	d.NomeDepartamento
from Empregado e
inner join Departamento d
on d.IDDepartamento = e.IDDepartamento;
/*
select
	e.IDEmpregado,
	e.NomeEmpregado,
	d.NomeDepartamento
from
	Empregado e,
	Departamento d
where e.IDDepartamento = d.IDDepartamento;
*/


select
	e.IDEmpregado,
	e.NomeEmpregado,
	d.NomeDepartamento
from Empregado e
left join Departamento d
on d.IDDepartamento = e.IDDepartamento;


select
	e.IDEmpregado,
	e.NomeEmpregado,
	e.IDGerente,
	g.NomeEmpregado
from Empregado e
inner join Empregado g
on e.IDGerente = g.IDGerente;



--Exercicios 3
update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 2;


select
	e.NomeEmpregado,
	d.NomeDepartamento
from
	Empregado e,
	Departamento d
where e.IDDepartamento = d.IDDepartamento;


select
	a.Nome,
	c.Nome
from
	Associado a
left join Cidade c
on a.IDCidade = c.IDCidade;


select
	c.UF,
	count(1) "Total de Cidades"
from
	Cidade c
where not exists(
		select 1
		from Associado
		where Associado.IDAssociado = c.IDCidade)
group by c.UF;


select
	a.Nome,
	c.Nome,
	case
		when UF IN('RS', 'SC', 'PR')then '***'
		else null
	end "Região Sul"
from
	Associado a,
	Cidade c
where a.IDCidade = c.IDCidade;


select
	e.NomeEmpregado,
	dEmp.NomeDepartamento,
	g.NomeEmpregado,
	dGer.NomeDepartamento
from
	Empregado e,
	Empregado g,
	Departamento dEmp,
	Departamento dGer
where
	e.IDDepartamento = dEmp.IDDepartamento and
	g.IDEmpregado = e.IDGerente and
	g.IDDepartamento = dGer.IDDepartamento;
	
	
update EmpregadoAux
set Salario = Salario+(Salario*0.145)
where IDEmpregado in (
	Select e.IDEmpregado
	From EmpregadoAux e
	INNER JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento
	where d.Localizacao = 'SAO PAULO');
select * from EmpregadoAux;


select
	isnull(sum(emp.Salario), 0) "Salário Empregados",
	isnull(sum(empAux.Salario), 0) "Salário EmpregadosAux",
	isnull(sum(empAux.Salario), 0) - isnull(sum(emp.Salario), 0) "Diferença"
from
	Empregado emp,
	EmpregadoAux empAux;
	
	
select top 1
	d.NomeDepartamento,
	isNull(MAX(e.Salario), 0) "Maior Salário"
from
	EmpregadoAux e,
	Departamento d
where e.IDDepartamento = d.IDDepartamento
group by d.NomeDepartamento
order by "Maior Salário" desc;


select
	a.Nome,
	c.Nome "Cidade"
from
	Associado a,
	Cidade c	
where
	a.IDCidade = c.IDCidade
union all
select
	e.NomeEmpregado,
	d.Localizacao
from
	Empregado e,
	Departamento d
where e.IDDepartamento = d.IDDepartamento;


select
	c.Nome
from
	Associado a,
	Cidade c
where a.IDCidade=c.IDCidade;
--Fim Exercicios 3