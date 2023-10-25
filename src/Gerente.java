
public class Gerente extends Pessoa{
    private String cargo;
    private GerenciarConta gerencia;
  
    public Gerente(String cpf, String nome, String endereco, String dataNascimento, String cargo,
            GerenciarConta gerencia) {
        super(cpf, nome, endereco, dataNascimento);
        this.cargo = cargo;
        this.gerencia = gerencia;
        
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public GerenciarConta getGerencia() {
        return gerencia;
    }
    public void setGerencia(GerenciarConta gerencia) {
        this.gerencia = gerencia;
    }

}
