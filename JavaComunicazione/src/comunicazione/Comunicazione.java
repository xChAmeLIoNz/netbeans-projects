package comunicazione;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

public class Comunicazione {
    //metodo per leggere dati dal server
    public List<Persona> leggiDati() {
        List<Persona> lista = null;
        OutputStreamWriter writer = null;
        InputStreamReader reader = null;
        
        try {
            URL url = new URL("https://gdapplicazioni.altervista.org/CorsoItsServer/corso_its_invia_dati.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla 5.0 "
                    + "(Windows; U; Windows NT 5.1; en-US; rv:1.8.0.11)");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            //dire al server che siamo autorizzati
            writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write("codice=autorizzato");
            writer.flush();
            //recupero dal server
            reader = new InputStreamReader(connection.getInputStream());
            int dato;
            StringBuilder risposta = new StringBuilder();
            while((dato = reader.read()) != -1) {
                risposta.append((char) dato);
            }
            //verifichiamo il recupero dei dati
            if(risposta.length() > 0 && !risposta.toString().equals("operazione negata")) {
                lista = new ArrayList<>();
                //parsing JSON
                JSONArray array = new JSONArray(risposta.toString());
                for(int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    Persona p = new Persona();
                    p.setId(Integer.parseInt(obj.getString("id")));
                    p.setNome(obj.getString("nome"));
                    p.setCognome(obj.getString("cognome"));
                    p.setEta(Integer.parseInt(obj.getString("eta")));
                    lista.add(p);
                }
            }
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        }
        return lista;
    }
    
    //metodo per inviare dati al server
    public void inviaDati(Persona p) {
        OutputStreamWriter writer = null;
        InputStreamReader reader = null; 
        try {
            URL url = new URL("https://gdapplicazioni.altervista.org/CorsoItsServer/corso_its_ricevi_dati.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla 5.0 "
                    + "(Windows; U; Windows NT 5.1; en-US; rv:1.8.0.11)");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            writer = new OutputStreamWriter(connection.getOutputStream());
            //preparo il JSON
            JSONObject persona = new JSONObject();
            persona.put("nome", p.getNome());
            persona.put("cognome", p.getCognome());
            persona.put("eta", p.getEta());
            String personaDaInviare = persona.toString();
            writer.write("codice=autorizzato&persona=" + personaDaInviare);
            writer.flush();
            //ottenere esito operazione
            reader = new InputStreamReader(connection.getInputStream());
            int dato;
            String response = "";
            StringBuilder risposta = new StringBuilder();
            while((dato = reader.read()) != -1) {
                response += (char) dato;
            }
            System.out.println(response);
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        }
    }
}
