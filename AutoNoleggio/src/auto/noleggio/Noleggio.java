package auto.noleggio;

import java.time.LocalDate;

public class Noleggio {
    //attributi
    private LocalDate dataInizioNoleggio;
    private Automobile automobile;
    private Cliente cliente;
    private LocalDate dataFineNoleggio;
    
    //costruttore

    public Noleggio(LocalDate dataInizioNoleggio, Automobile automobile, Cliente cliente, LocalDate dataFineNoleggio) {
        this.dataInizioNoleggio = dataInizioNoleggio;
        this.automobile = automobile;
        this.cliente = cliente;
        this.dataFineNoleggio = dataFineNoleggio;
    }
    
    //getter

    public LocalDate getDataInizioNoleggio() {
        return dataInizioNoleggio;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataFineNoleggio() {
        return dataFineNoleggio;
    }
    
    //setter

    public void setDataInizioNoleggio(LocalDate dataInizioNoleggio) {
        this.dataInizioNoleggio = dataInizioNoleggio;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataFineNoleggio(LocalDate dataFineNoleggio) {
        this.dataFineNoleggio = dataFineNoleggio;
    }
    
    
    
}
