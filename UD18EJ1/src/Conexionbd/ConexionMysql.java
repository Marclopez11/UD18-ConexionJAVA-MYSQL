package Conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMysql {
	
	public Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.172:3306?useTimezone=true&serverTimezone=UTC","remote","Reus_2022");
			System.out.println("Server Connected");
			return conexion;
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se puede conectar");
			System.out.println(ex);
			return null;
			// TODO: handle exception
		}
		
	}
	
	public void createBD(String db) {
		try {
			Connection conexion = conexion();
			String QueryDrop = "DROP DATABASE IF EXISTS "+db;
			String Query = "CREATE DATABASE "+db;
			Statement st = conexion.createStatement();
			st.executeUpdate(QueryDrop);
			st.executeUpdate(Query);
			conexion.close();
			System.out.println("Se a creado correctamente la BD "+db);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se a podido crear la bd "+db);
			System.out.println(e);
		}
	}
	
	
	
	public void createTabe(String db, String sql) {
		try {
			Connection conexion = conexion();
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = sql;
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		

			conexion.close();
			System.out.println("Tabla "+db+" creada con exito!");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se a podido crear la tabla "+db);
			System.out.println(e);
		}
	}
	
	//insert
	
	public void createInsert(String db, String sql) {
		try {
			Connection conexion = conexion();
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = sql;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		
			conexion.close();
			System.out.println("Inserts  creados  con exito!");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se a podido crear los inserts en la tabla ");
			System.out.println(e);
		}
	}
	
	
	//selet 
	
	
	public void selectDB(String db, String tabla) {
		try {
			Connection conexion = conexion();
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "SELECT * FROM "+tabla+";";
			System.out.println(Query);

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(Query);
			
			
			while (rs.next())
		      {
		       
		        
		        // print the results
				  // System.out.println(rs.getObject(1));
				   System.out.println(rs.toString());
		      }
			
			
		
			conexion.close();
			System.out.println("Select Correcto!");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Select Incorrecto!");
			System.out.println(e);
		}
	}
	
	//delete
	
	
	
	public void deletetDB(String db) {
		try {
			Connection conexion = conexion();
			
			String Query = "DROP DATABASE "+db+";";
			System.out.println(Query);

			Statement st = conexion.createStatement();
			
			
			conexion.close();
			System.out.println("Delete Correcto!");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Delete Incorrecto!");
			System.out.println(e);
		}
	}

}
