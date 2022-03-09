package astratte;


public class Test {

    public static void main(String[] args) {
        
        //Persona persona = new Persona;
        Persona p1 = new Studente("Ale", 19, 9);
        Persona p2 = new Lavoratore("Mario", 34, 1400.37);
        
        System.out.println(p1.getNome());
        System.out.println(p2.getEta());
        p1.mangiare();
        p2.mangiare();
        p1.tempoLibero();
        p2.tempoLibero();
        
        ((Studente)p1).studiare(); 
        /*faccio un casting esplicito perchè studiare è un metodo della classe
        studente e ho bisogno di trasformare Persona in Studente
        
        Esplicito perchè Persona non è necessariamente uno Studente, ma in questo
        caso ho bisogno di farlo diventare forzatamente*/
        
        Lavoratore lav = (Lavoratore) p2;
        lav.lavorare();
        
        
        
        
    }
}
