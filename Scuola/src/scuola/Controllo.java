package scuola;

public interface Controllo {
    String ESPRESSIONE_CONTROLLO_NOMINALE = "[a-zA-Z\\s'_-]{1,}"; 
    //caratteri ammessi in input (espressione nominale/regolare)
    //parentesi quadra = dalla a alla zeta (lower and upper); \\s significa spazio
    //parentesi graffa = delimito il numero minimo e massimo di caratteri da inserire
    
    String ESPRESSIONE_CONTROLLO_CODICE = "[0-9a-zA-Z_-]{1,}";
}
