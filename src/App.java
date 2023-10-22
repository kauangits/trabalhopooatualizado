
import java.util.Scanner;

    public class App{
   

    private static void exibirMenu() {
        System.out.println("------------Menu do Banco ENRIKAR------------\n");
        System.out.println("Digite 1 para Cadastar-se\nDigite 2 para criar sua conta\nDigite 3 para entrar na sua conta\nDigite 4 para poder realizar operações\nDigite 5 sua conta para sair ou encerrar sua conta\n");
    }

    private static int solicitarOpcao(Scanner sc) {
     
        return sc.nextInt();
      
    }

 
    public static void main(String[] args)throws SaldoInsuficienteException, ValorInvalidoException,ContaNaoExisteException {
     
CadastroUsuario usuari = new CadastroUsuario();
Gerente g1 = new Gerente("234433", "carlos", "123", "12042004", "gerente", null);
GerenciarConta geren1 = new GerenciarConta(g1);
AutorizacaoSeguranca autorizaçao = new AutorizacaoSeguranca();
 ContaBancaria contaAtual = null;
 boolean estaLogado = false;
 boolean sairDoMenuPrincipal = false;
       while(!sairDoMenuPrincipal){
     exibirMenu();
      Scanner sc = new Scanner(System.in);
     int opcao=solicitarOpcao(sc);
            switch (opcao) {
                case 1:
               
                usuari.Cadastro();
                    break;
                case 2:
             
             System.out.println("digite nome do usuario para criar conta");
               String nomeUsuarioConta = sc.next();
             Usuario usuariopelonome =  usuari.escolherUsuario(nomeUsuarioConta);
             if(usuariopelonome!=null){
              System.out.println("digite o codigo da conta");
              int codigo = sc.nextInt();
              System.out.println("digite senha");
                int senha = sc.nextInt();
                System.out.println("digite o login");
                String login = sc.next();    
                ContaBancaria novaconta = new ContaBancaria(codigo, login, senha, usuariopelonome);
             if(geren1.getQuantidadeDeContas()<2){
              geren1.criarConta(novaconta);
              contaAtual=novaconta;
           System.out.println("cria a primeira conta");
             
            }else{
              if(geren1.loginDiferente(login)&&geren1.senhaDiferente(senha)&&geren1.codigoDiferente(codigo)){
                geren1.criarConta(novaconta);
             System.out.println("conta criada");
             contaAtual = novaconta; 
            }else{
                System.out.println("mesmo login");
              }
             }
           
           
            }else{
                System.out.println("usuario nao encontrado");
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
               /*   if(autorizaçao.caso){
               System.out.println("digite o codigo da conta");
               int cont = sc.nextInt();
               ContaBancaria contaBancaria = geren1.encontrarConta(cont);
               geren1.realizarOperacoes(contaBancaria);
               }else{
                System.out.println("voce nao entrou na conta");
               }
               break;*/
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
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
           
 
 
               
     sc.close();
  
                }
            
       
               
    }

    /*Scanner scanner = new Scanner(System.in);


    ,klkjhkjhjgg
        while (true) {
            try {
                System.out.println("Escolha a operação:");
                System.out.println("1. Depósito");
                System.out.println("2. Saque");
                System.out.println("3. Transação");
                System.out.println("4. Sair");

                int escolha = scanner.nextInt();

                if (escolha == 1) {
                    System.out.print("Digite o valor do depósito: ");
                    double valor = scanner.nextDouble();
                    depositar(valor);
                } else if (escolha == 2) {
                    System.out.print("Digite o valor do saque: ");
                    double valor = scanner.nextDouble();
                    sacar(valor);
                } else if (escolha == 3) {
                    System.out.print("Digite o valor da transação: ");
                    double valor = scanner.nextDouble();
                    Transacao(null, valor, null);
                } else if (escolha == 4) {
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (ValorInvalidoException | SaldoInsuficienteException | ContaNaoExisteException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();*/
}
}

