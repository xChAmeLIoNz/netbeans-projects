package agenzia;

public class Appartamenti extends Immobile{
    //attributi
    private int pianoElevazione;
    private boolean ascensore; //true=si, false=no
    
    //costruttore

    public Appartamenti(int pianoElevazione, boolean ascensore, int codice, double superficieImmobile, double prezzo) {
        super(codice, superficieImmobile, prezzo);
        this.pianoElevazione = pianoElevazione;
        if(ascensore == true) {
            this.ascensore = ascensore;
        }
    }
    
    //getter

    public int getPianoElevazione() {
        return pianoElevazione;
    }

    public boolean isAscensore() {
        return ascensore;
    }
    
    //setter

    public void setPianoElevazione(int pianoElevazione) {
        this.pianoElevazione = pianoElevazione;
    }

    public void setAscensore(boolean ascensore) {
        this.ascensore = ascensore;
    }
    
}
