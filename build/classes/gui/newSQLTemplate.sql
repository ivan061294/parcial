DELIMITER $$
DROP PROCEDURE IF EXISTS usp_insert2;
CREATE PROCEDURE usp_insert2(
id_reg int,
dni VARCHAR(30),
multa VARCHAR(30),
monto INT,
correo VARCHAR(30)
)
begin
INSERT INTO registrar VALUES(id_reg,dni,multa,monto,correo);
end $$
DELIMITER ;