package interfaccia;

import java.util.Arrays;

public class Magazzino {

    public static void main(String[] args) {
        
        //istanza dei 4 oggetti
        Smartphone smartphone = new Smartphone(12, 2);
        Cordless cordless = new Cordless(36, 10);
        Desktop desktop = new Desktop("Windows 10", true);
        Laptop laptop = new Laptop("Linux Ubuntu", false);
        
        //prova di accesso a metodi delle superclassi
        smartphone.chiama(555111111);
        cordless.connettiALinea();
        desktop.installaProgramma("Java");
        laptop.sospendi();
        
        //prova di accesso a elementi di interfaccia
        smartphone.livelloBatteria();
        desktop.inizializzazione();
        System.out.println(laptop.MARCA);
        
        //verifica
        System.out.println(cordless instanceof Utilita);
        
        Utilita[] prodotti = {smartphone,cordless,desktop,laptop};
        System.out.println(Arrays.toString(prodotti));
    }
}
