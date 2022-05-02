package Ej2;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionMysql connexionMSQ = new ConexionMysql();
		// connexionMSQ.conexion();
		
		
		//crear Base
		connexionMSQ.createBD("empleados");

		//crear tablas
		connexionMSQ.createTabe("empleados", "CREATE TABLE departamentos(codigo int AUTO_INCREMENT PRIMARY KEY,nombre varchar(100) NOT NULL,prosupueto int not null);");
		connexionMSQ.createTabe("empleados", "CREATE TABLE empleados(dni varchar(8) PRIMARY KEY,nombre varchar(100) NULL,apellidos varchar(255) NULL,id_departamento int NOT NULL,CONSTRAINT FK_departamento FOREIGN KEY (id_departamento)REFERENCES departamentos(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");

		//insert / update
		connexionMSQ.createInsert("empleados","INSERT INTO departamentos (nombre,prosupueto) VALUES ('Departamento1',3456),('Departamento2',100022),('Departamento3',434535),('Departamento4',93452),('Departamento5',1452);");
		connexionMSQ.createInsert("empleados","INSERT INTO empleados (dni,nombre,apellidos,id_departamento) VALUES ('34564534','marc','lopez',1),('34564554','marc','lopez',2),('34514534','marc','lopez',3),('34264534','marc','lopez',4),('34864534','marc','lopez',5);");
		
		//connexionMSQ.selectDB("empleados","departamentos");
		//connexionMSQ.selectDB("empleados","empleados");
		
		
		
		//delete
		connexionMSQ.deletetDB("empleados");

	}

}
