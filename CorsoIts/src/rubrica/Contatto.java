package rubrica;


public class Contatto {

    //variabili d'istanza
    private String nome;
    private String mail;
    
    
    //costruttore

    public Contatto(String nome, String mail) {
        this.nome = nome;
        this.mail = mail;
    }
    
    public void inviaMail(){
        
        System.out.println("invio una mail a: " + mail);
    }
    
    public static void  mostraRubrica(Contatto[] contatti){
        
        for(int i = 0; i < contatti.length; i++){
            
            System.out.println("Contatto: " + contatti[i].nome + "-" + contatti[i].mail);
        }
    }
    
}
