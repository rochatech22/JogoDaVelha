import java.util.Scanner;
public class Jogo {
    private Jogador[] jogadores;
    private Tabuleiro tabuleiro;
    private int turnoAtual; // para saber quem joga a cada rodada

    public Jogo(String nomeJogador1, String nomeJogador2) {
        jogadores = new Jogador[2];
        jogadores[0] = new Jogador(nomeJogador1, 1);
        jogadores[1] = new Jogador(nomeJogador2, 2);
        tabuleiro = new Tabuleiro();
        turnoAtual = 0;
    }

    public void jogar() {
        Scanner sc = new Scanner(System.in);
        boolean acabou = false;
        while (!acabou) {
            tabuleiro.imprimir();
            System.out.println("Vez de " + jogadores[turnoAtual].getNome());
            System.out.print("Digite a posição (1 a 9): ");
            int posicao = sc.nextInt();
            boolean jogadaValida = tabuleiro.jogar(posicao, jogadores[turnoAtual].getTipo());
            if (jogadaValida) {
                if (tabuleiro.acabou()) {
                    acabou = true;
                    System.out.println(jogadores[turnoAtual].getNome() + " venceu!");
                } else {
                    if (turnoAtual == 0) {
                        turnoAtual = 1;
                    } else {
                        turnoAtual = 0;
                    }
                }
            } else {
                System.out.println("Jogada inválida, tente novamente.");
            }
        }
        tabuleiro.imprimir();
        System.out.println("Fim do jogo!");
        tabuleiro.reiniciar();
    }
}
