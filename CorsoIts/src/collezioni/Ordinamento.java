package collezioni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordinamento {

    public static void main(String[] args) {
        Persona p1 = new Persona("Alessandro", 19);
        Persona p2 = new Persona("Mario", 34);
        
        List<Persona> persone = new ArrayList<>();
        persone.add(p1);
        persone.add(p2);
        
        System.out.println(persone);
        
        Collections.sort(persone);
        
        System.out.println(persone);
        
        Comparator<Persona> comparator = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getEta() - o2.getEta();
            }
        };
        
        Collections.sort(persone, comparator);
        
        System.out.println(persone);
    }
}

class Persona implements Comparable<Persona> {
    private String nome;
    private int eta;
    
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Persona{" + "nome=" + nome + ", eta=" + eta + '}';
    }

    @Override //metodo callback (invocati automaticamente)
    public int compareTo(Persona o) {
        return nome.compareTo(o.nome);
    }
    
    
    
}
