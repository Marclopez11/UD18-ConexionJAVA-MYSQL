package Ej7;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		ConexionMysql connexionMSQ = new ConexionMysql();

		// crear Base
		connexionMSQ.createBD("cintificos");

		// crear tablas
		connexionMSQ.createTabe("cintificos",
				"CREATE TABLE proyecto(id char(4) PRIMARY KEY,nombre nvarchar(100)  not null,horas int );");
		connexionMSQ.createTabe("cintificos",
				"CREATE TABLE cientificos(dni char(8) PRIMARY KEY,nomapels nvarchar(255)  not null);");
		connexionMSQ.createTabe("cintificos",
				"CREATE TABLE asignado_a(cientifico varchar(8),proyecto char(4),PRIMARY KEY (`cientifico`, `proyecto`),CONSTRAINT FK_cientifico FOREIGN KEY (cientifico)REFERENCES cientificos(dni)ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT FK_proyecto FOREIGN KEY (proyecto)REFERENCES proyecto(id)ON DELETE CASCADE ON UPDATE CASCADE);");

		// insert / update
		connexionMSQ.createInsert("cintificos","INSERT INTO cientificos (dni, nomapels)VALUES ('4719147X', 'Marc lopez'),('9849799G', 'Marc lopez'),('3115657V', 'Marc lopez'),('8154144L', 'Marc lopez'),('1848233Y', 'Marc lopez');");

		connexionMSQ.createInsert("cintificos",
				"INSERT INTO proyecto (id, nombre,horas)VALUES ('vked','Marc',4),('eler', 'Marc',4),('grsh', 'Marc',4),('uths', 'Marc',4),('ytef', 'Marc',4),('jryf', 'Marc',4),('wytf', 'Marc',4),('ytr4', 'Marc',4),('yte5', 'Marc',4),('rewg', 'Marc',4);");
		connexionMSQ.createInsert("cintificos",
				"INSERT INTO asignado_a (cientifico, proyecto)VALUES ('4719147X', 'rewg'),('9849799G', 'yte5'),('3115657V', 'ytr4'),('8154144L', 'wytf'),('1848233Y', 'jryf');");

		// delete
		connexionMSQ.deletetDB("cintificos");

	}

}









