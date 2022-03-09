package rubrica;


public class Test {

    public static void main(String[] args) {
        
        Contatto c1 = new Contatto("Alessandro", "alessandro.fogli@gmail.com");
        Contatto c2 = new Contatto("Andrea", "andrea.marz@gmail.com");
        Contatto c3 = new Contatto("Giacomo", "giacomo.alberi@gmail.com");
        
        c1.inviaMail();
        
        //creo array che contiene oggetti di tipo contatto che ospita 3 elementi
        Contatto[] contatti = new Contatto[3];
        contatti[0] = c1;
        contatti[1] = c2;
        contatti[2] = c3;
        
        //statico
        Contatto.mostraRubrica(contatti);
        
        
    }
}
