package quad;

import java.awt.Rectangle;

public class ElementoEstatico extends Elemento {
    public ElementoEstatico(double posicaoX, double posicaoY, double tamanho) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.tamanho = tamanho;
    }

    public boolean colidir(Elemento outroElemento) {
        return super.colidir(outroElemento);
    }

	@Override
	protected Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
}

