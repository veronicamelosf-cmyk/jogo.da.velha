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
            "1 - Cada jogador possui um simbolo.\n"
            + "2 - O jogador 1 inicia a partida.\n"
            + "3 - Vence quem formar uma linha de tres simbolos."
        );

        Jogador jogador1 = new Jogador(1, "Verônica", 'X');
        Jogador jogador2 = new Jogador(2, "Jonathan", 'O');

        String jogarNovamente;

        System.out.println("===== JOGO DA VELHA =====");
        System.out.println(tabuleiro.getRegras());

        do {

            boolean fimDeJogo = false;

            while (!fimDeJogo) {

                tabuleiro.mostrarTabuleiro();

                Jogador jogadorAtual;

                if (tabuleiro.getJogadorDaVez() == 1) {
                    jogadorAtual = jogador1;
                } else {
                    jogadorAtual = jogador2;
                }

                System.out.println("\nVez de "
                        + jogadorAtual.getNome()
                        + " (" + jogadorAtual.getSimbolo() + ")");

                System.out.println("Digite a posicao (exemplo: A1):");

                String local = entrada.nextLine().trim().toUpperCase();

                boolean jogadaValida = tabuleiro.marcarJogada(
                        jogadorAtual.getSimbolo(), local);

                if (jogadaValida) {

                    boolean ganhou = tabuleiro.verificarGanhador(
                            jogadorAtual.getSimbolo());

                    if (ganhou) {

                        tabuleiro.mostrarTabuleiro();

                        System.out.println("\nParabens, "
                                + jogadorAtual.getNome()
                                + "! Voce venceu!");

                        tabuleiro.registrarVitoria(
                                jogadorAtual.getNumero());

                        fimDeJogo = true;

                    } else if (tabuleiro.tabuleiroCheio()) {

                        tabuleiro.mostrarTabuleiro();

                        System.out.println("\nA partida terminou empatada!");

                        tabuleiro.registrarEmpate();

                        fimDeJogo = true;

                    } else {

                        if (tabuleiro.getJogadorDaVez() == 1) {
                            tabuleiro.setJogadorDaVez(2);
                        } else {
                            tabuleiro.setJogadorDaVez(1);
                        }
                    }
                }
            }

            tabuleiro.mostrarPlacar();

            System.out.println("\nDesejam jogar novamente? (S/N)");
            jogarNovamente = entrada.nextLine().trim().toUpperCase();

            while (!jogarNovamente.equals("S")
                    && !jogarNovamente.equals("N")) {

                System.out.println("Digite S para sim ou N para nao.");
                jogarNovamente = entrada.nextLine().trim().toUpperCase();
            }

            if (jogarNovamente.equals("S")) {
                tabuleiro.reiniciarTabuleiro();
            }

        } while (jogarNovamente.equals("S"));

        System.out.println("\n===== PLACAR FINAL =====");
        tabuleiro.mostrarPlacar();
        System.out.println("Obrigado por jogar!");

        entrada.close();
    }
}

