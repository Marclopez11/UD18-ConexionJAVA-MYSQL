package Ej9;

import Conexionbd.ConexionMysql;

public class main {

	public static void main(String[] args) {
		ConexionMysql connexionMSQ = new ConexionMysql();

		// crear Base
		connexionMSQ.createBD("investiadores");

		// crear tablas
		connexionMSQ.createTabe("investiadores",
				"CREATE TABLE facultad(codigo int AUTO_INCREMENT PRIMARY KEY,nombre nvarchar(100)  not null);");
		connexionMSQ.createTabe("investiadores",
				"CREATE TABLE investigadores(dni varchar(8) PRIMARY KEY,nomapels nvarchar(255)  not null,facultad int,CONSTRAINT FK_facultad FOREIGN KEY (facultad)REFERENCES facultad(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");
		connexionMSQ.createTabe("investiadores",
				"CREATE TABLE equipos(numserie varchar(4) PRIMARY KEY,nombre nvarchar(100)  not null,facultad int,CONSTRAINT FK_facultadd FOREIGN KEY (facultad)REFERENCES facultad(codigo)ON DELETE CASCADE ON UPDATE CASCADE);");

		connexionMSQ.createTabe("investiadores",
				"CREATE TABLE reserva(dni varchar(8),numserie char(4),comienzo datetime,fin datetime,PRIMARY KEY (`dni`, `numserie`),CONSTRAINT FK_dni FOREIGN KEY (dni)REFERENCES investigadores(dni)ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT FK_numserie FOREIGN KEY (numserie)REFERENCES equipos(numserie)ON DELETE CASCADE ON UPDATE CASCADE);");

		// insert / update
		connexionMSQ.createInsert("investiadores","INSERT INTO facultad (nombre)VALUES ('Marc'),('Marc'),('Marc'),('Marc'),('Marc'),('Marc'),('Marc'),('Marc'),('Marc');");

		connexionMSQ.createInsert("investiadores",
				"INSERT INTO investigadores (dni,nomapels,facultad)VALUES ( '341567A','Marc Lopez',1),( '342567A','Marc Lopez',1),( '3476567A','Marc Lopez',1),( '336167A','Julia Lopez',3),( '346587A','Pere Lopez',9),( '346517A','Jose Lopez',3),( '316587A','Carmen Lopez',4),( '344567A','Viki Lopez',5),( '386567A','Maria Lopez',6),( '3346567A','Marc Lopez',8);");

		connexionMSQ.createInsert("investiadores",
				"INSERT INTO equipos (numserie,nombre,facultad)VALUES ( '597A','Marc Lopez',1),( '967A','Marc Lopez',1),( '567A','Marc Lopez',1),( '167A','Julia Lopez',3),( '587A','Pere Lopez',9),( '517A','Jose Lopez',3),( '589A','Carmen Lopez',4),( '017A','Viki Lopez',5),( '547A','Maria Lopez',6),( '067A','Marc Lopez',8);");
		connexionMSQ.createInsert("investiadores",
				"INSERT INTO reserva(dni,numserie,comienzo,fin) VALUES('341567A','597A','2021-02-31 23:59:59' , '2022-12-31 23:59:59'),('346517A','567A','2021-02-31 22:59:59' , '2022-12-31 23:59:59'),('386567A','517A','2021-02-31 23:59:59' , '2022-12-31 23:59:59'),('316587A','547A','2021-03-31 21:59:59' , '2022-12-31 23:59:59');");

		// delete
		connexionMSQ.deletetDB("investiadores");
	}

}
















