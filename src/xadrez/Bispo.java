package xadrez;

public class Bispo extends Peça {
    public Bispo(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "B";
        return ANSI_COLOR + "B" + ANSI_RESET;
    }

    @Override
    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        return (Math.abs(linhaD - linhaO) == Math.abs(colunaD - colunaO));
    }

    @Override
    public String caminho(int linhaO, int colunaO, int linhaD, int colunaD) {
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return "";
        String caminho = "";

        int movimentoLinha = 1;
        if(linhaD < linhaO) movimentoLinha = -1;

        int movimentoColuna = 1;
        if(colunaD < colunaO) movimentoColuna = -1;

        int i = linhaO;
        int j = colunaO;
        while(i != linhaD && j != colunaD) {
            caminho = caminho + (char)('8' - i) + (char)('a' + j);
            i += movimentoLinha;
            j += movimentoColuna;
        }
        caminho = caminho + (char)('8' - i) + (char)('a' + j);

        return caminho;
    }
}
