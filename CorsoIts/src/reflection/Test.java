package reflection;
import java.lang.reflect.*;

public class Test {

    public static void main(String[] args) {
        
        Persona p = new Persona("Mario", "Rossi", 50);
        
        Class c = p.getClass();
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        
        Field[] variabili = c.getFields();
        
        for(int i = 0; i < variabili.length; i++) {
            
            System.out.println(variabili[i].getName() + ": " + variabili[i].getType());
        }
        
        Constructor[] costruttori = c.getConstructors();
        for(int i = 0; i < costruttori.length; i++) {
            
            System.out.println(costruttori[i].getName() + ": " + costruttori[i].getParameterCount());
        }
        
        Method[] metodi = c.getMethods();
        for(int i = 0; i < metodi.length; i++) {
            
            System.out.println(metodi[i].getName() + ": " + metodi[i].getReturnType());
        }
        
        Method[] metodiDichiarati = c.getDeclaredMethods();
        for(int i = 0; i < metodiDichiarati.length; i++) {
            
            System.out.println(metodi[i].getName() + ": " + metodi[i].getReturnType());
        }
    }
}
