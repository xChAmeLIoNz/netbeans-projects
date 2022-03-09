
package esecuzione;
import libreria.Matematica;

public class MiaMatematica extends Matematica
{
    public static void main(String[] args)
    {
        MiaMatematica m = new MiaMatematica();
        System.out.println(m.somma(10, 5));
    }
}
