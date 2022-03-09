package singleton;

public class Test {
    
    static int contatoreIstanzeCifratura;

    public static void main(String[] args) {
        
        Messaggio messaggio = new Messaggio("Hello world");
        Contatto contatto = new Contatto("Alessandro");
        
        System.out.println(messaggio.ritornaTestoCriptato());
        System.out.println(contatto.ritornaNomeCriptato());
        
        System.out.println(contatoreIstanzeCifratura);
    }
}
