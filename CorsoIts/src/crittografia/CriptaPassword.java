package crittografia;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;


public class CriptaPassword {

    public static void main(String[] args) throws NoSuchAlgorithmException
  {
    //acquisizione password da criptare in input
    String passwordDaCriptare = JOptionPane.showInputDialog
        ("inserisci password\nmin 2 e max 8 caratteri");
    //controllo parametri password
    if (passwordDaCriptare.length() <= 8 && passwordDaCriptare.length() >= 2)
    {
      //criptatura password
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(passwordDaCriptare.getBytes(StandardCharsets.UTF_8));
      byte[] arrayCriptato = messageDigest.digest();
      String passwordCriptata = String.format("%064x", 
              new BigInteger(1, arrayCriptato));
      //output
      JOptionPane.showMessageDialog(null, "la password criptata è:\n" + 
              passwordCriptata);
      System.out.println(passwordCriptata);
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Password errata");
    }
  }
}
