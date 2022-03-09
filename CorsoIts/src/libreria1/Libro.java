package libreria1;


public class Libro {

    private String titolo;
    private String autore;
    private int annoDiPubblicazione;

    //costruttore
    public Libro(String titolo, String autore, int annoDiPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    @Override
    public String toString() {
        return "Libro{" + "titolo=" + titolo + ", autore=" + autore + ", annoDiPubblicazione=" + annoDiPubblicazione + '}';
    }
    
    
    
    
}
