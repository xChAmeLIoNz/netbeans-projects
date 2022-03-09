package concessionaria;


public class Automobile {

    private String marca;
    private String modello;
    private String targa;
    private double prezzo;
    private int kmPercorsi;
    
    //costruttore

    public Automobile(String marca, String modello, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
    }
    
    //setter

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setKmPercorsi(int kmPercorsi) {
        this.kmPercorsi = kmPercorsi;
    }
    
    //getter 

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getKmPercorsi() {
        return kmPercorsi;
    }
    
    public void modificaKmEValore(){
        
        kmPercorsi += 10;
        prezzo--;
    }
    
    //toString

    @Override
    public String toString() {
        return "Automobile{" + "marca=" + marca + ", modello=" + modello + 
                ", targa=" + targa + ", prezzo=" + prezzo + ", kmPercorsi=" 
                + kmPercorsi + '}';
    }
    
}
