package Ej6;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		ConexionMysql connexionMSQ = new ConexionMysql();

		// crear Base
		connexionMSQ.createBD("piezasyprovedores");

		// crear tablas
		connexionMSQ.createTabe("piezasyprovedores",
				"CREATE TABLE piezas(codigo int AUTO_INCREMENT PRIMARY KEY,nombre nvarchar(100) not null);");
		connexionMSQ.createTabe("piezasyprovedores",
				"CREATE TABLE proveedores(id char(4) PRIMARY KEY,nombre nvarchar(100)  not null);");
		connexionMSQ.createTabe("piezasyprovedores",
				"CREATE TABLE suministra(codigopieza int,idproveedor char(4),PRIMARY KEY (`codigopieza`, `idproveedor`),precio int,CONSTRAINT FK_proveedor FOREIGN KEY (codigopieza)REFERENCES piezas(codigo)ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT FK_prveedor FOREIGN KEY (idproveedor)REFERENCES proveedores(id)ON DELETE CASCADE ON UPDATE CASCADE);");

		// insert / update
		connexionMSQ.createInsert("piezasyprovedores",
				"INSERT INTO piezas(nombre)VALUES ('Motor'),('Neumáticos'),('Chasis'),('Carrocería'),('Parabrisas');");
		connexionMSQ.createInsert("piezasyprovedores",
				"INSERT INTO proveedores(id,nombre)VALUES ('aple','Apple'),('vrfr','Verdifresh'),('embm','Embutidos Martínez'),('hvgi','Huevos Guillén'),('cidc','Cidacos'),('irla','Iparlat');");
		connexionMSQ.createInsert("piezasyprovedores",
				"INSERT INTO suministra(codigopieza,idproveedor,precio)VALUES (1,'aple',32),(2,'vrfr',32),(2,'embm',32),(1,'hvgi',32),(4,'cidc',32),(1,'irla',32),(3,'irla',32);");

		// delete
		// connexionMSQ.deletetDB("piezasyprovedores");

	}

}
