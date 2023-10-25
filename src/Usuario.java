
public class Usuario extends Pessoa {
    
    public Usuario(String cpf, String nome, String endereco, String dataNascimento) {
        super(cpf, nome, endereco, dataNascimento);
    }

 
    

    @Override
    public String toString() {
        return "Usuario [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", dataNascimento="
                + dataNascimento + "]";
    }
   
    
}
