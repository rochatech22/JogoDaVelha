public class Tabuleiro {
    private Quadrado[] quadrados;

    public Tabuleiro() {
        quadrados = new Quadrado[9];
        for (int i = 0; i < 9; i++) {
            quadrados[i] = new Quadrado();
        }
    }

    public void imprimir() {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(quadrados[i*3+j].getValor() + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    public boolean acabou() {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (quadrados[i*3].getValor() != 0 && quadrados[i*3].getValor() == quadrados[i*3+1].getValor() && quadrados[i*3].getValor() == quadrados[i*3+2].getValor()) {
                return true;
            }
        }
        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (quadrados[i].getValor() != 0 && quadrados[i].getValor() == quadrados[i+3].getValor() && quadrados[i].getValor() == quadrados[i+6].getValor()) {
                return true;
            }
        }
        // Verifica diagonais
        if (quadrados[0].getValor() != 0 && quadrados[0].getValor() == quadrados[4].getValor() && quadrados[0].getValor() == quadrados[8].getValor()) {
            return true;
        }
        if (quadrados[2].getValor() != 0 && quadrados[2].getValor() == quadrados[4].getValor() && quadrados[2].getValor() == quadrados[6].getValor()) {
            return true;
        }
        // Verifica empate
        for (int i = 0; i < 9; i++) {
            if (quadrados[i].getValor() == 0) {
                return false;
            }
        }
        return true;
    }
    public void reiniciar() {
        for(int i = 0; i < 9; i++) {
            quadrados[i].setValor(0);
        }
    }

    public boolean jogar(int posicao, int tipoJogador) {
        if (posicao < 1 || posicao > 9) {
            return false;
        }
        if (quadrados[posicao-1].getValor() != 0) {
            return false;
        }
        quadrados[posicao-1].setValor(tipoJogador);
        return true;
    }
}
