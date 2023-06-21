package quad;

public class Jogador extends ElementoDinamico {
    private boolean colidindo;

    public Jogador(double posicaoX, double posicaoY, double tamanho, double velocidadeX, double velocidadeY) {
        super(posicaoX, posicaoY, tamanho, velocidadeX, velocidadeY);
        colidindo = false;
    }

    public void mover(double deltaX, double deltaY) {
        posicaoX += deltaX;
        posicaoY += deltaY;
    }

    public boolean isColidindo() {
        return colidindo;
    }

    public void setColidindo(boolean colidindo) {
        this.colidindo = colidindo;
    }

    @Override
    public String toString() {
        return "Jogador [posicaoX=" + posicaoX + ", posicaoY=" + posicaoY + ", tamanho=" + tamanho + ", velocidadeX="
                + velocidadeX + ", velocidadeY=" + velocidadeY + "]";
    }
}


