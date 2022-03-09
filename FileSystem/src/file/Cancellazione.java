package file;

import java.io.File;

public class Cancellazione {
    
    public static void main(String[] args) {
        File file1 = new File("cartella/file1_mod.txt");
        File dir1 = new File("cartella");
        File dir2 = new File("cartella2");
        
        file1.delete();
        dir1.delete();
        dir2.delete();
        
        cancella(dir2);
    }
    
    static void cancella(File file) {
        File[] listaFile = file.listFiles();
        for(int i = 0; i < listaFile.length; i++) {
            if(listaFile[i].isFile()) {
                listaFile[i].delete();
            } else {
                cancella(listaFile[i]);
            }
        }
        file.delete();
    }
}
