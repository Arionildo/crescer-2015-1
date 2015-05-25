--Exercício 1
select distinct
	Situacao,
	COUNT(1) "Valores"
from Produto
group by Situacao;
--------------------------------------------------------------


--Exercício 2
select
	Nome,
	RazaoSocial
from Cliente
--'LTDA' PODE ESTAR TANTO NO MEIO QUANTO NO FINAL DO NOME
where
	RazaoSocial like '%LTDA%' OR
	RazaoSocial like '%LTDA';
--------------------------------------------------------------
	

--Exercício 3	
insert into Produto(
	Nome,
	PrecoCusto,
	PrecoVenda,
	Situacao)
values(
	'Galocha Maragato',
	35.67,
	77.95,
	'A');
--------------------------------------------------------------
	

--Exercício 4
select
	p.Nome
from
	Produto p
--VERIFICA SE O PRODUTO NÃO FOI PEDIDO
where not exists(
		select 1
		from PedidoItem i
		where p.IDProduto = i.IDProduto);
--------------------------------------------------------------


--Exercício 5
select top 1
	ci.UF,
	COUNT(1) "Maior número de clientes"
from
	Cliente cl,
	Cidade ci
where cl.IDCidade=ci.IDCidade
group by ci.UF
order by "Maior número de clientes" desc;
--------------------------------------------------------------


--Exercício 6
--DUAS VIEW'S CRIADAS PARA FACILITAR O USO DO SELECT À SEGUIR
create view MaiorNroClientes as
select top 1
	ci.UF,
	COUNT(1) "Maior número de clientes"
from
	Cliente cl,
	Cidade ci
where cl.IDCidade=ci.IDCidade
group by ci.UF
order by "Maior número de clientes" desc;

create view MenorNroClientes as
select top 1
	ci.UF,
	COUNT(1) "Menor número de clientes"
from
	Cliente cl,
	Cidade ci
where cl.IDCidade=ci.IDCidade
group by ci.UF
order by "Menor número de clientes" asc;

select * from MaiorNroClientes, MenorNroClientes;

select
	count(distinct ci.nome) "Total de Cidades"
from
	cidade ci,
	Cliente cl,
	Pedido p
where
	ci.IDCidade = cl.IDCidade and
	cl.IDCliente = p.IDCliente;
--------------------------------------------------------------


--Exercício 7
select
	p.Nome
from
	Produto p
where not exists(
		select 1
		from ProdutoMaterial m
		where p.IDProduto = m.IDProduto);
--------------------------------------------------------------


--Exercício 8
--NO QUARTO CAMPO É CALCULADO O PrecoCusto DE ACORDO COM A
--Quantidade PARA SE OBTER O CUSTO TOTAL DOS MATERIAIS USADOS
--EM CADA PRODUTO
select
	pm.IDProduto,
	p.Nome,
	p.PrecoCusto,
	sum(isnull(pm.Quantidade, 1) * m.PrecoCusto) "Custo Materiais"
from
	Produto p,
	Material m,
	ProdutoMaterial pm
where
	p.IDProduto = pm.IDProduto and
	m.IDMaterial = pm.IDMaterial
group by pm.IDProduto, p.Nome, p.PrecoCusto
order by "Custo Materiais" desc;
--------------------------------------------------------------


--Exercício 9
--VIEW PARA FACILITAR A IMPLEMENTAÇÃO DO UPDATE À SEGUIR
create view CustoMateriais as
select
	p.IDProduto,
	sum(isnull(pm.Quantidade, 1) * m.PrecoCusto) "Custo Materiais"
from
	Produto p,
	Material m,
	ProdutoMaterial pm
where
	p.IDProduto = pm.IDProduto and
	m.IDMaterial = pm.IDProdutoMaterial
group by p.IDProduto;

update Produto
set
	PrecoCusto = cm.[Custo Materiais]
from
	Produto p,
	CustoMateriais cm
where 
	p.IDProduto = cm.IDProduto and
	p.PrecoCusto < cm.[Custo Materiais];

--JUSTIFICANDO O "- 0.1" À SEGUIR:
--O CAMPO Custo Materiais POSSUI MAIS CASAS DECIMAIS DO QUE O
--PrecoCusto QUE PODE RESULTAR EM UM VALOR ACIMA DO QUE
--PrecoCusto POSSUI.
select
	Nome,
	PrecoCusto,
	[Custo Materiais]
from Produto p, CustoMateriais cm
where
	p.IDProduto = cm.IDProduto and
	PrecoCusto < ([Custo Materiais] - 0.1);
--------------------------------------------------------------


--Exercício 10
--TANTO O NOME COMPLETO QUANTO O PRIMEIRO NOME FORAM TESTADOS,
--PORÉM, APENAS O CAMPO Nome FOI O UTILIZADO.
select
	Nome
	--SUBSTRING(Nome, 0, CHARINDEX(' ', Nome, 1))
from Cliente
group by Nome
having COUNT(Nome) > 1;
--------------------------------------------------------------


--Exercício 11
select
	SUBSTRING(Nome, 0, CHARINDEX(' ', Nome, 1)),
	COUNT(Nome) "Popularidade"
from Cliente
group by Nome;
--------------------------------------------------------------


--Exercício 12
select
	p.IDProduto,
	p.Nome,
	SUM(i.Quantidade) "Vendas"
from 
	Produto p,
	PedidoItem i
where p.IDProduto = i.IDProduto
group by
	p.IDProduto,
	p.Nome
order by "Vendas" desc;
--------------------------------------------------------------
	
	
-------------------------------------------------------------
create index IX_PedidoItem_Produto on PedidoItem(IDProduto)