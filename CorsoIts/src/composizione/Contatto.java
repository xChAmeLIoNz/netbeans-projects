package composizione;

public class Contatto {

    private String nome;
    private Indirizzo indirizzo;
    
    //costruttore

    public Contatto(String nome, Indirizzo indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }
    
    //getter

    public String getNome() {
        return nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }
    
}
