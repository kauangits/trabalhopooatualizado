public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String endereco;
    protected String dataNascimento;
    public Pessoa(String cpf, String nome, String endereco, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
  


}
