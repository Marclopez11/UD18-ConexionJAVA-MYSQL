package Ej5;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		ConexionMysql connexionMSQ = new ConexionMysql();

		//crear Base
		connexionMSQ.createBD("directores");

		//crear tablas
		connexionMSQ.createTabe("directores", "CREATE TABLE despachos(numero int AUTO_INCREMENT PRIMARY KEY,capacidad int not null);");
		connexionMSQ.createTabe("directores", "CREATE TABLE directores(dni varchar(8) PRIMARY KEY,nombre_apellidos VARCHAR(255),id_despacho int,CONSTRAINT FK_despacho FOREIGN KEY (id_despacho)REFERENCES despachos(numero)ON DELETE CASCADE ON UPDATE CASCADE,id_dnijefe varchar(8),CONSTRAINT FK_dnijefe FOREIGN KEY (id_dnijefe)REFERENCES directores(dni)ON DELETE CASCADE ON UPDATE CASCADE);");

		//insert / update
		connexionMSQ.createInsert("directores","INSERT INTO despachos (capacidad)VALUES (1),(1),(1),(1),(1),(1),(1),(1),(1),(1);");
		connexionMSQ.createInsert("directores","INSERT INTO directores (dni, nombre_apellidos, id_despacho, id_dnijefe)VALUES ('4768243A', 'Marc lopez', 1, '4768243A'),('4738241A', 'Marc lopez', 1, '4738241A'),('4738242B', 'Pedo lopez', 1, '4738242B'),('4738244C', 'Juan lopez', 1, '4738244C'),('4738245D', 'Alberto lope', 1, '4738245D');");
		
	
		
		
		//delete
		connexionMSQ.deletetDB("directores");

	}

}









