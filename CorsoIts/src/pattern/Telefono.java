package pattern;

import java.util.Arrays;


public final class Telefono {

    //attributi
    private final String marca;
    private final int[] dimensioni;

    //costruttore
    public Telefono(String marca, int[] dimensioni) {
        //per rendere l'array immutabile faccio cosi
        int[] copia = Arrays.copyOf(dimensioni, 3);
        this.marca = marca;
        this.dimensioni = copia;
    }

    public final String getMarca() {
        return marca;
    }

    public final int[] getDimensioni() {
        return Arrays.copyOf(dimensioni, 3);
    }
    
    //metodo d'istanza
    public final void squilla(){
        
        System.out.println("Il telefono " + marca + " sta squillando");
    }
    
    
}
