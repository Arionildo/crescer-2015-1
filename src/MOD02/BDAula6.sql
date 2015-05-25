--Exercicio 1
begin
	declare
		@vNome varchar(10),
		@vQuantidade int
		
	select top 1
		@vNome = p.Nome,
		@vQuantidade = SUM(i.Quantidade)
	from 
		Produto p,
		PedidoItem i
	where p.IDProduto = i.IDProduto
	group by
		p.IDProduto,
		p.Nome
	order by SUM(i.Quantidade) desc;

	print 'O produto '+ @vNome +' teve '+ cast(@vQuantidade as varchar(10)) + ' unidades vendidas'
end;
--------------------------------------------------------------


--Exercicio 2
BEGIN
--PROPRIEDADES DO CURSOR
	DECLARE ListaCidade CURSOR
	Local
	Fast_Forward

--SELEÇÃO DE CIDADES/UF DUPLICADAS
	FOR select
			ci.Nome,
			ci.UF
		from
			Cidade ci
		group by
			ci.Nome,
			ci.UF
		having COUNT(1) > 1;

	DECLARE @vNome varchar(50),
			@vUF varchar(2),
			@vTotalClientes int;

--DEFINE QUE A LISTA DE CIDADES RETORNARÁ VALORES PARA AS
--VARIÁVEIS CRIADAS.
	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

--ENQUANTO HOUVER RESULTADO NA BUSCA O NOME SERÁ EXIBIDO
--NO CONSOLE CASO HAJA CLIENTE RELACIONADO À CIDADE
	WHILE (@@FETCH_STATUS=0)
		BEGIN
			select @vTotalClientes = COUNT(1)
			from Cliente cl
			where exists(
					select 1
					from Cidade ci
					where
						ci.IDCidade = cl.IDCidade and
						ci.Nome = @vNome and
						ci.UF = @vUF);
			
			if (@vTotalClientes > 0)
				Print @vNome +'/'+ @vUF +'. Total de Clientes: '+ cast(
										@vTotalClientes as varchar(10));
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
		END

--AO TÉRMINO DAS BUSCAS POR NOMES DUPLICADOS A LISTA É
--FINALIZADA
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END
--------------------------------------------------------------


--Exercicio 3
--INDEX E VIEW
create index IX_Pedido_DataPedido on Pedido(DataPedido);
create view Materiais_Mais_Usados as
select top 1
	m.IDMaterial,
	m.Descricao,
	COUNT(1) "Usado"
from
	Material m,
	ProdutoMaterial pm
where m.IDMaterial = pm.IDMaterial
group by
	m.IDMaterial,
	m.Descricao
order by "Usado" desc;

--TOTAL DE PEDIDOS E ITENS COM O MATERIAL MAIS USADO
select
	count(distinct p.IDPedido) "Total de Pedidos",
	count(1) "Total de Itens"
from
	Pedido p,
	PedidoItem i
where
	i.IDPedido = p.IDPedido and
	exists (select 1 
			from ProdutoMaterial pm
			where
				pm.IDProduto = i.IDProduto and
				pm.IDMaterial in (
						select IDMaterial
						from Materiais_Mais_Usados));

--!!DÚVIDA QUANTO AO RESULTADO DESTA CONSULTA!!
select
	ISNULL(SUM(ValorPedido), 0) "Valor Total de Vendas"
from
	Pedido p,
	PedidoItem i
where DATEDIFF(day, GETDATE(), DataPedido) <= 60 and
	exists (select 1 
			from ProdutoMaterial pm
			where
				pm.IDProduto = i.IDProduto and
				pm.IDMaterial in (
						select IDMaterial
						from Materiais_Mais_Usados));
--------------------------------------------------------------


--Exercício 4
/*
BEGIN
	DECLARE ListaCidade CURSOR
	Local
	Fast_Forward
	FOR select
			ci.IDCidade,
			ci.Nome,
			ci.UF
		from
			Cidade ci
		group by
			ci.IDCidade,
			ci.Nome,
			ci.UF
		having COUNT(1) > 1;

	DECLARE @vNomeCliente varchar(30),
			@vNomeCidade varchar(30),
			@vIDCidade int,
			@vNome varchar(30),
			@vUF varchar(2),
			@vContador int,
			@vAuxCliente table (
				IDAuxCliente int not null primary key,
				NomeCliente varchar(30) not null,
				IDCidade int not null,
				NomeCidade varchar(30) not null);

	@vContador = 1;

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

--ENQUANTO HOUVER RESULTADO NA BUSCA O NOME SERÁ EXIBIDO
--NO CONSOLE CASO HAJA CLIENTE RELACIONADO À CIDADE
	WHILE (@@FETCH_STATUS=0)
		BEGIN
			select
				@vIDCidade = Max(cl.IDCliente),
				@vNomeCliente = cl.Nome,
				@vNomeCidade = ci.Nome
			from Cliente cl, Cidade ci
			where exists(
					select 1
					from Cidade ci
					where
						ci.IDCidade = cl.IDCidade and
						ci.Nome = @vNome and
						ci.UF = @vUF);
			
			insert into @vAuxCliente
			values(@vContador, @vNomeCliente, @vIDCidade, @vNomeCidade);
			print select * from @vAuxCliente where IDAuxCliente = @vContador;

			@vContador = @vContador + 1;
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
		END

--AO TÉRMINO DAS BUSCAS POR NOMES DUPLICADOS A LISTA É
--FINALIZADA
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END
*/
--------------------------------------------------------------