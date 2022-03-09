
package fogli.alessandro.oggetti;


public class Test
{
    public static void main(String[] args)
    {
        Smartphone s1 = new Smartphone();
        Smartphone s2 = new Smartphone();
        Smartphone s3 = new Smartphone();

        //System.out.println(s1.marca);
        //System.out.println(s2.colore);
        //System.out.println(s1.numeroSerie);

        Smartphone s4 = new Smartphone("Samsung", "A-10", "nero", 123);
        Smartphone s5 = new Smartphone("Xiaomi", "Mi 9 SE", "blu", 456);
        Smartphone s6 = new Smartphone("Apple", "Iphone 12 Pro", "Bianco", 789);

        System.out.println(s4.marca);
        System.out.println(s5.modello);
        System.out.println(s6.colore);

        s1.chiamare(555666777);
        s4.inviareMessaggi(33332222);
        s2.scattareFotografie();
        s6.registrareVideo();

        Smartphone.tutti[0] = s4;
        Smartphone.tutti[1] = s5;
        Smartphone.tutti[2] = s6;

        Smartphone.squillano();

        s1.setMarca("Nokia");
        System.out.println(s1.getMarca());

        System.out.println(s5.stampa());
    }
}
