package xadrez;

public class Rei extends Peça {

    public Rei(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "R";
        return ANSI_COLOR + "R" + ANSI_RESET;
    }

    @Override
    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        return difLinha <= 1 && difColuna <= 1;
    }

    @Override
    public String caminho(int linhaO, int colunaO, int linhaD, int colunaD) {
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return "";
        String caminho = "" + (char)('8' - linhaO) + (char)('a' + colunaO) + (char)('8' - linhaD) + (char)('a' + colunaD);
        return caminho;
    }
}
