public class Tabuleiro {
    Casa[][] tabuleiro = new Casa[8][8];

    public Tabuleiro(Piece[] pieces) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i % 2 == j % 2)
                    tabuleiro[i][j] = new Casa(true, 8-i, (char)(j+'a')); // casa branca
                else
                    tabuleiro[i][j] = new Casa(false, 8-i, (char)(j+'a'));
            }
        }

        int pos = 0;
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++)
                tabuleiro[i][j].ocupar(pieces[pos++]);
        }
        for(int i = 7; i >= 6; i--) {
            for (int j = 0; j < 8; j++)
                tabuleiro[i][j].ocupar(pieces[pos++]);
        }

    }


    // fundo branco "\u001B[47m"
    // letra preta  "\u001B[30m"
    // reset        "\u001B[0m"
    public String desenho() {
        String desenho = "\u001B[47m\u001B[30m  ";

        for(int i = 0; i < 8; i++)
            desenho = desenho + (char)('a'+i);
        desenho = desenho + "  \u001B[0m" + '\n';

        for(int i = 0; i < 8; i++) {
            desenho = desenho + "\u001B[47m\u001B[30m" + (8-i) + " " + "\u001B[0m";
            for(int j = 0; j < 8; j++) {
                desenho = desenho + tabuleiro[i][j].desenho();
            }
            desenho = desenho + "\u001B[47m\u001B[30m" + " " + (8-i) + "\u001B[0m";
            desenho = desenho + '\n';
        }

        desenho = desenho + "\u001B[47m\u001B[30m  ";
        for(int i = 0; i < 8; i++)
            desenho = desenho + (char)('a'+i);
        desenho = desenho + "  \u001B[0m" + '\n' ;

        return desenho;
    }

}
