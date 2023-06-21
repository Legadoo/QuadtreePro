package quad;

import java.awt.Rectangle;

public class ElementoDinamico extends Elemento {
    public double velocidadeX;
    public double velocidadeY;

    public ElementoDinamico(double posicaoX, double posicaoY, double tamanho, double velocidadeX, double velocidadeY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.tamanho = tamanho;
        this.velocidadeX = velocidadeX;
        this.velocidadeY = velocidadeY;
    }

    public void atualizarPosicao() {
        posicaoX += velocidadeX;
        posicaoY += velocidadeY;
    }

    public boolean colidir(Elemento outroElemento) {
        return super.colidir(outroElemento);
    }

    @Override
    protected Rectangle getBounds() {
        int tamanhoInt = (int) tamanho;
        return new Rectangle((int) posicaoX, (int) posicaoY, tamanhoInt, tamanhoInt);
    }

    @Override
    protected int getY() {
        return (int) posicaoY;
    }

    @Override
    protected int getX() {
        return (int) posicaoX;
    }
}

