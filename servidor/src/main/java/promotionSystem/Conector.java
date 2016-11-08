package promotionSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {
	private Connection conector;
	PreparedStatement sentencia;
	public Conector(){
		try {
			Class.forName("org.sqlite.JDBC");
			conector = DriverManager.getConnection("jdbc:sqlite:kom.bd");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
	
	public void agregarUsuario(String nombre, int contrasena) throws SQLException{
		  conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("INSERT INTO Usuarios (nombre,contrasena) values (?,?);");
	      sentencia.setString(1,nombre);
	      sentencia.setInt(2,contrasena);
	      sentencia.executeUpdate();	     
	      sentencia.close();
	      conector.commit();
	}
	
	public boolean validarUsuario(String nombre, int contrasena) throws SQLException{
		  conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("Select Count(*) from Usuarios where nombre like ? AND contrasena=?");
	      sentencia.setString(1,nombre);
	      sentencia.setInt(2,contrasena);
	      ResultSet resultado=sentencia.executeQuery();	
	      boolean devolver=resultado.next()?resultado.getInt(1)==1:false;
	      sentencia.close();
	      conector.commit();      
	  
	      return devolver;
	}

	public boolean validarNombreUsuario(String nombre) throws Exception {
		 conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("Select Count(*) from Usuarios where nombre like ?");
	      sentencia.setString(1,nombre);
	      ResultSet resultado=sentencia.executeQuery();	
	      boolean devolver=resultado.next()?resultado.getInt(1)==1:false;
	      sentencia.close();
	      conector.commit();      
	      return devolver;
	      
	}
	
	
	
}
