package promotionSystem;

import com.google.gson.JsonArray;

import java.sql.*;

public class Conector {
	private Connection conector;
	PreparedStatement sentencia;

	public Conector() throws Exception {
			Class.forName("org.sqlite.JDBC");
			conector = DriverManager.getConnection("jdbc:sqlite:kom.bd");
	}

	public void agregarUsuario(String nombre, int contrasena) throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("INSERT INTO Usuario (nombre,contrasena) values (?,?);");
		sentencia.setString(1, nombre);
		sentencia.setInt(2, contrasena);
		sentencia.executeUpdate();
		sentencia.close();
		conector.commit();
	}

	public boolean validarUsuario(String nombre, int contrasena) throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select Count(*) from Usuario where nombre like ? AND contrasena=?");
		sentencia.setString(1, nombre);
		sentencia.setInt(2, contrasena);
		ResultSet resultado = sentencia.executeQuery();
		boolean devolver = resultado.next() && resultado.getInt(1) == 1;
		sentencia.close();
		conector.commit();

		return devolver;
	}

	public boolean validarNombreUsuario(String nombre) throws Exception {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select Count(*) from Usuario where nombre like ?");
		sentencia.setString(1, nombre);
		ResultSet resultado = sentencia.executeQuery();
		boolean devolver = resultado.next() && resultado.getInt(1) == 1;
		sentencia.close();
		conector.commit();
		return devolver;

	}

	public void agregarPersonaje(Personaje personaje) throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("INSERT INTO Personaje (nombre,raza,casta,nivel) values (?,?,?,?);");
		sentencia.setString(1, personaje.getNombre());
		sentencia.setString(2, personaje.getRaza());
		sentencia.setString(3, personaje.getCasta());
		sentencia.setInt(4, personaje.getNivel());
		sentencia.executeUpdate();
		sentencia.close();
		conector.commit();
	}

	public String obtenerRazaPersonaje(String nombreCliente) throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select * from Personaje where nombre like ?");
		sentencia.setString(1, nombreCliente);
		ResultSet resultado = sentencia.executeQuery();
		String raza = null;
		while (resultado.next()) {
			raza = resultado.getString(2);
		}

		sentencia.close();
		conector.commit();

		return raza;
	}

	public String obtenerCastaPersonaje(String nombreCliente) throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select * from Personaje where nombre like ?");
		sentencia.setString(1, nombreCliente);
		ResultSet resultado = sentencia.executeQuery();
		String casta = null;
		while (resultado.next()) {
			casta = resultado.getString(3);
		}
		sentencia.close();
		conector.commit();

		return casta;
	}

	public int obtenerNivelPersonaje(String nombreCliente) throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select * from Personaje where nombre like ?");
		sentencia.setString(1, nombreCliente);
		ResultSet resultado = sentencia.executeQuery();
		int nivel = 1;
		while (resultado.next()) {
			nivel = resultado.getInt(4);
		}
		sentencia.close();
		conector.commit();

		return nivel;
	}

	public JsonArray obtenerRazas() throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select * from Raza");
		ResultSet resultado = sentencia.executeQuery();
        JsonArray razas = new JsonArray();
        while(resultado.next()){
            razas.add(resultado.getString("nombre"));
        }
        sentencia.close();
		conector.commit();

		return razas;
	}

    public JsonArray obtenerCastas() throws SQLException {
        conector.setAutoCommit(false);
        sentencia = conector.prepareStatement("Select * from Casta");
        ResultSet resultado = sentencia.executeQuery();
        JsonArray castas = new JsonArray();
        while(resultado.next()){
            castas.add(resultado.getString("nombre"));
        }
        sentencia.close();
        conector.commit();

        return castas;
    }

	public JsonArray obtenerMapas() throws SQLException {
		conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select * from Mapa");
		ResultSet resultado = sentencia.executeQuery();
		JsonArray mapas = new JsonArray();
		while(resultado.next()){
			mapas.add(resultado.getString("nombre"));
		}
		sentencia.close();
		conector.commit();

		return mapas;
	}

	public void registrarAlianza(Alianza alianza) throws SQLException {
	    conector.setAutoCommit(false);
        sentencia = conector.prepareStatement("INSERT INTO Alianza(id) VALUES(?)");
        sentencia.setInt(1, alianza.getId());
        sentencia.executeUpdate();
        asignarPersonajesA(alianza);
        sentencia.close();
        conector.commit();
	}

    public void actualizarAlianza(Alianza alianza) throws SQLException {
        conector.setAutoCommit(false);
        asignarPersonajesA(alianza);
        sentencia.close();
        conector.commit();
    }

    private void asignarPersonajesA(Alianza alianza) throws SQLException {
        for(Personaje personaje : alianza.getPersonajes()){
            sentencia = conector.prepareStatement("UPDATE Personaje SET idAlianza = ? WHERE nombre = ?");
            sentencia.setInt(1, alianza.getId());
            sentencia.setString(2, personaje.getNombre());
            sentencia.executeUpdate();
        }
    }
    /*
    public Personaje obtenerPersonaje(String nombreCliente){
    	conector.setAutoCommit(false);
		sentencia = conector.prepareStatement("Select * from Personaje where nombre like ?");
		sentencia.setString(1, nombreCliente);
		ResultSet resultado = sentencia.executeQuery();
		Personaje personaje = crearPersonajeAPartirDeRazaYCasta(resultado);
    }*/
    
    private Personaje crearPersonajeAPartirDeRazaYCasta(ResultSet resultado) throws Exception {
		Personaje personaje = (Personaje) Class.forName("promotionSystem.razas.castas." + resultado.getString(2) + "." + resultado.getString(3)).newInstance();
		personaje.setNombre(resultado.getString(1));
		personaje.setNivel(resultado.getInt(4));
		//FALTAN ITEMS
		return personaje;
	}
}
