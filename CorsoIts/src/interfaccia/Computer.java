package interfaccia;

public abstract class Computer implements Utilita{

    private String sistemaOperativo;
    
    //costruttore

    public Computer(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    
    //getter

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    
    //metodo concreto con logica adatta sia a desktop che a laptop
    public void installaProgramma(String programma) {
        
        System.out.println("Sto installando " + programma);
    }
    
    //metodo astratto necessario a entrambi ma con logica distinta
    public abstract void sospendi();
}
