package xadrez;

public class Peão extends Peça {
    public Peão(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "P";
        return ANSI_COLOR + "P" + ANSI_RESET;
    }

    @Override
    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        int movimento;
        if (corBranca)
            movimento = 1;  // branco se movimenta para baixo
        else
            movimento = -1; // preto se movimenta para cima

        // movimento de uma casa pra frente, sem captura
        if (linhaD == linhaO + movimento && colunaD == colunaO) {
            return true;
        }

        // movimento de duas casas para frente, sem captura
        if (linhaD == linhaO + 2 * movimento && colunaD == colunaO) {
            if ((linhaO == 1 && corBranca) || (linhaO == 6 && !corBranca)) {
                return true;
            }
        }

        // movimento de captura na diagonal
        if (linhaD == linhaO + movimento && Math.abs(colunaD - colunaO) == 1) {
            return true;
        }

        return false;
    }

    @Override
    public String caminho(int linhaO, int colunaO, int linhaD, int colunaD) {
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return "";

        String caminho = "";

        int movimento;
        if (corBranca)
            movimento = 1;
        else
            movimento = -1;

        caminho = caminho + (char)('8' - linhaO) + (char)(colunaO + 'a');

        for(int i = linhaO + movimento; i < linhaD; i += movimento) {
            caminho = caminho + (char)('8' - i) + (char)(colunaO + 'a');
        }

        caminho = caminho + (char)('8' - linhaD) + (char)(colunaD + 'a');

        return caminho;
    }
}
