import java.util.*;

public class Jogador {
    private String nome;
    private Peca[] pecas;
    private boolean[] ativas;

    public Jogador(String nome, Peca[] pecas, int inicio) {
        this.nome = nome;
        this.pecas = new Peca[16];
        this.ativas = new boolean[16];

        for(int i = 0; i < 16; i++) {
            this.pecas[i] = pecas[i+inicio];
            this.ativas[i] = true;
        }
    }

    public String informaJogada() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Jogada: ");
        String jogada = scan.nextLine();

        System.out.printf("De: %s [%d,%d]%n", jogada.substring(0,2), (int)('8' - jogada.charAt(1)), (int)(jogada.charAt(0) - 'a'));
        System.out.printf("Para: %s [%d,%d]", jogada.substring(2,4), (int)('8' - jogada.charAt(3)), (int)(jogada.charAt(2) - 'a'));

        return jogada;
    }

}
