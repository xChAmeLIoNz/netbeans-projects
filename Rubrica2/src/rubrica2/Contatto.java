package rubrica2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Contatto {
    //attributi
    private int id;
    private String nome;
    private String cognome;
    private Indirizzo indirizzo;
    private String telefono;
    private String mail;
    private static List<Contatto> contatti; //contenitore per stocckare i contatti
    
    /*Se fosse d'istanza mi creerebbe una lista per ogni contatto che creo*/
    
    //blocco inizializzazione statico, prima dell'invocazione della classe, questo blocco parte
    static { 
        contatti = new ArrayList<>();
    }
    
    //costruttore

    public Contatto(String nome, String cognome, Indirizzo indirizzo, String telefono, String mail) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        
        if(telefono.isEmpty()) {
            this.telefono = "---";   //campo telefono può essere omesso, ma il database deve ricevere cmq qualcosa
        }else {
            this.telefono = telefono;
        }        
        
        this.mail = mail;
    }
    
    public Contatto(){}
    
    //getter

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public static List<Contatto> getContatti() {
        return contatti;
    }
    
    //setter

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setTelefono(String telefono) {
        if(telefono.isEmpty()) {
        this.telefono = "---";
        }else {
            this.telefono = telefono;
        }
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    //metodo per controllare i dati in input
    public static boolean controlloDati(String... dati) {   //è un tipo di array che uso solo nei metodi
        
        boolean datiOk = false; //parto dal presupposto che l'utente inserisca dei dati sbagliati
        final String ESPRESSIONE_STANDARD = "[a-zA-Z\\s'.]{1,}"; //[dati consentiti]{min caratteri, max caratteri}
        final String ESPRESSIONE_CIVICO = "[0-9a-zA-Z/_-]{1,}"; //il trattino va inserito alla fine
        final String ESPRESSIONE_CAP = "[0-9]{5}";
        final String ESPRESSIONE_TELEFONO = "[0-9+-]{1,}";
        final String ESPRESSIONE_MAIL = "[0-9a-zA-Z_.-]+@[A-Za-z]+.[a-zA-Z]{2,3}";
        
        if(Pattern.matches(ESPRESSIONE_STANDARD, dati[0]) &&
                Pattern.matches(ESPRESSIONE_STANDARD, dati[1]) &&
                Pattern.matches(ESPRESSIONE_STANDARD, dati[2]) &&
                Pattern.matches(ESPRESSIONE_CIVICO, dati[3]) &&
                Pattern.matches(ESPRESSIONE_CAP, dati[4]) &&
                Pattern.matches(ESPRESSIONE_STANDARD, dati[5]) &&
                Pattern.matches(ESPRESSIONE_STANDARD, dati[6]) &&
                Pattern.matches(ESPRESSIONE_MAIL, dati[8])) {
            
            datiOk = true;
            if(!dati[7].isEmpty() && !Pattern.matches(ESPRESSIONE_TELEFONO, dati[7])) {
                datiOk = false;
                /*se l'utente inserisce il tel ed è sbagliato, datiOk = false
                se l'utente inserisce il tel corretto, datiOk rimane true*/
            }
        }
        
        return datiOk;
    }
    
    
}
