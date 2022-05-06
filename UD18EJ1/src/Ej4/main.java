package Ej4;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		ConexionMysql connexionMSQ = new ConexionMysql();

		//crear Base
		connexionMSQ.createBD("peliculasysalas");

		//crear tablas
		connexionMSQ.createTabe("peliculasysalas", "CREATE TABLE peliculas(codigo int AUTO_INCREMENT PRIMARY KEY,nombre nvarchar(100) NOT NULL,calificacionedad int not null);");
		connexionMSQ.createTabe("peliculasysalas", "CREATE TABLE salas(codigo int AUTO_INCREMENT PRIMARY KEY,nombre nvarchar(100) NULL,id_pelicula int NOT NULL,CONSTRAINT FK_pelicula FOREIGN KEY (id_pelicula)REFERENCES peliculas(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");

		//insert / update
		connexionMSQ.createInsert("peliculasysalas","INSERT INTO peliculas (nombre,calificacionedad) VALUES ('peli1',27),('peli2',2),('peli3',7),('peli4',18),('peli5',16);");
		connexionMSQ.createInsert("peliculasysalas","	INSERT INTO salas (nombre,id_pelicula) VALUES ('sala1',5),('sala2',2),('sala3',4),('sala4',1),('sala5',2);");
		
	
		
		
		//delete
		//connexionMSQ.deletetDB("peliculasysalas");


	}

}






