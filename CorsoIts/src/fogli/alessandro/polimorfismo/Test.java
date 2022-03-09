
package fogli.alessandro.polimorfismo;

public class Test
{
    public static void main(String[] args)
    {
        Figura figura = new Figura();
        figura.disegna();

        Figura figura2 = new Rettangolo();
        figura2.disegna();

        Figura figura3 = new Cerchio();
        figura3.disegna();

  
        Cerchio cerchio = new Cerchio();
        cerchio.disegna("rosso");
    }
}
