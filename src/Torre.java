public class Torre extends Peca {
    public Torre(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "T";
        return "t";
    }

    @Override
    public boolean movimento(char linhaO, char colunaO, char linhaD, char colunaD) {
        return false;
    }

    @Override
    public String caminho(char linhaO, char colunaO, char linhaD, char colunaD) {
        return null;
    }
}
