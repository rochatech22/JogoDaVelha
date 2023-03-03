import java.util.Scanner;

public class TesteJogoVelha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // nome dos jogadores

        System.out.println("Insira o nome do jogador 1: ");
        String jogador1 = scan.next();

        System.out.println("Insira o nome do jogador 2: ");
        String jogador2 = scan.next();

        Jogo jogo = new Jogo(jogador1, jogador2);
        jogo.jogar();
    }
}
