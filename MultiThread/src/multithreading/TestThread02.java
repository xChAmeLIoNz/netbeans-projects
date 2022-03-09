package multithreading;

public class TestThread02 {
    public static void main(String[] args) {
        ThreadMario tm = new ThreadMario("Mario");
        ThreadGianni tg = new ThreadGianni("Gianni");
        tm.start();
        tg.start();
    }
}

//classe thread 1
class ThreadMario extends Thread {
    private String nome;

    public ThreadMario(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            System.out.println("Thread " + nome + "stampa numero " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
}

//classe thread 2
class ThreadGianni extends Thread {
    private String nome;

    public ThreadGianni(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for(int i = 6; i <= 10; i++) {
            System.out.println("Thread " + nome + "stampa numero " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}