package xadrez;

public class Cavalo extends Peça {
    public Cavalo(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "C";
        return ANSI_COLOR + "C" + ANSI_RESET;
    }

    @Override
    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        return ( (difLinha == 2 && difColuna == 1) || (difLinha == 1 && difColuna == 2) );
        // movimento valido se for
        // 2 passos na linha e 1 na coluna
        // ou 2 passos na coluna e 1 na linha
    }

    @Override
    public String caminho(int linhaO, int colunaO, int linhaD, int colunaD) {
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return "";
        String caminho = "" + (char)('8' - linhaO) + (char)('a' + colunaO) + (char)('8' - linhaD) + (char)('a' + colunaD);
        return caminho;
        // cavalo passa por cima as pecas
    }
}
