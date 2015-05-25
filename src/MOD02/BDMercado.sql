CREATE
  TABLE Item
  (
    IDItem     INTEGER NOT NULL ,
    Quantidade DECIMAL (9,3) NOT NULL ,
    Valor_Item DECIMAL (7,2) NOT NULL ,
    IDProduto  INTEGER NOT NULL ,
    IDPedido   INTEGER NOT NULL ,
    CONSTRAINT Item_PK PRIMARY KEY CLUSTERED (IDItem)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE Pedido
  (
    IDPedido     INTEGER NOT NULL ,
    Data_Pedido  DATE NOT NULL ,
    Cliente      VARCHAR (100) NOT NULL ,
    Valor_Pedido DECIMAL (7,2) NOT NULL ,
    CONSTRAINT Pedido_PK PRIMARY KEY CLUSTERED (IDPedido)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE Produto
  (
    IDProduto   INTEGER NOT NULL ,
    Descricao   VARCHAR (100) NOT NULL ,
    Valor_Venda DECIMAL (7,2) NOT NULL ,
    CONSTRAINT Produto_PK PRIMARY KEY CLUSTERED (IDProduto)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

ALTER TABLE Item
ADD CONSTRAINT Item_Pedido_FK FOREIGN KEY
(
IDPedido
)
REFERENCES Pedido
(
IDPedido
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Item
ADD CONSTRAINT Item_Produto_FK FOREIGN KEY
(
IDProduto
)
REFERENCES Produto
(
IDProduto
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              2
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
