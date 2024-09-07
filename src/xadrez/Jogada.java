package xadrez;

public class Jogada {
    private Caminho caminho;
    protected Tabuleiro tabuleiro;
    private boolean vezBranco;

    public Jogada(Tabuleiro tabuleiro, String movimento, boolean vezBranco) {
        int linhaO = '8' - movimento.charAt(0);
        int colunaO = movimento.charAt(1) - 'a';
        int linhaD = '8' - movimento.charAt(2);
        int colunaD = movimento.charAt(3) - 'a';

        this.vezBranco = vezBranco;

        String caminhoString = "";
        if(tabuleiro.getPeça(linhaO, colunaO) != null)
            caminhoString = tabuleiro.getPeça(linhaO, colunaO).caminho(linhaO, colunaO, linhaD, colunaD);
        else
            throw new IllegalArgumentException("Posicao vazia");

        caminho = new Caminho(tabuleiro, caminhoString);
    }

    public boolean ehValida() {
        if(caminho.casaInicial() == null)
            return false;

        if(caminho.casaInicial().getPeça().ehBranca() != vezBranco) {
            System.out.println("Peça na casa inicial tem cor diferente");
            return false;
        }
        if(!caminho.estaLivre()) {
            System.out.println("caminho nao esta livre");
            return false;
        }

        if(caminho.casaFinal().getPeça() != null && caminho.casaFinal().getPeça().ehBranca() == vezBranco) {
            System.out.println("casa final tem peça de cor invalida");
            return false;
        }

        if(caminho.casaInicial().getPeça() instanceof Peão && caminho.casaInicial().getColuna() != caminho.casaFinal().getColuna()) {
            // peao tentando capturar
            // tem que existir uma peça na casa final
            if(caminho.casaFinal().getPeça() == null) {
                System.out.println("peao tentando captura invalida");
                return false;
            }
        }
        else if(caminho.casaInicial().getPeça() instanceof Peão && caminho.casaInicial().getColuna() == caminho.casaFinal().getColuna()) {
            // peao andando reto
            // nao pode realizar captura
            if(caminho.casaFinal().getPeça() != null) {
                System.out.println("peao tentando captura em movimento reto");
                return false;
            }
        }

        return true;
    }

    public boolean ehXeque() {
        return true;
    }

    public boolean ehXequeMate() {
        return true;
    }

    public Caminho getCaminho() {
        return this.caminho;
    }
}
