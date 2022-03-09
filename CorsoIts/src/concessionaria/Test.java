package concessionaria;


public class Test {

    public static void main(String[] args) {
        
        Automobile a1 = new Automobile("Honda", "Civic", "GC452FF");
        
        a1.setPrezzo(12500.67);
        a1.setKmPercorsi(125000);
        
        System.out.println(a1);
        a1.modificaKmEValore();
        System.out.println(a1);
    }
}
