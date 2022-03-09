package statomaggiore;


public class Test {

    public static void main(String[] args) {
        
        Militare m1 = new Militare("Salvo", "Beretta", 123);
        Militare b1 = new Bersagliere("Mario", "Bianchi", 666, 14.5);
        Militare mar1 = new Marinaio("Carosella", "Mattia", "Perro", 456);
        Militare a1 = new Aviatore("Lazer-P01", "Andrea", "Lollo", 999);
        
        Militare[] arrayMilitare = new Militare[4];
        arrayMilitare[0] = m1;
        arrayMilitare[1] = b1;
        arrayMilitare[2] = mar1;
        arrayMilitare[3] = a1;
        
        int contatore = 0;
        
        while(contatore < arrayMilitare.length){
            
            arrayMilitare[contatore].azioneSoldato();
            contatore++;
        }
        
        for(int i = 0; i < arrayMilitare.length; i++){
            
            System.out.println(arrayMilitare[i].toString());
            
            System.out.println(m1.toString());
        }
    }
}
