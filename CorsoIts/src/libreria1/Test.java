package libreria1;


public class Test {

    public static void main(String[] args) {
        
        Libro l1 = new Libro("libro1", "autore1", 1928);
        Libro l2 = new Libro("libro2", "autore2", 2002);
        Libro l3 = new Libro("libro3", "autore3", 2020);
        
        Libro[] arrayLibro = new Libro[3];
        
        arrayLibro[0] = l1;
        arrayLibro[1] = l2;
        arrayLibro[2] = l3;
        
        for(int i = 0; i < arrayLibro.length; i++){
            
            System.out.println("Libro n. " + (i + 1) + ": " + arrayLibro[i].toString());
        }
        
    }
}
