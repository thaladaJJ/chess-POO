public class Cavalo extends Piece {
    public Cavalo(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "C";
        return "c";
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
