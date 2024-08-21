public class Rei extends Peca {

    public Rei(boolean corBranca) {
        super(corBranca);
    }

    @Override
    public String desenho() {
        if(corBranca)
            return "R";
        return "r";
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
