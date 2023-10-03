package service;

import modelos.Score;

import java.util.List;

public interface GerenciadorScores {

    //Método de adicionar scores que será sobrescrito
    void adicionar(Score score);

    //Método de consultar scores que será sobrescrito
    List<Score> consultar();
}