package modelos;

public class Score {
    //Atributos
    private final String nome;
    private final int pontuacao;

    //Construtor
    public Score(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    //Métodos Get
    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}