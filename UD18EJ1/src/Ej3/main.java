package Ej3;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		
		
		ConexionMysql connexionMSQ = new ConexionMysql();

		//crear Base
		connexionMSQ.createBD("almacenes");

		//crear tablas
		connexionMSQ.createTabe("almacenes", "CREATE TABLE almacenes(codigo int AUTO_INCREMENT PRIMARY KEY,lugar nvarchar(100) NOT NULL,capacidad int not null);");
		connexionMSQ.createTabe("almacenes", "CREATE TABLE cajas(numreferencia char(5) PRIMARY KEY,contenido nvarchar(100) NULL,valor int  NULL,id_almacen int NOT NULL,CONSTRAINT FK_almacen FOREIGN KEY (id_almacen)REFERENCES almacenes(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");

		//insert / update
		connexionMSQ.createInsert("almacenes","INSERT INTO almacenes (lugar,capacidad) VALUES ('dep1',27),('dep2',3),('dep3',56),('dep4',233),('dep5',2333);");
		connexionMSQ.createInsert("almacenes","	INSERT INTO cajas (numreferencia,contenido,valor,id_almacen) VALUES ('2w3a4','ropa',43,1),('2sdsw','gorros',43,2),('23e4r','consolas',40,3),('werrc','tv',3,4),('sfm43','pantolones',12,5);");
		
	
		
		
		//delete
		connexionMSQ.deletetDB("almacenes");

	}

	
}

