package crittografia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CraccaPassword {

    public static char[] CARATTERI = 
  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#&!()^=+/:.;,"
          .toCharArray();
  public static final int LUNGHEZZA_MASSIMA_PASSWORD = 8;
  public static final String PASSWORD_DA_DECODIFICARE = "b133a0c0e9bee3be20163d2ad31d6248db292aa6dcb1ee087a2aa50e0fc75ae2"; //valorizzare con SHA-256
  public static final byte[] ARRAY_DA_DECODIFICARE = 
          CraccaPassword.daStringaAByteArray(PASSWORD_DA_DECODIFICARE);
  public static long inizioDecriptazione;
  
  //trasforma la stringa password in un array di byte adatto per decriptare
  public static byte[] daStringaAByteArray(String stringa)
  {
    byte[] array = new byte[stringa.length() / 2];
    for (int i = 0; i < stringa.length(); i += 2)
    {
      int n = Integer.parseInt(stringa.substring(i, i+2), 16);
      array[i/2] = (byte)n;
    }
    return array;
  }
  
  //metodo di esecuzione per acquisizione processori disponibili e ripartizione
  public static void main(String[] args) throws NoSuchAlgorithmException
  {
    int processori = Runtime.getRuntime().availableProcessors();
    int porzioni = LUNGHEZZA_MASSIMA_PASSWORD / processori;
    int lunghezzaMassima = 0;
    inizioDecriptazione = System.currentTimeMillis();
    ExecutorService executorService = Executors.newFixedThreadPool(processori);
    while (lunghezzaMassima < LUNGHEZZA_MASSIMA_PASSWORD)
    {
      int lunghezzaMinima = lunghezzaMassima + 1;
      lunghezzaMassima = lunghezzaMinima + porzioni;
      
      if (lunghezzaMassima > LUNGHEZZA_MASSIMA_PASSWORD)
        lunghezzaMassima = LUNGHEZZA_MASSIMA_PASSWORD;
      
      executorService.submit(new PasswordCracker
        (lunghezzaMinima, lunghezzaMassima));
    }
    executorService.shutdown();
  }
}

/*
Questa classe Thread effettua la decriptazione parzionando il carico di lavoro
tra i vari processori disponibili
*/
class PasswordCracker implements Runnable
{
  private final MessageDigest MESSAGE_DIGEST 
          = MessageDigest.getInstance("SHA-256");
  private final int lunghezzaMinima;
  private final int lunghezzaMassima;
  private static boolean hoFinito = false;
  private String passwordInChiaro;
  
  //costruttore della classe
  public PasswordCracker(int lunghezzaMinima, int lunghezzaMassima) 
          throws NoSuchAlgorithmException
  {
    this.lunghezzaMinima = lunghezzaMinima;
    this.lunghezzaMassima = lunghezzaMassima;
  }
  
  //compone tutte le possibili combinazioni ed esegue il confronto
  public void decriptaPassword(StringBuilder builder, int istanza)
  {
    if (hoFinito)
      return;
    
    if (istanza == builder.length())
    {
      String daProvare = builder.toString();
      byte[] array = MESSAGE_DIGEST.digest(daProvare.getBytes());
      
      if (Arrays.equals(array, CraccaPassword.ARRAY_DA_DECODIFICARE))
      {
        passwordInChiaro = daProvare;
        hoFinito = true;
      }
      return;
    }
    
    for (int i = 0; i < CraccaPassword.CARATTERI.length && !hoFinito; i++)
    {
      char carattere = CraccaPassword.CARATTERI[i];
      builder.setCharAt(istanza, carattere);
      decriptaPassword(builder, (istanza+1));
    }
  }
  
  //metodo di avvio Thread
  @Override
  public void run()
  {
    for (int i = lunghezzaMinima; i <= lunghezzaMassima && !hoFinito; i++)
    {
      StringBuilder builder = new StringBuilder();
      builder.setLength(i);
      decriptaPassword(builder, 0);
    }
    // gestione dell'output
    if (hoFinito)
    {
      long durataProgramma = System.currentTimeMillis() - 
              CraccaPassword.inizioDecriptazione;
      System.out.println("La Password decriptata in " 
              + TimeUnit.MILLISECONDS.toMillis(durataProgramma) 
              + " millisecondi corrisponde a: " + passwordInChiaro);
    }
    else
    {
      System.out.println("decriptazione in corso...");
    }
  }
}
