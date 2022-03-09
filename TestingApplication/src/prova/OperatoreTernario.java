package prova;


public class OperatoreTernario {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 20;
        
        int result = (a < b) ? (a) : (b);
        //istanzio var, condizione, ? è "then", : è "else"
        System.out.println(result);
    }
}
