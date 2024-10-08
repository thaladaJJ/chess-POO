public class Casa {
    private boolean corBranca;
    private final int linha;
    private final char coluna;
    private Piece ocupadaPor;

    public Casa(boolean corBranca, int linha, char coluna) {
        this.corBranca = corBranca;
        this.linha = linha;
        this.coluna = coluna;
        this.ocupadaPor = null;
    }

    public void ocupar(Piece p) {
        this.ocupadaPor = p;
    }

    public String desenho() {
        if(ocupadaPor == null)
            return "*";
        else
            return ocupadaPor.desenho();
    }
}
