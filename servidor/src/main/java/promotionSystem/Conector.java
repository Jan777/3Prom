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

	public void agregarPersonaje(Personaje personaje,String raza, String casta) throws SQLException {
		  conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("INSERT INTO Personajes (nombre,raza,casta,nivel) values (?,?,?,?);");
	      sentencia.setString(1,personaje.getNombre());
	      sentencia.setString(2,raza);
	      sentencia.setString(3,casta);
	      sentencia.setInt(4,personaje.getNivel());
	      sentencia.executeUpdate();	     
	      sentencia.close();
	      conector.commit();
	}


	public String obtenerRazaPersonaje(String nombreCliente) throws SQLException {
		conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("Select * from Personajes where nombre like ?");
	      sentencia.setString(1,nombreCliente);
	      ResultSet resultado=sentencia.executeQuery();
	      String raza=null;
	      while(resultado.next()){
	    	  raza = resultado.getString(2);	    	  
	      }
	   
	      sentencia.close();
	      conector.commit();
	     
		return raza;      
	}

	public String obtenerCastaPersonaje(String nombreCliente) throws SQLException {
		conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("Select * from Personajes where nombre like ?");
	      sentencia.setString(1,nombreCliente);
	      ResultSet resultado=sentencia.executeQuery();	
	      String casta=null;
	      while(resultado.next()){
	    	   casta = resultado.getString(3);	    	  
	      }
	      sentencia.close();
	      conector.commit();

		return casta;      
	}

	public int obtenerNivelPersonaje(String nombreCliente) throws SQLException {
		conector.setAutoCommit(false);
		  sentencia = conector.prepareStatement("Select * from Personajes where nombre like ?");
	      sentencia.setString(1,nombreCliente);
	      ResultSet resultado=sentencia.executeQuery();	
	      int nivel=1;
	      while(resultado.next()){
	    	  nivel=resultado.getInt(4);	    	  
	      }
	      sentencia.close();
	      conector.commit();

		return nivel;      
	}
	
	
	
}
