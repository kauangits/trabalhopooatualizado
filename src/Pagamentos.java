
import java.util.Random;
import java.util.Scanner;

public class Pagamentos {
     private Random random;
     private double ultimoValorPago;
    private double valorAgua;
    private double valorEnergia;
 
    public double getValorEnergia() {
        return valorEnergia;
    }
    private double valorInternet;


    public double getValorInternet() {
        return valorInternet;
    }

    public double getValorAgua() {
        return valorAgua;
    }

    public void setValorAgua(double valorAgua) {
        this.valorAgua = valorAgua;
    }

    public Pagamentos() {
        random = new Random();
        ultimoValorPago = 0.0;
    }

    public double pagarAgua(ContaBancaria contaPagar) {
   
        double valor = 20 + random.nextDouble() * 80;
      
       
        if(contaPagar.getSaldo()>=valor){
          contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return valor;
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return 0;
        }

    }


    public double pagarEnergia( ContaBancaria contaPagar) {
        double valor = 50 + random.nextDouble() * 150;
    

        if(contaPagar.getSaldo()>=valor){
            contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return valor;
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return 0;
        }
    }

 
    public double pagarInternet(ContaBancaria contaPagar) {
        double valor = 30 + random.nextDouble() * 70;
     

        if(contaPagar.getSaldo()>=valor){
          contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return valor;
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return 0;
        }
    }

    public double getUltimoValorPago() {
        return ultimoValorPago;
    }
 Scanner sc = new Scanner(System.in);
    public boolean menuPagamentos(ContaBancaria conta){
        boolean sairDoMenuDePagamentos = false;
    
        while (!sairDoMenuDePagamentos) {
        System.out.println("------Faturas e Boletos para pagar-------");
        System.out.println("Faturas:");
        System.out.println("1. Conta de Agua");
        System.out.println("2. Conta de Energia");
        System.out.println("3. Conta de Internet");
        System.out.println("4. Para sair do menu de pagamentos");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:

                    pagarAgua(conta);
                     System.out.println("saldo"+conta.getSaldo());
                       valorAgua = pagarAgua(conta);
                     System.out.println("valor da conta de Agua"+valorAgua);
                     break;
            case 2:
               

                    
                pagarEnergia(conta);
               System.out.println("Saldo restante na conta: " + conta.getSaldo());
                  valorEnergia = pagarEnergia(conta);
                     System.out.println("valor da conta de energia"+valorEnergia);
               
               break;
            case 3:
                pagarInternet(conta);
                    System.out.println("Saldo restante na conta: " + conta.getSaldo());
                 valorInternet = pagarInternet(conta);
                     System.out.println("valor da conta de internet"+valorInternet);
                break;

            case 4:
            sairDoMenuDePagamentos = false; 
            return sairDoMenuDePagamentos;
            default:
            System.out.println("Opção inválida.");
            break;
          
            
            } 
            
    }
    sc.close();
    return sairDoMenuDePagamentos;
}

}