package fogli.alessandro.esercizi.step3;
import java.util.Arrays;

public class Es02 {

    public static void main(String[] args) {
        
        String[] arrayUno = {"uno", "due", "tre"};
        String[] arrayDue = {"quattro", "cinque", "sei"};
        
        System.out.println(Arrays.toString(arrayUno));
        System.out.println(Arrays.toString(arrayDue));
        
        scambia(arrayUno, arrayDue);
        
        System.out.println();
        System.out.println(Arrays.toString(arrayUno));
        System.out.println(Arrays.toString(arrayDue));
    }
    
    public static void scambia(String[] a1, String[] a2){

if(a1.length == a2.length){

    for(int i = 0; i < a1.length; i++){
        
        String temp = "";
        temp = a1[i];
        a1[i] = a2[i];
        a2[i] = temp;
        
    }
}

}
    
    }
    

    
