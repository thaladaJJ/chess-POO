package xadrez;

public class Torre extends Peça {
    public Torre(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "T";
        return ANSI_COLOR + "T" + ANSI_RESET;
    }

    @Override
    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        return colunaO == colunaD || linhaO == linhaD;
    }

    @Override
    public String caminho(int linhaO, int colunaO, int linhaD, int colunaD) {
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return "";
        String caminho = "";

        char charColuna = (char)('a' + colunaO);

        if(linhaD > linhaO) { // movimento para baixo
            for(int i = linhaO; i <= linhaD; i++) {
                caminho = caminho + (char)('8' - i) + charColuna;
            }
        }
        if(linhaD < linhaO) { // movimento para cima
            for(int i = linhaO; i >= linhaD; i--) {
                caminho = caminho + (char)('8' - i) + charColuna;
            }
        }
        if(colunaD > colunaO) { // movimento para direita
            for(int i = colunaO; i <= colunaD; i++) {
                caminho = caminho + (char)('8' - linhaO) + (char)('a' + i);
            }
        }
        if(colunaD < colunaO) { // movimento para esquerda
            for(int i = colunaO; i >= colunaD; i--) {
                caminho = caminho + (char)('8' - linhaO) + (char)('a' + i);
            }
        }

        return caminho;
    }
}
