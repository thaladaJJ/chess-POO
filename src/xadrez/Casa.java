package xadrez;

public class Casa {
    private final boolean corBranca;
    private final int linha;
    private final char coluna;
    private Peça ocupadaPor;

    public Casa(boolean corBranca, int linha, char coluna) {
        this.corBranca = corBranca;
        this.linha = linha;
        this.coluna = coluna;
        this.ocupadaPor = null;
    }

    public Peça getPeça() {
        return ocupadaPor;
    }

    public void ocupar(Peça p) {
        this.ocupadaPor = p;
    }

    public String desenho() {
        if(ocupadaPor == null)
            return "-";
        else
            return ocupadaPor.desenho();
    }

    public String getPosicao() {
        String str = "";
        str = str + (char)('0'+linha);
        str = str + coluna;
        return str;
    }

    public int getLinha() {
        return this.linha;
    }

    public char getColuna() {
        return this.coluna;
    }

}
