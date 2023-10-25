
import java.util.Scanner;

    public class App{
   

    private static void exibirMenu() {
        System.out.println("------------Menu do Banco ENRIKAR------------\n");
        System.out.println("Digite 1 para Cadastar-se\nDigite 2 para criar sua conta\nDigite 3 para entrar na sua conta\nDigite 4 para poder realizar operações\nDigite 5 encerrar sua conta\nDigite 6 sair da conta\ndigite 7 para info\ndigite 8 para ir ao suporte\nDigite 9 encerrar");
    }

    private static int solicitarOpcao(Scanner sc) {
     
        return sc.nextInt();
      
    }

 
    public static void main(String[] args)throws SaldoInsuficienteException, ValorInvalidoException,ContaNaoExisteException {
     
CadastroUsuario usuari = new CadastroUsuario();
Gerente g1 = new Gerente("234433", "carlos", "123", "12042004", "gerente", null);
GerenciarConta geren1 = new GerenciarConta(g1);
AutorizacaoSeguranca autorizaçao = new AutorizacaoSeguranca();
SuporteAoCliente suporte = new SuporteAoCliente();

ContaBancaria contaAtual = null;
 boolean estaLogado = false;
 boolean sairDoMenuPrincipal = false;
     
 while(!sairDoMenuPrincipal){
     exibirMenu();
      Scanner sc = new Scanner(System.in);
     int opcao=solicitarOpcao(sc);
            switch (opcao) {
                case 1:
              if(!estaLogado){
                usuari.Cadastro();
              }
                    break;
                case 2:
             
             System.out.println("digite nome do usuario para criar conta");
               String nomeUsuarioConta = sc.next();
             Usuario usuariopelonome =  usuari.escolherUsuario(nomeUsuarioConta);
             if(usuariopelonome!=null){
              System.out.println("digite o codigo da conta");
              int codigo = sc.nextInt();
              System.out.println("digite senha");
                int senha = obterSenhaNumericaComPeloMenos4Digitos(sc);
                System.out.println("digite o login");
                String login = sc.next();    
         
                 if (!geren1.naoRepetirCodigo(codigo)){
            
              ContaBancaria novaconta = new ContaBancaria(codigo, login, senha, usuariopelonome);
            
                if(geren1.getQuantidadeDeContas()==0){
              geren1.criarConta(novaconta);
              contaAtual=novaconta;
           System.out.println("cria a primeira conta");
             
            }else{
              if(geren1.loginDiferente(login)&&geren1.senhaDiferente(senha)&&geren1.codigoDiferente(codigo)){
              System.out.println("entrou");
                geren1.criarConta(novaconta);
             System.out.println("conta criada");
             contaAtual = novaconta; 
            }else{
                System.out.println("nao foi criado");
              }
            
             }
            
            
            }else{
                System.out.println("usuario nao encontrado");
            }
      
          }else{
            System.out.println("nao tem usuario");
          }
          
            break;
                  case 3:
                if(contaAtual!=null){
                  if(!estaLogado){
                  System.out.println("digite o codigo da conta");
             int c = sc.nextInt();     
             ContaBancaria conta = geren1.encontrarConta(c);
             autorizaçao.verificarSenha(conta);
             contaAtual = conta;
             System.out.println("voce entrou na conta");
               estaLogado = true;     
            }else{
                    System.out.println("ja esta logado em uma conta");
                  }

              
            }else{
                 System.out.println("nao existe nenhuma conta");
                }    
             break;
               case 4:
             if(contaAtual!=null){
                if(estaLogado){
             sairDoMenuPrincipal=geren1.realizarOperacoes(contaAtual,sc);  
                }else{
                System.out.println("nao esta logado");
                } 
        }else{
                System.out.println("nao existe nenhuma conta");
             }
             break;
              
        case 5: 
        if(contaAtual==null)
        System.out.println("encerrar conta");
        if(contaAtual!=null){
        geren1.Encerrar(contaAtual);
          }
   
        break;
        case 6:
        if(contaAtual==null){
       System.out.println("nao tem conta para sair");
        }
        if(estaLogado==true){
        System.out.println("sair da conta");
         
       estaLogado = false;
        }else{
          System.out.println("nenhuma conta esta logada");
        }       
        break;

       case 7:
         System.out.println(geren1.toString());
       break;
      
       case 8:
    
       if(estaLogado==true){
       suporte.mandarMensagem();
         
       }
       break;
     

       case 9:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
           
 
 
               
     sc.close();
  
                }
            
       
               
    }
      
}
public static int obterSenhaNumericaComPeloMenos4Digitos(Scanner sc) {
  int senha;
  do {
      System.out.print("Digite sua senha (pelo menos 4 dígitos): ");
      senha = sc.nextInt();
  } while (contaDigitos(senha) < 4);

  return senha;
}

public static int contaDigitos(int numero) {
  int contagem = 0;
  while (numero > 0) {
      numero /= 10; 
      contagem++;
  }
  return contagem;
}


}

