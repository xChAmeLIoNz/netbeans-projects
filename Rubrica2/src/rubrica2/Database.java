package rubrica2;
import java.sql.*;

public class Database {
    //metodo per creare la connessione
    public Connection creaConnessione() {
        Connection connection = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:rubrica.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.exit(1);
        }
        return connection;
    }
    //metodo per creare la tabella dei contatti
    public void creaTabellaContatti(Connection connection) {
        try(Connection c = connection;Statement st = c.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS contatti"
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL,"
                    + " cognome TEXT NOT NULL, via TEXT NOT NULL,"
                    + " civico TEXT NOT NULL, cap INTEGER NOT NULL,"
                    + " comune TEXT NOT NULL, provincia TEXT NOT NULL,"
                    + " telefono TEXT NOT NULL, mail TEXT NOT NULL)";
            st.execute(query);
        } catch (SQLException e) {
            System.exit(1);
        }
    }
    
    //metodo per registrare contatto nel database
    public int inserisciContatto(Connection connection, Contatto contatto) {
        
        String query = "INSERT INTO contatti (nome, cognome, via, civico, "
                + "cap, comune, provincia, telefono, mail)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try(Connection c = connection; PreparedStatement st = c.prepareStatement(query)) {
            st.setString(1, contatto.getNome());
            st.setString(2, contatto.getCognome());
            st.setString(3, contatto.getIndirizzo().getVia());
            st.setString(4, contatto.getIndirizzo().getCivico());
            st.setInt(5, contatto.getIndirizzo().getCap());
            st.setString(6, contatto.getIndirizzo().getComune());
            st.setString(7, contatto.getIndirizzo().getProvincia());
            st.setString(8, contatto.getTelefono());
            st.setString(9, contatto.getMail());
            return st.executeUpdate(); //ritorna 1 se crea il contatto
        } catch (SQLException e) {
            return -1;
        }
    }
    
    //metodo recuperare dal db l'id del contatto appena inserito
    public int leggiIdUltimoContatto(Connection connection) {
        String query = "SELECT id FROM contatti ORDER BY id DESC LIMIT 1";
        try(Connection c = connection; Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            return -1;
        }
    }
    
    //metodo per leggere tutta la tabella contatti
    public void leggiTabella(Connection connection) {
        String query = "SELECT * FROM contatti";
        try(Connection c = connection; Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            Contatto.getContatti().clear();
            while(rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setId(rs.getInt("id"));
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setIndirizzo(new Indirizzo(rs.getString("via"),
                rs.getString("civico"), rs.getInt("cap"), rs.getString("comune"), 
                rs.getString("provincia")));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setMail(rs.getString("mail"));
                Contatto.getContatti().add(contatto);
            }
            
        } catch (SQLException e) {
            System.exit(1);
        }
    }
    
    //metodo per modificare un contatto
    public void modificaContatto(Connection connection, Contatto contatto) {
        String query = "UPDATE contatti SET nome=?, cognome=?, via=?, civico=?, "
                + "cap=?, comune=?, provincia=?, telefono=?, mail=? WHERE id=?";
        try(Connection c = connection; PreparedStatement st = c.prepareStatement(query)) {
            st.setString(1, contatto.getNome());
            st.setString(2, contatto.getCognome());
            st.setString(3, contatto.getIndirizzo().getVia());
            st.setString(4, contatto.getIndirizzo().getCivico());
            st.setInt(5, contatto.getIndirizzo().getCap());
            st.setString(6, contatto.getIndirizzo().getComune());
            st.setString(7, contatto.getIndirizzo().getProvincia());
            st.setString(8, contatto.getTelefono());
            st.setString(9, contatto.getMail());
            st.executeUpdate(); //ritorna 1 se crea il contatto
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
    
    //metodo per cancellare un contatto
    public void cancellaContatto(Connection connection, int idContatto) {
        String query = "DELETE FROM contatti WHERE id=?";
        try(Connection c = connection; PreparedStatement st = c.prepareStatement(query)) {
            st.setInt(1, idContatto);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
