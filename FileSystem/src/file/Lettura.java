package file;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lettura {

    public static void main(String[] args) {
        //leggiPerRiga();
        leggiCsv();
    }
    
    static void leggiPerRiga() {
        try(BufferedReader reader = new BufferedReader(new FileReader("altro_file.txt"))) {
            String testo = "";
            while((testo = reader.readLine()) != null) {
                System.out.println(testo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    static void leggiPerCarattere() {
        try(BufferedReader reader = new BufferedReader(new FileReader("altro_file.txt"))) {
            String testo = "";
            int dato;
            while((dato = reader.read()) != -1) {
                testo += (char) dato;
            }
            System.out.println(testo);
        } catch (Exception e) {
            
        }
    }
    
    static void leggiCsv() {
        try(BufferedReader reader = new BufferedReader(new FileReader("file_tabella.csv"))) {
            String testo = "";
            int dato;
            while((dato = reader.read()) != -1) {
                testo += (char) dato;
            }
            List<List<String>> datiRecuperati = new ArrayList<>();
            String[] righe = testo.split("\n");
            for(int i = 0; i < righe.length; i++) {
                List<String> lista = Arrays.asList(righe[i]);
                datiRecuperati.add(lista);
            }
            System.out.println(datiRecuperati);
        } catch (Exception e) {
            
        }
    }
    
}
