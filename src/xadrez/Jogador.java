package xadrez;

import java.util.*;

public class Jogador {
    private String nome;
    private Peça[] peças;
    private ArrayList<Peça> capturas = new ArrayList<>();
    private boolean[] ativas;

    public Jogador(String nome, Peça[] peças, int inicio) {
        this.nome = nome;
        this.peças = new Peça[16];
        this.ativas = new boolean[16];

        for(int i = 0; i < 16; i++) {
            this.peças[i] = peças[i+inicio];
            this.ativas[i] = true;
        }
    }

    public String informaJogada() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vez de " + this.nome);

        System.out.println("Digite a jogada no formato <linha><coluna><linha><coluna>, ex: 1a8a");
        System.out.print("Jogada: ");

        String jogada = scan.nextLine();
        System.out.println(jogada);

        return jogada;
    }

    public String pecasCapturadas() {
        String capturadas = "";
        for(Peça p : capturas) {
            capturadas = capturadas + p.desenho() + " ";
        }
        return capturadas + "\n";
    }

    public void capturar(Peça p) {
        capturas.add(p);
    }

    public String getNome() {
        return this.nome;
    }

}
