
package libreria;

public class Matematica
{

//visibile a tutte le classi degli altri package
public int somma(int a, int b)
{
return a + b;

}

//piu riservato, visibile alle classi dello stesso package 
//o classi fuori package con rapporto ereditario (sotto classi)
protected int sottrazione(int a, int b)
{
return a - b;
}

//visibile solo alle classi dello stesso package
int moltiplicazione(int a, int b)
{
return a * b;
}

//visibile a nessuno, solo in questa classe
private double divisione(double a, double b)
{
return a / b;
}


}
