
package fogli.alessandro.oggetti;


public class Smartphone 
{
    
//attributi oggetti (variabili d'istanza)
String marca;
String modello;
String colore;
long numeroSerie;

//variabile di classe (variabile statica)
static Smartphone[] tutti;

//blocco inizializzazione statico
static
{
tutti = new Smartphone[3];
}

//costruttori
public Smartphone(String marca, String modello, String colore, long numeroSerie)
{
  this.marca = marca;
  this.modello = modello;
  this.colore = colore;
  this.numeroSerie = numeroSerie;
}

public Smartphone(){}

//utilità oggetti (metodi d'istanza)
void chiamare(long numero)
{
    System.out.println("Sto chiamando " + numero);
}

void inviareMessaggi(long numero)
{
    System.out.println("Sto inviando un messaggio a: " + numero);
}

void scattareFotografie()
{
    System.out.println("Sto scattando una foto");
}

void registrareVideo()
{
    System.out.println("Sto registrando un video");
}

//utilità classe (metodo statico)
static void squillano()
{
for(int i = 0; i < tutti.length; i++)
{
    System.out.println("smartphone " + tutti[i].marca + " sta squillando");
}
}

//getter and setter

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModello()
    {
        return modello;
    }

    public void setModello(String modello)
    {
        this.modello = modello;
    }

    public String getColore()
    {
        return colore;
    }

    public void setColore(String colore)
    {
        this.colore = colore;
    }

    public long getNumeroSerie()
    {
        return numeroSerie;
    }

    public void setNumeroSerie(long numeroSerie)
    {
        this.numeroSerie = numeroSerie;
    }

    public static Smartphone[] getTutti()
    {
        return tutti;
    }

    public static void setTutti(Smartphone[] tutti)
    {
        Smartphone.tutti = tutti;

    }

public String stampa()
{
return marca + " - " + modello + " - " + colore + " - " + numeroSerie; 
}








}
