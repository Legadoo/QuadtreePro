package quad;

import java.awt.Rectangle;

public abstract class Elemento {
    protected double posicaoX;
    protected double posicaoY;
    protected double tamanho;

    public boolean colidir(Elemento outroElemento) {
        double distanciaX = Math.abs(posicaoX - outroElemento.posicaoX);
        double distanciaY = Math.abs(posicaoY - outroElemento.posicaoY);
        double distanciaLimite = tamanho / 2 + outroElemento.tamanho / 2;

        if (distanciaX <= distanciaLimite && distanciaY <= distanciaLimite) {
            return true; // Houve colisão
        } else {
            return false; // Não houve colisão
        }
    }

	protected abstract Rectangle getBounds();

	protected abstract int getY();

	protected abstract int getX();
}
