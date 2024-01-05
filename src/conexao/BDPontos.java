package conexao;

public class BDPontos {
    private String jogador;
    private long pontuacao;

    public BDPontos(String jogador, long pontuacao) {
        this.jogador = jogador;
        this.pontuacao = pontuacao;
    }
    
    public BDPontos() {
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "BDPontos{" + ", jogador=" + jogador + ", pontuacao=" + pontuacao + '}';
    }
}
