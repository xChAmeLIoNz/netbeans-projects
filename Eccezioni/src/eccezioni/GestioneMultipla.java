package eccezioni;

public class GestioneMultipla {
    public static void main(String[] args) {
        metodoDivisione("4", "ciao");
    }
    
    static void metodoDivisione(String a, String b) {
        try {
            System.out.println(Integer.parseInt(a) / Integer.parseInt(b));
        } catch (ArithmeticException e) {
            System.out.println("Divisione impossibile");
        } catch (NumberFormatException e) {
            System.out.println("Parsing impossibile");
        } catch (Exception e) {
            
        }catch (Throwable t) {
            
        } /*catch (ArithmeticException | NumberFormatException e) {
        
            così gestisco più eccezioni, ma una non può essere ereditata
            dall'altra
           }*/
        
        /*Le eccezioni vanno gestite in modo "gerarchico"
          quindi: eccezioni precise, eccezioni generiche, 
          throwable(eccezioni ed errori)
          */
    }
    
}
