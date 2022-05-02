package Ej1;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionMysql connexionMSQ = new ConexionMysql();
		// connexionMSQ.conexion();
		
		
		//crear Base
		connexionMSQ.createBD("tiendainformatica");

		//crear tablas
		connexionMSQ.createTabe("tiendainformatica", "CREATE TABLE fabricantes(codigo int AUTO_INCREMENT PRIMARY KEY,nombre varchar(100) NOT NULL);");
		connexionMSQ.createTabe("tiendainformatica", "CREATE TABLE articulos(codigo int AUTO_INCREMENT PRIMARY KEY,nombre varchar(8) null, precio int NULL,id_fabricante int NOT NULL,CONSTRAINT FK_fabricante FOREIGN KEY (id_fabricante)REFERENCES fabricantes(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");

		//insert / update
		connexionMSQ.createInsert("tiendainformatica","INSERT INTO fabricantes (nombre) VALUES ('Apple'),('Embutidos Martínez'),('Cidacos'),('Iparlat'),('Grupo Siro');");
		connexionMSQ.createInsert("tiendainformatica","INSERT INTO articulos (nombre,precio,id_fabricante) VALUES ('Tv',6,1),('Radio',12,2),('Libro',60,3),('Wii',126,5),('Ps4',54,4);");
		
		//connexionMSQ.selectDB("tiendainformatica","fabricantes");
		//connexionMSQ.selectDB("tiendainformatica","articulos");
		
		
		
		//delete
		connexionMSQ.deletetDB("tiendainformatica");





	}

}

