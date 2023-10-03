package modelos;
import service.GerenciadorScores;
import service.impl.GerenciadorScoresArquivo;

import java.util.Scanner;
import java.util.List;

public class FrontScores {
    //Cria uma instância do GerenciadorScores
    private final GerenciadorScores gerenciadorScores = new GerenciadorScoresArquivo();
    //Cria uma instância do Scanner
    private final Scanner scanner = new Scanner(System.in);

    //Método que interage com o usuário
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

    //Método que exibe o menu de opções
    private void menu() {
        System.out.println("\nOpções:");
        System.out.println("1. Adicionar Score");
        System.out.println("2. Listar Scores");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    //Método que permite ao usuário adicionar um novo score
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

    //Método que lista todos os scores já registrados
    private void listar() {
        List<Score> scores = gerenciadorScores.consultar();
        System.out.println("\nScores registrados:");
        for (Score score : scores) {
            System.out.println(score.getNome() + ": " + score.getPontuacao());
        }
    }

    //Método principal que inicia a interação com o usuário
    public static void main(String[] args) {
        FrontScores frontScores = new FrontScores();
        frontScores.dialogar();
    }
}