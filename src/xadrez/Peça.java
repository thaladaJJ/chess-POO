package xadrez;

public abstract class Peça {
    protected boolean corBranca;
    protected boolean emJogo;
    protected final String ANSI_COLOR = "\u001B[35m";
    protected final String ANSI_RESET = "\u001B[0m";

    public Peça(boolean cor) {
        this.corBranca = cor;
        this.emJogo = true;
    }

    public abstract String desenho();
    public abstract boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD);
    public abstract String caminho(int linhaO, int colunaO, int linhaD, int colunaD);

    public boolean ehBranca() {
        return corBranca;
    }
}
