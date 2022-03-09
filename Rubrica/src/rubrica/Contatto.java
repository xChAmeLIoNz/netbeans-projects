package rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Contatto {
    private String nome;
    private String cognome;
    private String via;
    private String civico;
    private int cap;
    private String provincia;
    private String comune;
    private String telefono;
    private String email;
    private static List<Contatto> elencoContatti;
    
    static{
        elencoContatti = new ArrayList<>();
    }

    public Contatto(String nome, String cognome, String via, String civico, int cap, String provincia, String comune, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.provincia = provincia;
        this.comune = comune;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Contatto> getElencoContatti() {
        return elencoContatti;
    }

    public static void setElencoContatti(List<Contatto> elencoContatti) {
        Contatto.elencoContatti = elencoContatti;
    }



 
    
    public static boolean controlloDati(String nome, String cognome, String via, String civico,
            int cap, String comune, String provincia, String telefono, String email) {
        return Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, nome) && 
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, cognome) && 
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, via) && 
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, civico) &&
                Pattern.matches(Controllo.ESPRESSIONE_CAP, Integer.toString(cap)) &&
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, comune) &&
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, provincia) &&
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NUMERO, telefono) &&
                Pattern.matches(Controllo.ESPRESSIONE_CONTROLLO_NOMINALE, email);
        
    
    
        
    }
    

}
