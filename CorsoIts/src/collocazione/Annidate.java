package collocazione;


public class Annidate {

    //attributi
    private String stringa1;
    private static String stringa2;
    
    //inner regolare
    class InnerRegolare{
        
        void metodo(){
            
            System.out.println(stringa1);
            System.out.println(stringa2);
        }
        
        //static void metodo2(){} //NO MEMBRI STATICI
        
    }
    
    //inner statica
    static class InnerStatica{
        
        void metodo(){
            
            System.out.println(stringa2);
          //System.out.println(stringa1); //no accesso diretto a membri d'istanza
        }
        
        static void metodo2(){
            
            System.out.println(stringa2);
            System.out.println(new Annidate().stringa1);
        }
    }
    
    //metodo della classe ospite con inner class
    void metodoConClasse(){
        
        String stringaLocale = "ciao";
        
        class InnerLocale{
            
            void metodo(){
                
                System.out.println(stringa1);
                System.out.println(stringa2);
                System.out.println(stringaLocale);
                
            }
        }
        //questa classe può essere costruita/chiamata solo all'interno del
        //metodo dove essa è annidata
        new InnerLocale();
        
    }
    
    Persona p = new Persona(){
       
        @Override
        public void mangiare() {
            
            System.out.println("Io sto mangiando dentro la classe " + stringa1 + stringa2);
        }
        
        
    };
    
    //metodo d'istanza di classe Annidate per istanziare inner
    void metodoPerIstanziare(){
        
        new InnerRegolare();
        new InnerStatica();
      //new InnerLocale(); //solo dentro il metodo
        p.mangiare();
    }
    
    public static void main(String[] args) {
        
        //new InnerRegolare();
        new Annidate().new InnerRegolare();
        new InnerStatica();
      //new InnerLocale(); //solo dentro il metodo
      //p.mangiare();
        new Annidate().p.mangiare();
    }
}

//classe persona
class Persona{
    
    public void mangiare(){
        
        System.out.println("Io sto mangiando");
    }
}
