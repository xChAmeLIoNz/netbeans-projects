
package fogli.alessandro.oggetti4;

public class Persona
{
//attributi
//posso mettere private prima degli attributi per renderli visibili solo a questa classe
//vedi sotto come fare per modificare uno di questi attributi
String nome;
String cognome;
int eta;

//costruttore fn+alt+ins

    public Persona(String nome, String cognome, int eta)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

//metodi

void camminare()
{
    System.out.println(nome + " sta camminando");
}

void mangiare()
{
    System.out.println(nome + " sta mangiando");
}

void parlare()
{
    System.out.println(nome + " sta parlando");
}

//getter

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public int getEta()
    {
        return eta;
    }

//setter
//ora che gli attributi sono private, l'unico modo per modificarli è usare un setter
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }





}
