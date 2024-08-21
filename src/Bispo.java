public class Bispo extends Piece {
    public Bispo(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "B";
        return "b";
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
