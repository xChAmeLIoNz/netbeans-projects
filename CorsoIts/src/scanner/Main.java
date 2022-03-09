package scanner;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        boolean isTrue = sc.hasNext();
//        String s = sc.next().toUpperCase();
        System.out.println(i);
        System.out.println(isTrue);
//        System.out.println(s);
    }
}
