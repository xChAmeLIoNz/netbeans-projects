package rubrica2;

public class MainClass {
    public static void main(String[] args) {
        Database db = new Database();
        db.creaTabellaContatti(db.creaConnessione());
        db.leggiTabella(db.creaConnessione());
        new FrameRubrica();
    }
}
