package astratte;

//con abstract non posso a costruire tale classe, ma solo gli extends
public abstract class Persona {

    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }
    
    //getter

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }
    
    public void mangiare(){
        
        System.out.println(nome + " sta mangiando");
    }
    
    public abstract void tempoLibero(); //in questo modo ogni classe che estende 
                                        //Persona deve per forza avere questo metodo,
}                                       //deciderà poi se usarlo o no (non faccio il corpo)
