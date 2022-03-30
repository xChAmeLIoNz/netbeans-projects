package progettocompleto;

public class MainClass {
    public static void main(String[] args) {
        Persona.getPersone().add(new Persona("Mario", "Rossi", 47));
        Persona.getPersone().add(new Persona("Giovanni", "Bianchi", 28));
        Persona.getPersone().add(new Persona("Gesù", "Cristo", 33));
    }
}
