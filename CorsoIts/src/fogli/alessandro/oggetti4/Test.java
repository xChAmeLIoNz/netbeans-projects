
package fogli.alessandro.oggetti4;

public class Test
{
    public static void main(String[] args)
    {
        Persona persona = new Persona("Mario", "Rossi", 50);
        Studente studente = new Studente("Alessandro", "Fogli", 19, 123, 8.9);
        Lavoratore lavoratore = new Lavoratore("Gigi", "Farloz", 67, 1342, 1550.45);

        persona.camminare();
        studente.parlare();
        lavoratore.mangiare();
        studente.studiare();
        lavoratore.lavorare();

        persona.setCognome("Bianchi");
        System.out.println(persona.getCognome());

    }
}
