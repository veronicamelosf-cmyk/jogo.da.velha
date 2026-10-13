/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelha;

/**
 *
 * @author veronica62924506
 */

public class Tabuleiro {

    private int notaJ1;
    private int notaJ2;
    private int empates;

    private String regras;
    private boolean houveGanhadorUltRodada;
    private int jogadorDaVez;

    private char a1 = ' ';
    private char a2 = ' ';
    private char a3 = ' ';
    private char b1 = ' ';
    private char b2 = ' ';
    private char b3 = ' ';
    private char c1 = ' ';
    private char c2 = ' ';
    private char c3 = ' ';

    public Tabuleiro(String regras) {
        this.regras = regras;
        this.notaJ1 = 0;
        this.notaJ2 = 0;
        this.empates = 0;
        this.houveGanhadorUltRodada = false;
        this.jogadorDaVez = 1;
    }

    public int getNotaJ1() {
        return notaJ1;
    }

    public void setNotaJ1(int notaJ1) {
        this.notaJ1 = notaJ1;
    }

    public int getNotaJ2() {
        return notaJ2;
    }

    public void setNotaJ2(int notaJ2) {
        this.notaJ2 = notaJ2;
    }

    public int getEmpates() {
        return empates;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public boolean isHouveGanhadorUltRodada() {
        return houveGanhadorUltRodada;
    }

    public void setHouveGanhadorUltRodada(
            boolean houveGanhadorUltRodada) {
        this.houveGanhadorUltRodada = houveGanhadorUltRodada;
    }

    public int getJogadorDaVez() {
        return jogadorDaVez;
    }

    public void setJogadorDaVez(int jogadorDaVez) {
        this.jogadorDaVez = jogadorDaVez;
    }

    public void mostrarTabuleiro() {

        System.out.printf("""
                            
                            A       B       C
                                |       |
                      1     %C   |   %C   |   %C
                                |       |
                         -------+-------+-------
                                |       |
                      2     %C   |   %C   |   %C
                                |       |
                         -------+-------+-------
                                |       |
                      3     %C   |   %C   |   %C
                                |       |

                            """,
                a1, b1, c1,
                a2, b2, c2,
                a3, b3, c3);
    }

    public boolean marcarJogada(char simbolo, String coordenada) {

        switch (coordenada) {

            case "A1":
                if (a1 == ' ') {
                    a1 = simbolo;
                    return true;
                }
                break;

            case "A2":
                if (a2 == ' ') {
                    a2 = simbolo;
                    return true;
                }
                break;

            case "A3":
                if (a3 == ' ') {
                    a3 = simbolo;
                    return true;
                }
                break;

            case "B1":
                if (b1 == ' ') {
                    b1 = simbolo;
                    return true;
                }
                break;

            case "B2":
                if (b2 == ' ') {
                    b2 = simbolo;
                    return true;
                }
                break;

            case "B3":
                if (b3 == ' ') {
                    b3 = simbolo;
                    return true;
                }
                break;

            case "C1":
                if (c1 == ' ') {
                    c1 = simbolo;
                    return true;
                }
                break;

            case "C2":
                if (c2 == ' ') {
                    c2 = simbolo;
                    return true;
                }
                break;

            case "C3":
                if (c3 == ' ') {
                    c3 = simbolo;
                    return true;
                }
                break;

            default:
                System.out.println(
                        "Posicao invalida! Escolha de A1 ate C3.");
                return false;
        }

        System.out.println("Essa posicao ja esta ocupada!");
        return false;
    }

    public boolean verificarGanhador(char simbolo) {

        // Verifica as linhas
        if (a1 == simbolo && b1 == simbolo && c1 == simbolo) {
            return true;
        }

        if (a2 == simbolo && b2 == simbolo && c2 == simbolo) {
            return true;
        }

        if (a3 == simbolo && b3 == simbolo && c3 == simbolo) {
            return true;
        }

        // Verifica as colunas
        if (a1 == simbolo && a2 == simbolo && a3 == simbolo) {
            return true;
        }

        if (b1 == simbolo && b2 == simbolo && b3 == simbolo) {
            return true;
        }

        if (c1 == simbolo && c2 == simbolo && c3 == simbolo) {
            return true;
        }

        // Verifica as diagonais
        if (a1 == simbolo && b2 == simbolo && c3 == simbolo) {
            return true;
        }

        if (a3 == simbolo && b2 == simbolo && c1 == simbolo) {
            return true;
        }

        return false;
    }

    public boolean tabuleiroCheio() {

        return a1 != ' ' && a2 != ' ' && a3 != ' '
                && b1 != ' ' && b2 != ' ' && b3 != ' '
                && c1 != ' ' && c2 != ' ' && c3 != ' ';
    }

    public void registrarVitoria(int jogador) {

        houveGanhadorUltRodada = true;

        if (jogador == 1) {
            notaJ1++;
        } else if (jogador == 2) {
            notaJ2++;
        }
    }

    public void registrarEmpate() {
        empates++;
        houveGanhadorUltRodada = false;
    }

    public void mostrarPlacar() {

        System.out.println("\n===== PLACAR =====");
        System.out.println("Veronica (X): " + notaJ1 + " vitoria(s)");
        System.out.println("Jonathan (O): " + notaJ2 + " vitoria(s)");
        System.out.println("Empates: " + empates);
        System.out.println("==================");
    }

    public void reiniciarTabuleiro() {

        a1 = ' ';
        a2 = ' ';
        a3 = ' ';
        b1 = ' ';
        b2 = ' ';
        b3 = ' ';
        c1 = ' ';
        c2 = ' ';
        c3 = ' ';

        jogadorDaVez = 1;
        houveGanhadorUltRodada = false;
    }
}

