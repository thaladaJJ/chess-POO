public class Jogo {
    private Tabuleiro tabuleiro;
    // private Jogada jogada; vetor? lista?
    private Jogador jogador1; // cor branca
    private Jogador jogador2; // cor preta
    private Piece[] pieces;
    private boolean turnoBranco;

    public Jogo(String jogador1, String jogador2) {
        this.turnoBranco = true;
        this.pieces = new Piece[32];

        pieces[0] = new Torre(true);
        pieces[1] = new Cavalo(true);
        pieces[2] = new Bispo(true);
        pieces[3] = new Rei(true);
        pieces[4] = new Dama(true);
        pieces[5] = new Bispo(true);
        pieces[6] = new Cavalo(true);
        pieces[7] = new Torre(true);
        for(int i = 8; i < 16; i++)
            pieces[i] = new Peao(true);

        pieces[16] = new Torre(false);
        pieces[17] = new Cavalo(false);
        pieces[18] = new Bispo(false);
        pieces[19] = new Rei(false);
        pieces[20] = new Dama(false);
        pieces[21] = new Bispo(false);
        pieces[22] = new Cavalo(false);
        pieces[23] = new Torre(false);
        for(int i = 24; i < 32; i++)
            pieces[i] = new Peao(false);

        this.tabuleiro = new Tabuleiro(pieces);
        this.jogador1 = new Jogador(jogador1, pieces, 0);  // peças brancas começam no indice 0
        this.jogador2 = new Jogador(jogador2, pieces, 16); // peças pretas começam no indice 16
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
