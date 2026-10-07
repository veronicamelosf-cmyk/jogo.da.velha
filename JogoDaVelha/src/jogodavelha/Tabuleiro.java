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
        this.houveGanhadorUltRodada = false;
        this.jogadorDaVez = 1;
    }

    public boolean isHouveGanhadorUltRodada() {
        return houveGanhadorUltRodada;
    }

    public void setHouveGanhadorUltRodada(boolean houveGanhadorUltRodada) {
        this.houveGanhadorUltRodada = houveGanhadorUltRodada;
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

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
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
                      1     %C  |   %C  |   %C
                                |       |
                         -------+-------+-------
                                |       |
                      2     %C  |   %C  |   %C
                                |       |
                         -------+-------+-------
                                |       |
                      3     %C  |   %C  |   %C
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
                System.out.println("Local inválido! Use A1 até C3.");
                return false;
        }

        System.out.println("Essa posição já está ocupada!");
        return false;
    }

    public boolean verificarGanhador(char simbolo) {

        // Linha 1
        if (a1 == simbolo && b1 == simbolo && c1 == simbolo) {
            return true;
        }

        // Linha 2
        if (a2 == simbolo && b2 == simbolo && c2 == simbolo) {
            return true;
        }

        // Linha 3
        if (a3 == simbolo && b3 == simbolo && c3 == simbolo) {
            return true;
        }

        // Coluna A
        if (a1 == simbolo && a2 == simbolo && a3 == simbolo) {
            return true;
        }

        // Coluna B
        if (b1 == simbolo && b2 == simbolo && b3 == simbolo) {
            return true;
        }

        // Coluna C
        if (c1 == simbolo && c2 == simbolo && c3 == simbolo) {
            return true;
        }

        // Diagonal principal
        if (a1 == simbolo && b2 == simbolo && c3 == simbolo) {
            return true;
        }

        // Diagonal secundária
        if (a3 == simbolo && b2 == simbolo && c1 == simbolo) {
            return true;
        }

        return false;
    }

    public boolean tabuleiroCheio() {

        if (a1 == ' ' || a2 == ' ' || a3 == ' '
                || b1 == ' ' || b2 == ' ' || b3 == ' '
                || c1 == ' ' || c2 == ' ' || c3 == ' ') {

            return false;
        }

        return true;
    }
}
