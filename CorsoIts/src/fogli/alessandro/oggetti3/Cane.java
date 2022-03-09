
package fogli.alessandro.oggetti3;

public class Cane
{
String razza;
String colore;
double peso;

public Cane(String razza, String colore, double peso)
{
this.razza = razza;
this.colore = colore;
this.peso = peso;

}
public Cane()
{
}

public void setRazza(String razza)
{
this.razza = razza;
}


public void abbaiare()
{
    System.out.println(razza + " fa bau bau");
}



}
