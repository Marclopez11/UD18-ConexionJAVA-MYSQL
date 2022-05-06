package Ej8;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		ConexionMysql connexionMSQ = new ConexionMysql();

		// crear Base
		connexionMSQ.createBD("grandesalmacenes");

		// crear tablas
		connexionMSQ.createTabe("grandesalmacenes",
				"CREATE TABLE cajeros(codigo int AUTO_INCREMENT PRIMARY KEY,nomapels nvarchar(255)  not null);");
		connexionMSQ.createTabe("grandesalmacenes",
				"CREATE TABLE productos(codigo int AUTO_INCREMENT PRIMARY KEY,nombre nvarchar(100)  not null,precio int);");
		connexionMSQ.createTabe("grandesalmacenes",
				"CREATE TABLE maquinas_registradas(codigo int AUTO_INCREMENT PRIMARY KEY,piso int not null);");
		connexionMSQ.createTabe("grandesalmacenes",
				"CREATE TABLE venta(cajero int,maquina int,producto int,PRIMARY KEY (cajero, maquina, producto),CONSTRAINT FK_calero FOREIGN KEY (cajero)REFERENCES cajeros(codigo)ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT FK_maquina FOREIGN KEY (maquina)REFERENCES maquinas_registradas(codigo)ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT FK_producto FOREIGN KEY (producto)REFERENCES productos(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");

		// insert / update
		connexionMSQ.createInsert("grandesalmacenes","INSERT INTO cajeros (nomapels)VALUES ( 'Marc Lopez'), ( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez'),( 'Marc Lopez');");

		connexionMSQ.createInsert("grandesalmacenes",
				"INSERT INTO productos (nombre,precio)VALUES ( 'Tv',20), ( 'Tv',20), ( 'Tv',20), ( 'Tv',20), ( 'Tv',20), ( 'Tv',20),( 'Tv',20), ( 'Tv',20), ( 'Tv',20), ( 'Tv',20);");
		connexionMSQ.createInsert("grandesalmacenes",
				"INSERT INTO maquinas_registradas (piso)VALUES (20), (20), (20), (20), (20), (20), (20), (20), (20), (20);");
		connexionMSQ.createInsert("grandesalmacenes",
				"INSERT INTO venta (cajero,maquina,producto)VALUES (1,2,3),(2,2,3),(1,1,3),(1,3,3),(3,2,5),(6,4,3),(5,2,8),(4,5,3),(8,5,3),(8,7,3);");


		// delete
		//connexionMSQ.deletetDB("grandesalmacenes");

	

	}

}
















