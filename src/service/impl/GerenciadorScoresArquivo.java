package service.impl;
import modelos.Score;
import service.GerenciadorScores;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorScoresArquivo implements GerenciadorScores {

    //Lista que armazena scores
    private final List<Score> scores = new ArrayList<>();

    //Nome do arquivo onde serão armazenados os scores
    private final String arquivo = "scores.txt";

    //Construtor que lê os scores armazenados no arquivo "scores.txt"
    public GerenciadorScoresArquivo() {
        ler();
    }

    //Adiciona um score à lista no arquivo
    @Override
    public void adicionar(Score score) {
        scores.add(score);
        gravar();
    }

    //Retorna lista de scores
    @Override
    public List<Score> consultar() {
        return scores;
    }

    //Método que grava os scores no arquivo "scores.txt"
    private void gravar() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Score score : scores) {
                writer.println(score.getNome() + "," + score.getPontuacao());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Método que le os scores do arquivo "scores.txt"
    private void ler() {
        scores.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nome = parts[0];
                    int pontuacao = Integer.parseInt(parts[1]);
                    scores.add(new Score(nome, pontuacao));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}