package modelos;
import service.impl.gerenciadorScoresArquivo;

import java.util.Scanner;

public class frontScores {
    private final service.gerenciadorScores gerenciadorScores;

    public frontScores(service.gerenciadorScores gerenciadorScores) {
        this.gerenciadorScores = gerenciadorScores;

    }
    public void dialogar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarScore(scanner);
                    break;
                case 2:
                    consultarScore(scanner);
                case 3:
                    System.out.println("saindo...");
                    return;
                default:
                    System.out.println("opcao invalida. Tente Novamente.");
            }
        }
    }
    private void exibirMenu() {
        System.out.println("Menu Princicpal");
        System.out.println("(1) Adicionar Score");
        System.out.println("(2) Consultar Score");
        System.out.println("(3) Sair");
        System.out.print("Escolha uma opcao: ");
    }
    private void adicionarScore(Scanner scanner) {
        System.out.print("Jogador: ");
        String jogador = scanner.nextLine();

        System.out.print("Pontos: ");
        int pontos = scanner.nextInt();
        scanner.nextLine();

        Score score = new Score(jogador, pontos);
        gerenciadorScores.adicionar(score);
        System.out.println("score adicionado com sucesso! ");
    }
    private void consultarScore(Scanner scanner) {
        System.out.print("Jogador para consultar: ");
        String jogador = scanner.nextLine();
        gerenciadorScores.consultar(jogador);

    }
    public static void main(String[] args) {
        service.gerenciadorScores gerenciadorScores = new gerenciadorScoresArquivo();
        frontScores frontScores = new frontScores(gerenciadorScores);
        frontScores.dialogar();
    }
}
