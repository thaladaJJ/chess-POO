package xadrez;

public class Tabuleiro {
    Casa[][] tabuleiro = new Casa[8][8];

    public Tabuleiro(Peça[] peças) {
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
                tabuleiro[i][j].ocupar(peças[pos++]);
        }
        for(int i = 7; i >= 6; i--) {
            for (int j = 0; j < 8; j++)
                tabuleiro[i][j].ocupar(peças[pos++]);
        }

    }

    public Peça getPeça(int linha, int coluna) {
        return tabuleiro[linha][coluna].getPeça();
    }

    public Casa getCasa(char linha, char coluna) {
        int i = '8' - linha;
        int j = coluna - 'a';
        return tabuleiro[i][j];
    }

    public void setPeça(Peça p, char linha, char coluna) {
        getCasa(linha, coluna).ocupar(p);
    }


    // fundo branco "\u001B[47m"
    // letra preta  "\u001B[30m"
    // reset        "\u001B[0m"
    public String desenho() {
        String desenho = "";

        for(int i = 0; i < 8; i++) {
            desenho = desenho + (8-i) + "   ";
            for(int j = 0; j < 8; j++) {
                desenho = desenho + tabuleiro[i][j].desenho() + " ";
            }
            desenho = desenho + '\n';
        }

        desenho = desenho + "                 \n";
        desenho = desenho + "    ";
        for(int i = 0; i < 8; i++)
            desenho = desenho + (char)('a'+i) + " ";
        desenho = desenho + '\n';

        return desenho;
    }

    private boolean noLimite(char linha, char coluna) {
        return true;
    }

}
