
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciarConta {

    private boolean deixa;
    private Investimentos investimentos=new Investimentos();
    private Gerente g1;
    private List<ContaBancaria> contas;
    private ContaBancaria conta;
    private  Pagamentos pagamentos = new Pagamentos(); 
    

    Scanner teclado = new Scanner(System.in);

    public GerenciarConta(Gerente g1) {
        contas = new ArrayList<>();
        this.g1 = g1;

    }

    public Gerente getG1() {
        return g1;
    }

    public void setG1(Gerente g1) {
        this.g1 = g1;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public boolean isDeixa() {
        return deixa;
    }

    public void setDeixa(boolean deixa) {
        this.deixa = deixa;
    }



    public void criarConta(ContaBancaria conta) {

        contas.add(conta);

    }

    public int getQuantidadeDeContas() {
        return contas.size();
    }

    public boolean loginDiferente(String login) {
        for (ContaBancaria c : contas) {
            if (c.getLogin().equals(login)) {
                System.out.println("login ja existe digite novamente");
                String l = teclado.nextLine();
                if (!c.getLogin().equals(l)) {
                    System.out.println("seu login e valido");
                    return true;
                }

            } else {
                System.out.println("seu login esta correto");
                return true;
            }

        }
        return false;
    }

    public boolean senhaDiferente(int senha) {
        for (ContaBancaria c : contas) {
            if (c.getSenha()==senha) {
                System.out.println("senha ja existe digite novamente");
                int s = teclado.nextInt();
                if (c.getSenha()!=s) {
                    System.out.println("sua senha e valido");
                    return true;
                }

            } else {
                System.out.println("sua senha esta correto");
                return true;
            }

        }
        return false;
    }
   
   public boolean codigoDiferente(int codigo) {
        for (ContaBancaria c : contas) {
            if (c.getCodigo()==codigo) {
                System.out.println("codigo ja existe digite novamente");
                int codi = teclado.nextInt();
                if (c.getCodigo()!=codi) {
                    System.out.println("seu codigo e valido");
                    return true;
                }

            } else {
                System.out.println("seu codigo esta correto");
                return true;
            }

        }
        return false;
    }
   
   
    public ContaBancaria encontrarConta(int codigo) {
        for (ContaBancaria c : contas) {
            if (c.getCodigo() == codigo) {
                return c;
            }

        }
        return null;

    }

    public void verSaldo() {
        System.out.println("Esse é o seu saldo: " + conta.getSaldo());
    }

    public void exibirInfo() {
    
    }

    public void Encerrar(ContaBancaria contaEncerrar) {
        if (contaEncerrar.getSaldo() == 0.0) {
            contas.remove(contaEncerrar);
            System.out.println("Conta encerrada com sucesso.");
        } else {
            System.out.println("Não é possível encerrar a conta. O saldo não é zero.");
        }
    }

  
  

public List<Transacoes> histransacoes = new ArrayList<>();

    public List<Transacoes> getHistransacoes() {
        return histransacoes;
    }

    public void Transacoes(double valor, ContaBancaria origem)
            throws ContaNaoExisteException, ValorInvalidoException, SaldoInsuficienteException {

        if (valor <= 0) {
            throw new ValorInvalidoException("Valor inválido para transação");
        }


       
        System.out.print("Digite o código da conta de destino: ");
        int codigoDestino = teclado.nextInt();
        ContaBancaria contaDestino = encontrarConta(codigoDestino);
        if (!contas.contains(contaDestino)) {
            throw new ContaNaoExisteException("Conta destinatária inexistente");
        }

        if (origem.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transação");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        System.out.println(contaDestino.getSaldo());

        histransacoes.add(new Transacoes(origem, contaDestino, valor));
        System.out.println("Transação ralizada com sucesso");

        
    }

    public void adicionarTransacao(Transacoes transacao) {
        histransacoes.add(transacao);
    }


    public void Extrato(ContaBancaria conta,double valorAgua,double valorEnergia,double valorInternet) {
     if(valorAgua==0.0){
        System.out.println("valor de agua nao foi pago");
     }else{
        System.out.println("valor da conta de agua paga"+valorAgua);
     }
       if(valorEnergia==0.0){
        System.out.println("valor de energia nao foi pago");
     }else{
        
          System.out.println("valor de enerigia"+valorEnergia);
     }
    
     if(valorInternet==0.0){
        System.out.println("valor de internet nao foi pago");
     }else{ 
          System.out.println("valor de internet"+valorInternet);
     }
  System.out.println("saldo atual"+conta.getSaldo()); 
        
    }
    public boolean realizarOperacoes(ContaBancaria contaOperacao,Scanner sc)throws SaldoInsuficienteException, ValorInvalidoException,ContaNaoExisteException {
        boolean sairDoMenuDeOperacoes = false;
       Scanner scanner = new Scanner(System.in);
        while (!sairDoMenuDeOperacoes) {
          
            System.out.println("Escolha a operação:");
                System.out.println("1. Depósito");
                System.out.println("2. Saque");
                System.out.println("3. Transação");
                System.out.println("4. Ver informações");
                System.out.println("5. pagamentos"); 
                System.out.println("6 ver extrato"); 
                System.out.println("7.investimentos"); 
                System.out.println("8. sair"); 
                            
            int opcaoOperacoes = solicitarOpcao(sc);
   try{
            switch (opcaoOperacoes) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    contaOperacao.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    contaOperacao.sacar(valorSaque);
                    System.out.println("Saque realizado com sucesso.");
                    break;
             case 3:
             System.out.print("Digite o valor da transação: ");
             double valorTransacao = scanner.nextDouble();
             Transacoes(valorTransacao, contaOperacao);           
  
              break;
                case 4:
               System.out.println("nome"+contaOperacao.getUsuario().getNome());
               System.out.println("cpf"+contaOperacao.getUsuario().getCpf());
               System.out.println("endereco"+contaOperacao.getUsuario().getEndereco());
               System.out.println("login"+contaOperacao.getLogin());
               System.out.println("saldo"+contaOperacao.getSaldo());
               

                break;
                case 5: 
                 
                sairDoMenuDeOperacoes = pagamentos.menuPagamentos(contaOperacao);

                break;
                case 6:   
                
                
                Extrato(contaOperacao,pagamentos.getValorAgua(),pagamentos.getValorEnergia(),pagamentos.getValorInternet());

                break;
                case 7:
                  System.out.println("valor do investimento");
                investimentos.calcularRetornoInvestido(contaOperacao);

                
                break;
                case 8:
                    sairDoMenuDeOperacoes = false; 
                  return sairDoMenuDeOperacoes;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } catch (ValorInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (ContaNaoExisteException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número válido.");
     
        }
 
    }
    scanner.close();
    return sairDoMenuDeOperacoes;
    
    }

    private static int solicitarOpcao(Scanner sc) {
     
        return sc.nextInt();
      
    }

    public boolean naoRepetirCodigo(int codigo){
        for(ContaBancaria conta:contas){
            if(conta.getCodigo()==codigo){
                return true;
            }
        
        }
        return false;
    }
   
    @Override
    public String toString() {
        return "GerenciarConta [contas=" + contas + "]";
    }

 
    
}
