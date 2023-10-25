
import java.util.Scanner;

class AutorizacaoSeguranca {

   
   Scanner sc = new Scanner(System.in);


    public boolean verificarLogin(ContaBancaria conta,String login){
      while(conta.getLogin().equals(login)){
    System.out.println(" login errado digite novamente");
      String l = sc.nextLine();
      if(l==conta.getLogin()){
       System.out.println("senha correta");
        return true;
      }
     
    }
   return false;
  }
 
  public boolean verificarSenha(ContaBancaria conta) {
    int tentativas = 3;
    

    while (tentativas > 0) {
        System.out.println("Digite sua senha: ");
        int s = sc.nextInt();
       
        if (s == conta.getSenha()) {
            System.out.println("Senha correta, Bem vindo");
          
            return true;
        
        } else {
            System.out.println("Senha errada, tentativas restantes: " + (tentativas - 1));
            tentativas--;
        }
    
    }
   sc.close();
    System.out.println("Limite de tentativas excedido. A conta está bloqueada.");
    return false;

}
  



 


}
