public class Jogo {
    private Tabuleiro tabuleiro;
    // private Jogada jogada; vetor? lista?
    private Jogador jogador1; // cor branca
    private Jogador jogador2; // cor preta
    private Peca[] pecas;
    private boolean turnoBranco;

    public Jogo(String jogador1, String jogador2) {
        this.turnoBranco = true;
        this.pecas = new Peca[32];

        pecas[0] = new Torre(true);
        pecas[1] = new Cavalo(true);
        pecas[2] = new Bispo(true);
        pecas[3] = new Rei(true);
        pecas[4] = new Dama(true);
        pecas[5] = new Bispo(true);
        pecas[6] = new Cavalo(true);
        pecas[7] = new Torre(true);
        for(int i = 8; i < 16; i++)
            pecas[i] = new Peao(true);

        pecas[16] = new Torre(false);
        pecas[17] = new Cavalo(false);
        pecas[18] = new Bispo(false);
        pecas[19] = new Rei(false);
        pecas[20] = new Dama(false);
        pecas[21] = new Bispo(false);
        pecas[22] = new Cavalo(false);
        pecas[23] = new Torre(false);
        for(int i = 24; i < 32; i++)
            pecas[i] = new Peao(false);

        this.tabuleiro = new Tabuleiro(pecas);
        this.jogador1 = new Jogador(jogador1, pecas, 0);  // peças brancas começam no indice 0
        this.jogador2 = new Jogador(jogador2, pecas, 16); // peças pretas começam no indice 16
    }

    public void iniciar() {
        String jogada = "";
        while(true) {
            System.out.println(tabuleiro.desenho());

            if(turnoBranco) {
                jogador1.informaJogada();
            }
            else {
                jogador2.informaJogada();
            }
            turnoBranco = !turnoBranco;
            System.out.printf("%n%n");

        }

    }
}
