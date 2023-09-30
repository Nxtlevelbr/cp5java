package service.ddd.implement;
import modelos.ddd.Score;
import service.ddd.GerenciadorScores;

import java.io.*;

public class GerenciadorScoreArquivo implements GerenciadorScores {
    private static final String ARQUIVO_SCORES = "scores.txt";


    @Override
    public void adicionar(Score score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_SCORES, true))) {
            writer.println(score.getJogador() + "," + score.getPontos());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consultar(String jogador) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_SCORES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2 && partes[0].equals(jogador)) {
                    System.out.println("Score  encontrado: " + linha);
                    return;
                }
            }
            System.out.println("Score não encontrado para o jogador: " + jogador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
