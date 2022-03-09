
package fogli.alessandro.oggetti2;

public class Test
{
    public static void main(String[] args)
    {
        Persona persona = new Persona ("Mario", "Rossi", 27);

        persona.camminare();
        persona.mangiare();
        System.out.println(persona.getEta());

        persona.setCognome("Bianchi");
        System.out.println(persona.getCognome());
    }
}
