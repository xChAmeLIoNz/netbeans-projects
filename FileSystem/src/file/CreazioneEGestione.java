package file;
import java.io.*;

public class CreazioneEGestione {
    public static void main(String[] args) throws IOException {
        File directory = new File("cartella");
        directory.mkdir(); //crea directory
        
        File file1 = new File(directory, "file1.txt");
        file1.createNewFile(); //crea un file dentro la directory creata
        
        File treeDir = new File("cartella2/sottocartella");
        treeDir.mkdirs();
        
        File file2 = new File("cartella2/sottocartella/file2.txt");
        file2.createNewFile();
        
        System.out.println(file2.exists());
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        
        file1.renameTo(new File("cartella/file1_mod.txt"));
    }
}
