
    /*import java.util.ArrayList;
import java.util.List;

public class SuporteAoCliente {
    private List<SolicitacaoDeSuporte> solicitacoes;

    public SuporteAoCliente() {
        solicitacoes = new ArrayList<>();
    }

    public void criarSolicitacao(String descricaoProblema, String conta) {
        SolicitacaoDeSuporte solicitacao = new SolicitacaoDeSuporte(descricaoProblema, conta);
        solicitacoes.add(solicitacao);
    }

    public void atribuirAgente(int numeroTicket, String agente) {
        for (SolicitacaoDeSuporte solicitacao : solicitacoes) {
            if (solicitacao.getNumeroTicket() == numeroTicket) {
                solicitacao.setAgenteResponsavel(agente);
                return;
            }
        }
        System.out.println("Solicitação não encontrada.");
    }

    public void responderSolicitacao(int numeroTicket, String resposta) {
        for (SolicitacaoDeSuporte solicitacao : solicitacoes) {
            if (solicitacao.getNumeroTicket() == numeroTicket) {
                solicitacao.adicionarResposta(resposta);
                return;
            }
        }
        System.out.println("Solicitação não encontrada.");
    }

    public void listarSolicitacoes() {
        for (SolicitacaoDeSuporte solicitacao : solicitacoes) {
            System.out.println(solicitacao);
        }
    }

*/

