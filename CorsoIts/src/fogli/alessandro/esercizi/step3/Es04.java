package fogli.alessandro.esercizi.step3;

import java.util.Arrays;
import java.util.Random;


public class Es04 {

    public static void main(String[] args) {
        
        int[] arrayUno = new int[10];
        
        popolaArray(arrayUno);
        System.out.println(Arrays.toString(arrayUno));
        ordinaArray(arrayUno);
        System.out.println(Arrays.toString(arrayUno));
    }
    
    public static void popolaArray(int[] a1){
        
        for(int i = 0; i < a1.length; i++){
            
            a1[i] = new Random().nextInt((101 - 0) + 1)+ 0;
        }
    }
    
    public static void ordinaArray(int [] a1){
        
        Arrays.sort(a1);
    }
    
}
