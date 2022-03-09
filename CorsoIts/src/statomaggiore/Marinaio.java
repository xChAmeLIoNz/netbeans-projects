package statomaggiore;


public class Marinaio extends Militare{

    private String naveDiImbarco;

    public Marinaio(String naveDiImbarco, String nome, String cognome, int matricola) {
        super(nome, cognome, matricola);
        this.naveDiImbarco = naveDiImbarco;
    }

    @Override
    void azioneSoldato() {
        
        System.out.println("Il marinaio naviga");
    }

    @Override
    public String toString() {
        return super.toString() + " Nave di imbarco: " + naveDiImbarco; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
}
