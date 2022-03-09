package singleton;

public class Cifratura {

    //attributi
    private static Cifratura instance;
    private char[] cifrario;
    
    //costruttore
    private Cifratura(){
        
        
        cifrario = new char[]{'*', '+', '_', '-', '?'};
        Test.contatoreIstanzeCifratura++;
    }
    
    static Cifratura getInstance(){
        
        if(instance == null){
            
            instance = new Cifratura();
        }
        return instance;
    }
    
    //metodo di cifratura
    public String cifra(String testo){
        
        String cifrata = "";
        for(int i = 0; i < testo.length(); i++){
            
            switch (testo.charAt(i)){
                
                case 'a':
                    cifrata += cifrario[0];
                    break;
                case 'e':
                    cifrata += cifrario[1];
                    break;
                case 'i':
                    cifrata += cifrario[2];
                    break;
                case 'o':
                    cifrata += cifrario[3];
                    break;
                case 'u':
                    cifrata += cifrario[4];
                    break;
                default:
                    cifrata += testo.charAt(i);
                    break;
                    
            }
        }
        return cifrata;
    }
}
