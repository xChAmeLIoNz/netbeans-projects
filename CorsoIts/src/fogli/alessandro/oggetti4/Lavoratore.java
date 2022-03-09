
package fogli.alessandro.oggetti4;

public class Lavoratore extends Persona
{
//attributi
int matricolaAziendale;
double reddito;

//costruttore

    public Lavoratore(String nome, String cognome, int eta, int matricolaAziendale, double reddito)
    {
        super(nome, cognome, eta);
        this.matricolaAziendale = matricolaAziendale;
        this.reddito = reddito;
    }

//metodo
void lavorare()
{
    System.out.println(cognome + " sta lavorando e ha " + eta + " anni");
}

//getter

    public int getMatricolaAziendale()
    {
        return matricolaAziendale;
    }

    public double getReddito()
    {
        return reddito;
    }


}
