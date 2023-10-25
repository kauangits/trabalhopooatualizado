
import java.util.Scanner;

public class Investimentos {
    private int prazoDeDias;
    private double taxaDeRetornoDiaria;
    


    public Investimentos() {
        this.prazoDeDias = 30;
        this.taxaDeRetornoDiaria = 1.0;

    }



    public int getPrazoDeDias() {
        return prazoDeDias;
    }

    public void setPrazoDeDias(int prazoDeDias) {
        this.prazoDeDias = prazoDeDias;
    }

    public double getTaxaDeRetornoDiaria() {
        return taxaDeRetornoDiaria;
    }

    public void setTaxaDeRetornoDiaria(double taxaDeRetornoDiaria) {
        this.taxaDeRetornoDiaria = taxaDeRetornoDiaria;
    }
  
    double valorInvestido =0.0;   
     Scanner sc = new Scanner(System.in);
    public void calcularRetornoInvestido(ContaBancaria conta) {
       
        int aumento=0;
        if (conta.getSaldo() >= 0) {
            System.out.print("Digite o valor do investimento: ");
            double valorInvestimento = sc.nextDouble();
    
            if (valorInvestimento >= 0) {
          
                
       
                for (int dia = 0; dia < prazoDeDias; dia++) {
                    aumento =(int)(valorInvestimento * (taxaDeRetornoDiaria / 100.0));
    
                   
                   
                  
            
                }
               aumento=aumento*30;
              conta.setSaldo(conta.getSaldo()+aumento);
               System.out.println("aumento"+aumento);
                System.out.println("valor investido"+valorInvestimento);
             
              
                
                
                
                System.out.println("Saldo com o investimento: " + conta.getSaldo());
           
            } else {
                System.out.println("Não é possível investir um valor negativo.");
            }
        } else {
            System.out.println("Não pode investir se não tem saldo.");
        }
  
    }
 
}
