package singleton;

public class Contatto {

    private String nome;

    public Contatto(String nome) {
        this.nome = nome;
    }
    
    //metodo
    public String ritornaNomeCriptato(){
        
        return Cifratura.getInstance().cifra(nome);
    }
}
