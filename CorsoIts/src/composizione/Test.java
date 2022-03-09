package composizione;

public class Test {

    public static void main(String[] args) {
        
        Contatto contatto = new Contatto("Alessandro", new Indirizzo("Via verdi", "15/A", 44122));
        
        //invoco metodo spedisci
        contatto.getIndirizzo().spedisci();
        
    }
}
