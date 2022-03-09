package database.aula;
import javax.sql.rowset.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        //istanzio 3 oggetti persona
//        Persona p1 = new Persona("Maria", "Rossi", 50);
//        Persona p2 = new Persona("Laura", "Bianchi", 50);
//        Persona p3 = new Persona("Giovanni", "Verdi", 50);
//        
//        Database db = new Database();
        
        //db.registraPersona1(db.creaConnessione(), p1);
        //db.registraPersona2(db.creaConnessione(), p2);
        //db.registraPersona2(db.creaConnessione(), p3);
        
        //System.out.println(Persona.getPersone());
//        db.leggiTabella(db.creaConnessione());
//        System.out.println(Persona.getPersone());
        
        //Persona.getPersone().get(2).setCognome("Gialli");
        //Persona.getPersone().get(2).setEta(26);
        //db.modificaPersona(db.creaConnessione(), Persona.getPersone().get(2));
//        db.leggiTabella(db.creaConnessione());
//        System.out.println(Persona.getPersone());
//        db.cancellaPersona(db.creaConnessione(), Persona.getPersone().get(1).getId());
//        db.leggiTabella(db.creaConnessione());
//        System.out.println(Persona.getPersone());
        
        //prova RowSet
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/esercizio");
        rowSet.setUsername("root");
        rowSet.setPassword(null);
        rowSet.setCommand("SELECT * FROM persone");
        rowSet.execute();
        while (rowSet.next()) {
            System.out.println("id: " + rowSet.getInt(1));
            System.out.println("nome: " + rowSet.getString(2));
            System.out.println("cognome: " + rowSet.getString(3));
            System.out.println("età: " + rowSet.getInt(4));
        }
    }
}
