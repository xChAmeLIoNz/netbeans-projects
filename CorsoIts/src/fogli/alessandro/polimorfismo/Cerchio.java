
package fogli.alessandro.polimorfismo;

public class Cerchio extends Figura
{

//fn+alt+ins override method
@Override
void disegna()
{
    System.out.println("disegno un cerchio");
}


void disegna(String colore)
{
    System.out.println("disegno un cerchio " + colore);
}


}
