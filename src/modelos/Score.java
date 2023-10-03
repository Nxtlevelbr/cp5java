package modelos;

public class Score {
    private final String nome;
    private final int pontuacao;

    public Score(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}