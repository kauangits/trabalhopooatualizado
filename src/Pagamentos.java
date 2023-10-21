
import java.util.Random;

public class Pagamentos {
     private Random random;

    public Pagamentos() {
        random = new Random();
    }

    public double pagarAgua(ContaBancaria contaPagar) {
   
        double valor = 20 + random.nextDouble() * 80;
       
        if(contaPagar.getSaldo()>=valor){
          contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return contaPagar.getSaldo();
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return contaPagar.getSaldo();
        }

    }


   

    public double pagarEnergia() {
        // Gere um valor aleatório para o pagamento de energia (por exemplo, entre 50 e 200)
        double valor = 50 + random.nextDouble() * 150;
        return valor;
    }

 
    public double pagarInternet() {
        // Gere um valor aleatório para o pagamento de internet (por exemplo, entre 30 e 100)
        double valor = 30 + random.nextDouble() * 70;
        return valor;
    }
}

