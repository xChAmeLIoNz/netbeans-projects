package negozio;

public class TestNegozio {
    public static void main(String[] args) {
        
        Negozio negozio = new Negozio();
        
        for(int i = 1; i <= 10; i++) {
            Thread cliente = new Cliente(i, negozio);
            cliente.start();
        }
    }
}
