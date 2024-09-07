package xadrez;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private ArrayList<String> jogadas = new ArrayList<>();
    private Jogador jogador1; // cor branca
    private Jogador jogador2; // cor preta
    private Peça[] peças;
    private boolean turnoBranco;
    private Jogada jogada;

    public Jogo() {
        this.turnoBranco = true;
        this.peças = new Peça[32];

        peças[0] = new Torre(true);
        peças[1] = new Cavalo(true);
        peças[2] = new Bispo(true);
        peças[3] = new Rei(true);
        peças[4] = new Dama(true);
        peças[5] = new Bispo(true);
        peças[6] = new Cavalo(true);
        peças[7] = new Torre(true);
        for(int i = 8; i < 16; i++)
            peças[i] = new Peão(true);

        peças[16] = new Torre(false);
        peças[17] = new Cavalo(false);
        peças[18] = new Bispo(false);
        peças[19] = new Rei(false);
        peças[20] = new Dama(false);
        peças[21] = new Bispo(false);
        peças[22] = new Cavalo(false);
        peças[23] = new Torre(false);
        for(int i = 24; i < 32; i++)
            peças[i] = new Peão(false);

        this.tabuleiro = new Tabuleiro(peças);
    }

    public void iniciar() {
        Scanner scan = new Scanner(System.in);
        String movimento = "";
        Jogada jogadaAtual = null;
        String nome;

        System.out.print("Digite o nome do primeiro jogador: ");
        nome = scan.nextLine();
        this.jogador1 = new Jogador(nome, this.peças, 0); // peças brancas começam no indice 0

        System.out.print("Digite o nome do segundo jogador: ");
        nome = scan.nextLine();
        this.jogador2 = new Jogador(nome, this.peças, 16); // peças pretas começam no indice 16

        while(true) {
            System.out.printf("Capturas de %s:\n", jogador1.getNome());
            System.out.println(jogador1.pecasCapturadas());
            System.out.println(tabuleiro.desenho());
            System.out.printf("Capturas de %s:\n", jogador2.getNome());
            System.out.println(jogador2.pecasCapturadas());

            if(turnoBranco) {
                movimento = jogador1.informaJogada();
            } else {
                movimento = jogador2.informaJogada();
            }
            if(movimento.equals("parar"))
                break;

            this.jogada = new Jogada(tabuleiro, movimento, turnoBranco);

            char linhaO = movimento.charAt(0);
            char colunaO = movimento.charAt(1);
            char linhaD = movimento.charAt(2);
            char colunaD = movimento.charAt(3);

            if(jogadaValida(linhaO, colunaO, linhaD, colunaD)) {
                System.out.println("realizando jogada");
                realizarJogada(linhaO, colunaO, linhaD, colunaD);
                turnoBranco = !turnoBranco;
            } else {
                System.out.println("jogada nao valida");
            }

            System.out.printf("%n%n");
        }

    }
    
    public boolean jogadaValida(char linhaO, char colunaO, char linhaD, char colunaD) {
        return jogada.ehValida();
    }

    public void realizarJogada(char linhaO, char colunaO, char linhaD, char colunaD) {
        int iLinhaO = '8' - linhaO;
        int iColunaO = colunaO - 'a';
        int iLinhaD = '8' - linhaD;
        int iColunaD = colunaD - 'a';

        Peça peçaO = tabuleiro.getPeça(iLinhaO, iColunaO);
        Peça peçaD = tabuleiro.getPeça(iLinhaD, iColunaD);

        tabuleiro.setPeça(null, linhaO, colunaO);
        tabuleiro.setPeça(peçaO, linhaD, colunaD);

        if(peçaD != null) {
            System.out.println(peçaD.desenho() + " capturado");
            if(turnoBranco) { // branco capturou
                jogador1.capturar(peçaD);
            }
            else { // preto capturou
                jogador2.capturar(peçaD);
            }
        }
        
    }

    public String registroJogo() {
        return "";
    }

}
