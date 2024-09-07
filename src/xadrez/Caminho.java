package xadrez;

public class Caminho {
    public Casa[] caminho; // tamanho 8?
    public Tabuleiro tabuleiro;

    public Caminho(Tabuleiro tabuleiro, String movimento) {
        this.tabuleiro = tabuleiro;
        this.caminho = new Casa[8];
        for(Casa c : caminho)
            c = null;

        for(int i = 0; i < movimento.length(); i += 2) {
            this.caminho[i/2] = tabuleiro.getCasa(movimento.charAt(i), movimento.charAt(i+1));
        }

        System.out.print("Caminho: ");
        for(Casa c : caminho)
            if(c != null)
                System.out.print(c.getPosicao());
        System.out.println();

    }

    public boolean estaLivre() {
        Casa inicial = this.casaInicial();
        Casa ultima = this.casaFinal();

        for(int i = 0; i < caminho.length; i++) {
            if(caminho[i] == null)
                break;
            if(caminho[i] != inicial && caminho[i] != ultima && caminho[i].getPeça() != null)
                return false;
        }

        return true;
    }

    public Casa casaInicial() {
        return caminho[0];
    }

    public Casa casaFinal() {
        int i = 7;
        while(i > 0 && caminho[i] == null)
            i--;

        return caminho[i];
    }
}
