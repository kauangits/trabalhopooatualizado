
import java.util.List;

public abstract class Transacoes extends ContaBancaria{
   
    private  String data;
    private String descricao;
    private List <ContaBancaria> conta;

    public Transacoes(int codigo, String login, int senha, double saldo, Usuario usuario, String data,
            String descricao, List<ContaBancaria> conta) {
        super(codigo, login, senha,usuario);
        this.data = data;
        this.descricao = descricao;
        this.conta = conta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ContaBancaria> getConta() {
        return conta;
    }

    public void setConta(List<ContaBancaria> conta) {
        this.conta = conta;
    }


    private List <Transacoes> histransacoes;

    public void Pix( ContaBancaria destinatario, double valor, Transacoes transacoes){
        if( valor <=0){
            System.out.println("Valor insufiente para transações");
        }

        if( getSaldo() >= valor){
            if( conta.contains(destinatario)){
                setSaldo(getSaldo() - valor);
                destinatario.setSaldo(destinatario.getSaldo()+valor);
                System.out.println("Transação ralizada com sucesso");
            }
            else{
                System.out.println("Essa conta não existe");
            }
        }else{
            System.out.println("Saldo insufiecente para realizar transação");
        }

        histransacoes.add(transacoes);
       
    }

    @Override
    public String toString() {
        return "Transacoes [data=" + data + ", descricao=" + descricao + "]";
    }

}

