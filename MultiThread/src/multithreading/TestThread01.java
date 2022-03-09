package multithreading;

public class TestThread01 {

    public static void main(String[] args) throws Exception{
        //saluto dal thread principale
        System.out.println("Ciao, sono Thread " + Thread.currentThread().getName());
        //creazione dei thread secondari
        MioThread1 mt1 = new MioThread1("Thread 1");
        Thread mt2 = new Thread(new MioThread2("Thread 2")); //thread stato NEW
        //impostare eseguibilità dei thread
        mt1.start();
        mt2.start(); //thread in stato RUNNABLE
        
        //Thread.sleep(2000);
        mt1.join();
        mt2.join();
        
        System.out.println("Arrivederci da Thread " + Thread.currentThread().getName());
    }
}  
    //classe 1° thread
    class MioThread1 extends Thread {
        private String nome;

        public MioThread1(String nome) {
            this.nome = nome;
        }

        @Override
        public void run() {
            System.out.println("Ciao, sono " + nome);
        }
        
        
        
    }
    
    //classe 2° thread, metodo più usato perchè permette di estendere una superclasse
    class MioThread2 implements Runnable {
        private String nome;

        public MioThread2(String nome) {
            this.nome = nome;
        }
        
        @Override
        public void run() {
            System.out.println("Ciao, sono " + nome);
        }
        
    }

