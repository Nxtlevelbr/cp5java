package modelos.ddd;

public class Score {
    private final String jogador;
    private final int pontos;

    public Score(String jogador, int pontos) {
        this.jogador = jogador;
        this.pontos = pontos;
    }

    public String getJogador() {
        return jogador;
    }

    public int getPontos() {
        return pontos;
    }

    @Override
    public String toString  (){
        return "Jogador: " + jogador +  ", Pontos: " + pontos;
    }
}
