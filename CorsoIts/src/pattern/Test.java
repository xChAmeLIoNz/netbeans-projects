package pattern;

import java.util.Arrays;


public class Test {

    public static void main(String[] args) {
        
        int[] d = {10, 15, 20};
        
        Telefono telefono = new Telefono("Motorola", d);
        
        System.out.println(Arrays.toString(telefono.getDimensioni()));
        
        d[0] = 32;
        //in classe Telefono ho reso questo array immutabile, facendo una copia
        
        System.out.println(Arrays.toString(telefono.getDimensioni()));
        
        //non è ancora del tutto immutabile
        int[] altroArray = telefono.getDimensioni();
        
        altroArray[0] = 54;
        //per renderlo immutabile ho cambiato il getter di dimensioni
        
        System.out.println(Arrays.toString(telefono.getDimensioni()));
        
    }
}
