DELIMITER $$
DROP PROCEDURE IF EXISTS usp_eliminar2;
CREATE PROCEDURE usp_eliminar2(
id_reg int
)
begin
delete from registrar where id_regisro=id_reg;
end $$
DELIMITER ;
