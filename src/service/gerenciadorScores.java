package service;

import modelos.Score;

public interface gerenciadorScores {
    void adicionar(Score score);
    void consultar(String jogador);
}
