/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelha;

/**
 *
 * @author veronica62924506
 */

public class Jogador {

    private int numero;
    private String nome;
    private char simbolo;

    public Jogador(int numero, String nome, char simbolo) {
        this.numero = numero;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public void jogar() {
        // A jogada e controlada pela classe JogoDaVelha.
    }
}
