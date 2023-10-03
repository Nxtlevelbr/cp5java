package modelos;
import service.GerenciadorScores;
import service.impl.GerenciadorScoresArquivo;

import java.util.Scanner;
import java.util.List;

public class FrontScores {
    private final GerenciadorScores gerenciadorScores = new GerenciadorScoresArquivo();
    private final Scanner scanner = new Scanner(System.in);

    public void dialogar() {
        System.out.println("Bem-vindo ao Gerenciador de Scores!");

        while (true) {
            menu();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void menu() {
        System.out.println("\nOpções:");
        System.out.println("1. Adicionar Score");
        System.out.println("2. Listar Scores");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void adicionar() {
        System.out.print("Digite o nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a pontuação: ");
        int pontuacao = scanner.nextInt();
        scanner.nextLine();

        Score score = new Score(nome, pontuacao);
        gerenciadorScores.adicionar(score);
        System.out.println("Score adicionado com sucesso!");
    }

    private void listar() {
        List<Score> scores = gerenciadorScores.consultar();
        System.out.println("\nScores registrados:");
        for (Score score : scores) {
            System.out.println(score.getNome() + ": " + score.getPontuacao());
        }
    }

    public static void main(String[] args) {
        FrontScores frontScores = new FrontScores();
        frontScores.dialogar();
    }
}