public abstract class Piece {
    protected boolean corBranca;
    protected boolean emJogo;

    public Piece(boolean cor) {
        this.corBranca = cor;
        this.emJogo = true;
    }

    public abstract String desenho();
    public abstract boolean movimento(char linhaO, char colunaO, char linhaD, char colunaD);
    public abstract String caminho(char linhaO, char colunaO, char linhaD, char colunaD);
}
