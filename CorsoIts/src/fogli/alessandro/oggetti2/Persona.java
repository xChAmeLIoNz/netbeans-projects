
package fogli.alessandro.oggetti2;

public class Persona
{

//attributi
//posso mettere private prima degli attributi per renderli visibili solo a questa classe
//vedi sotto come fare per modificare uno di questi attributi
private String nome;
private String cognome;
private int eta;

    public Persona(String nome, String cognome, int eta)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

public void camminare()
{
    System.out.println(nome + " sta camminando");
}

public void mangiare()
{
    System.out.println(cognome + " sta mangiando");
}

    public int getEta()
    {
        return eta;
    }

    public String getCognome()
    {
        return cognome;
    }


    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }




}
