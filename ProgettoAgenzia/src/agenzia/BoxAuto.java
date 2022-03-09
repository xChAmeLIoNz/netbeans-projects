package agenzia;

public class BoxAuto extends Immobile{
    //attributi
    private int postiAuto;
    
    //costruttore

    public BoxAuto(int postiAuto, int codice, double superficieImmobile, double prezzo) {
        super(codice, superficieImmobile, prezzo);
        this.postiAuto = postiAuto;
    }
    
    //getter

    public int getPostiAuto() {
        return postiAuto;
    }
    
    //setter

    public void setPostiAuto(int postiAuto) {
        this.postiAuto = postiAuto;
    }
    
}
