
package oggetti5;

public class Persona
{
private String nome;
private String cognome;
private int eta;
private String codiceFiscale;

//costruttore

    public Persona(String nome, String cognome, int eta, String codiceFiscale)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
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

    public String getCodiceFiscale()
    {
        return codiceFiscale;
    }

@Override
public String toString()
{
return "Nome: " + nome + ", Cognome: " + cognome + ", Età: " + eta 
+ ", Codice Fiscale: " + codiceFiscale;
}

@Override
public boolean equals(Object obj)
{
if(obj instanceof Persona)
{
return this.codiceFiscale.equals(((Persona) obj).codiceFiscale);
}

return false;
}

@Override
public int hashCode()
{
return codiceFiscale.hashCode();
}



}
