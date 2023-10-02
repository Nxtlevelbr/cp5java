package impl;
import modelos.Score;
import service.gerenciadorScores;

import java.io.*;


public class gerenciadorScoreArquivoImpl implements gerenciadorScores {
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
            boolean jogadorEncontrado = false;
            int totalPontos = 0;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2 && partes[0].equals(jogador)) {
                    System.out.println("Score encontrado: " + linha);
                    int pontos = Integer.parseInt(partes[1]);
                    totalPontos += pontos;
                    jogadorEncontrado = true;
                }
            }

            if (jogadorEncontrado) {
                System.out.println("Total de pontos para o jogador " + jogador + ": " + totalPontos);
            } else {
                System.out.println("Score não encontrado para o jogador: " + jogador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
