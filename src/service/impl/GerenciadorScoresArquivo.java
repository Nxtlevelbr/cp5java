package service.impl;
import modelos.Score;
import service.GerenciadorScores;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorScoresArquivo implements GerenciadorScores {
    private final List<Score> scores = new ArrayList<>();
    private final String arquivo = "scores.txt";

    public GerenciadorScoresArquivo() {
        carregar();
    }

    @Override
    public void adicionar(Score score) {
        scores.add(score);
        gravar();
    }

    @Override
    public List<Score> consultar() {
        return scores;
    }

    private void gravar() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Score score : scores) {
                writer.println(score.getNome() + "," + score.getPontuacao());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregar() {
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

