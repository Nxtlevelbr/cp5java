package service;

import modelos.Score;

import java.util.List;

public interface gerenciadorScores {
    void adicionar(Score score);
    List<Score> consultar(String jogador);
}
