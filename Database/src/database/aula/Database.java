package database.aula;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    //attributi
    private final String URL = "jdbc:mysql://localhost:3306/esercizio";
    private final String USER_NAME = "root";
    private final String PASSWORD = null;
    
    //metodo per stabilire la connessione con il database
    public Connection creaConnessione() { //interfaccia per la connessione
        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
    
    //metodo per registrare una persona nel database
    public void registraPersona1(Connection c, Persona p) {
        String queryInutile = "INSERT INTO persone (nome,cognome,eta) VALUES ('Mario', 'Rossi','50')";
        String query = "INSERT INTO persone (nome,cognome,eta)"
                + " VALUES ('" + p.getNome() + "', '" + p.getCognome() + "','" + p.getEta() + "')";
        try(Connection connection = c; Statement st = connection.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //metodo per registrare una seconda persona
    public void registraPersona2(Connection c, Persona p) {
        String query = "INSERT INTO persone (nome,cognome,eta) VALUES (?,?,?)";
        try(Connection connection = c; PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, p.getNome());
            st.setString(2, p.getCognome());
            st.setInt(3, p.getEta());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    //metodo per leggere tutta la tabella persone
    public void leggiTabella(Connection c) {
        String query = "SELECT * FROM persone";
        try(Connection connection = c; Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            Persona.getPersone().clear();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCognome(rs.getString("cognome"));
                p.setEta(rs.getInt("eta"));
                Persona.getPersone().add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //metodo per aggiornare i dati di una persona
    public void modificaPersona(Connection c, Persona p) {
        String query = "UPDATE persone SET cognome=?,eta=? WHERE id=?";
        try(Connection connection = c; PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, p.getCognome());
            st.setInt(2, p.getEta());
            st.setInt(3, p.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //metodo per rimuovere persona dal database
    public void cancellaPersona(Connection c, int id) {
        String query = "DELETE FROM persone WHERE id=?";
        try(Connection connection = c; PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
