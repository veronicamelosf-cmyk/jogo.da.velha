/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodavelha;

/**
 *
 * @author veronica62924506
 */
import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro(
                "1 - Cada jogador deve escolher um simbolo; "
                + "2 - O jogador 1 inicia a partida"
        );

        Jogador jogador1 = new Jogador(1, "Verônica", 'X');
        Jogador jogador2 = new Jogador(2, "Jonathan", 'O');

        System.out.println("=== JOGO DA VELHA ===");
        System.out.println(tabuleiro.getRegras());

        boolean fimDeJogo = false;

        while (!fimDeJogo) {

            tabuleiro.mostrarTabuleiro();

            if (tabuleiro.getJogadorDaVez() == 1) {

                System.out.println("\n" + jogador1.getNome()
                        + " (X), escolha onde jogar:");

                String local = entrada.nextLine().toUpperCase();

                if (tabuleiro.marcarJogada(jogador1.getSimbolo(), local)) {

                    if (tabuleiro.verificarGanhador(jogador1.getSimbolo())) {
                        tabuleiro.mostrarTabuleiro();
                        System.out.println("\n" + jogador1.getNome()
                                + " venceu!");
                        fimDeJogo = true;

                    } else if (tabuleiro.tabuleiroCheio()) {
                        tabuleiro.mostrarTabuleiro();
                        System.out.println("\nEmpate!");
                        fimDeJogo = true;

                    } else {
                        tabuleiro.setJogadorDaVez(2);
                    }
                }

            } else {

                System.out.println("\n" + jogador2.getNome()
                        + " (O), escolha onde jogar:");

                String local = entrada.nextLine().toUpperCase();

                if (tabuleiro.marcarJogada(jogador2.getSimbolo(), local)) {

                    if (tabuleiro.verificarGanhador(jogador2.getSimbolo())) {
                        tabuleiro.mostrarTabuleiro();
                        System.out.println("\n" + jogador2.getNome()
                                + " venceu!");
                        fimDeJogo = true;

                    } else if (tabuleiro.tabuleiroCheio()) {
                        tabuleiro.mostrarTabuleiro();
                        System.out.println("\nEmpate!");
                        fimDeJogo = true;

                    } else {
                        tabuleiro.setJogadorDaVez(1);
                    }
                }
            }
        }

        entrada.close();
    }
}
