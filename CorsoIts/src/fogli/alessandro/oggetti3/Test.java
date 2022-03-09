
package fogli.alessandro.oggetti3;

public class Test
{
    public static void main(String[] args)
    {
        Cane cane = new Cane("Carlino", "Bianco", 10.3);

cane.abbaiare();

Cane cane2 = new Cane();
cane2.setRazza("Terranova");
cane2.abbaiare();
    }
}
