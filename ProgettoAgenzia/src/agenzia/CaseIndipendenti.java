package agenzia;

public class CaseIndipendenti extends Immobile {
    //attributi
    private double superficieGiardino;
    private boolean piscina;
    
    //costruttore

    public CaseIndipendenti(double superficieGiardino, boolean piscina, int codice, double superficieImmobile, double prezzo) {
        super(codice, superficieImmobile, prezzo);
        this.superficieGiardino = superficieGiardino;   
        if(piscina == true) {
            this.piscina = piscina;
        }
    }
    
}
