package service.ddd;

import modelos.ddd.Score;

public interface GerenciadorScores {
    void adicionar(Score score);
    void consultar(String jogador);
}
