package xadrez;

public class Dama extends Peça {
    public Dama(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "D";
        return ANSI_COLOR + "D" + ANSI_RESET;
    }

    @Override
    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        boolean movimentoReto = (colunaO == colunaD || linhaO == linhaD);
        boolean movimentoDiagonal = (Math.abs(linhaD - linhaO) == Math.abs(colunaD - colunaO));
        return movimentoReto || movimentoDiagonal;
    }

    @Override
    public String caminho(int linhaO, int colunaO, int linhaD, int colunaD) {
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return "";
        boolean movimentoReto = (colunaO == colunaD || linhaO == linhaD);
        boolean movimentoDiagonal = (Math.abs(linhaD - linhaO) == Math.abs(colunaD - colunaO));
        String caminho = "";
        if(movimentoReto)
            caminho =  new Torre(true).caminho(linhaO, colunaO, linhaD, colunaD);
        else if(movimentoDiagonal)
            caminho =  new Bispo(true).caminho(linhaO, colunaO, linhaD, colunaD);
        return caminho;
    }
}
