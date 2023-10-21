
import java.time.LocalDate;

public class Investimentos {

    private String tipoInvestimento;
    private double valorInvestido;
    private double taxaJurosAnual;
    private LocalDate dataInicio;

    public Investimentos(String tipoInvestimento, double valorInvestido, double taxaJurosAnual) {
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.taxaJurosAnual = taxaJurosAnual;
    }

   
    public double calcularValorFuturo(int anos) {
        double valorFuturo = valorInvestido;
        for (int i = 0; i < anos; i++) {
            valorFuturo += valorFuturo * (taxaJurosAnual / 100);
        }
        return valorFuturo;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }


}
