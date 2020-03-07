DELIMITER $$
DROP PROCEDURE IF EXISTS usp_actualizar2;
CREATE PROCEDURE usp_actualizar2(
id_reg int,
dni VARCHAR(30),
multa VARCHAR(30),
monto INT,
correo VARCHAR(30)
)
begin
update registrar set DNI=dni,multa=multa,monto=monto,correo=correo where id_regisro=id_reg;
end $$
DELIMITER ;

