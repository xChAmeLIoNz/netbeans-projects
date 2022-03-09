
package oggetti5;

public class Test
{
    public static void main(String[] args)
    {
        Persona p = new Persona("Alessandro", "Fogli", 19, "FGLLSN02L12E410J");
        Persona p1 = new Persona("Mario", "Rossi", 27, "RSSMARR23J22K1X");
        Persona p2 = new Persona("Ciccio", "Lina", 14, "FGLLSN02L12E410J");

        //System.out.println(p.toString());
        //System.out.println(p1.toString());

        
        System.out.println(p.equals(p2));
        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());




    }
}
