package quad;

import java.util.ArrayList;
import java.util.List;

public class Quadtree {
    private double limiteEsquerdo;
    private double limiteSuperior;
    private double limiteDireito;
    private double limiteInferior;
    private List<Elemento> elementos;
    private List<Quadtree> subespacos;

    public Quadtree(double limiteEsquerdo, double limiteSuperior, double limiteDireito, double limiteInferior) {
        this.limiteEsquerdo = limiteEsquerdo;
        this.limiteSuperior = limiteSuperior;
        this.limiteDireito = limiteDireito;
        this.limiteInferior = limiteInferior;
        elementos = new ArrayList<>();
        subespacos = new ArrayList<>();
    }

    public void inserirElemento(Elemento elemento) {
        if (subespacos.isEmpty() && elementos.size() >= 4) {
            dividirEspaco();
        }

        if (subespacos.isEmpty()) {
            elementos.add(elemento);
        } else {
            int indiceSubespaco = calcularIndiceSubespaco(elemento);
            if (indiceSubespaco != -1) {
                subespacos.get(indiceSubespaco).inserirElemento(elemento);
            } else {
                elementos.add(elemento);
            }
        }
    }

    private int calcularIndiceSubespaco(Elemento elemento) {
        int indiceSubespaco = -1;
        double pontoMedioX = (limiteEsquerdo + limiteDireito) / 2;
        double pontoMedioY = (limiteSuperior + limiteInferior) / 2;

        boolean noPrimeiroQuadrante = elemento.posicaoX >= pontoMedioX && elemento.posicaoY < pontoMedioY;
        boolean noSegundoQuadrante = elemento.posicaoX < pontoMedioX && elemento.posicaoY < pontoMedioY;
        boolean noTerceiroQuadrante = elemento.posicaoX < pontoMedioX && elemento.posicaoY >= pontoMedioY;
        boolean noQuartoQuadrante = elemento.posicaoX >= pontoMedioX && elemento.posicaoY >= pontoMedioY;

        if (noPrimeiroQuadrante) {
            indiceSubespaco = 0;
        } else if (noSegundoQuadrante) {
            indiceSubespaco = 1;
        } else if (noTerceiroQuadrante) {
            indiceSubespaco = 2;
        } else if (noQuartoQuadrante) {
            indiceSubespaco = 3;
        }

        return indiceSubespaco;
    }

    private void dividirEspaco() {
        double pontoMedioX = (limiteEsquerdo + limiteDireito) / 2;
        double pontoMedioY = (limiteSuperior + limiteInferior) / 2;

        subespacos.add(new Quadtree(limiteEsquerdo, limiteSuperior, pontoMedioX, pontoMedioY)); // Primeiro quadrante
        subespacos.add(new Quadtree(pontoMedioX, limiteSuperior, limiteDireito, pontoMedioY)); // Segundo quadrante
        subespacos.add(new Quadtree(pontoMedioX, pontoMedioY, limiteDireito, limiteInferior)); // Terceiro quadrante
        subespacos.add(new Quadtree(limiteEsquerdo, pontoMedioY, pontoMedioX, limiteInferior)); // Quarto quadrante

        for (Elemento elemento : elementos) {
            int indiceSubespaco = calcularIndiceSubespaco(elemento);
            if (indiceSubespaco != -1) {
                subespacos.get(indiceSubespaco).inserirElemento(elemento);
            }
        }

        elementos.clear();
    }

    public List<Elemento> buscarElementosProximos(Elemento elemento) {
        List<Elemento> elementosProximos = new ArrayList<>();

        int indiceSubespaco = calcularIndiceSubespaco(elemento);
        if (indiceSubespaco != -1 && !subespacos.isEmpty()) {
            elementosProximos.addAll(subespacos.get(indiceSubespaco).buscarElementosProximos(elemento));
        }

        elementosProximos.addAll(elementos);
        return elementosProximos;
    }

    public void verificarColisoes(Elemento elemento) {
        List<Elemento> elementosProximos = buscarElementosProximos(elemento);
        for (Elemento outroElemento : elementosProximos) {
            if (elemento.colidir(outroElemento)) {
                System.out.println("Colisão entre elementos: " + elemento.toString() + " e " + outroElemento.toString());
            }
        }
    }

	public Elemento[] getElementos() {
		// TODO Auto-generated method stub
		return null;
	}
}

