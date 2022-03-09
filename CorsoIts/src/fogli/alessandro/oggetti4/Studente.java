
package fogli.alessandro.oggetti4;

public class Studente extends Persona
{
//attributi
int idScolastico;
double mediaVoti;

    public Studente(String nome, String cognome, int eta, int idScolastico, double mediaVoti)
    {
        super(nome, cognome, eta);
        this.idScolastico = idScolastico;
        this.mediaVoti = mediaVoti;
    }

void studiare()
{
    System.out.println(nome + " sta studiando");
}

//getter

    public int getIdScolastico()
    {
        return idScolastico;
    }

    public double getMediaVoti()
    {
        return mediaVoti;
    }


}
