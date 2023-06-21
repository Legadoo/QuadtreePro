package quad;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Quadtree quadtree = new Quadtree(0, 0, 100, 100); //  cena

        // Criando elementos estáticos
        for (int i = 0; i < 50; i++) {
            double posicaoX = getRandomValue(0, 100); // posicionamento dos elementos
            double posicaoY = getRandomValue(0, 100); // posicionamento dos elementos
            double tamanho = getRandomValue(1, 10); // tamanho dos elementos
            ElementoEstatico elementoEstatico = new ElementoEstatico(posicaoX, posicaoY, tamanho);
            quadtree.inserirElemento(elementoEstatico);
        }

        // jogador
        Jogador jogador = new Jogador(50, 50, 5, 1, 1); // jogador

        // Loop 
        boolean running = true;
        while (running) {
            // Movimenta o jogador aleatoriamente
            double deltaX = getRandomValue(-1, 1); // limite do movimento do jogador
            double deltaY = getRandomValue(-1, 1); // limite do movimento do jogador
            jogador.mover(deltaX, deltaY);

            
            quadtree.verificarColisoes(jogador);

        
            try {
                Thread.sleep(100); //  valor do tempo rodando
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static double getRandomValue(double minValue, double maxValue) {
        Random random = new Random();
        return minValue + random.nextDouble() * (maxValue - minValue);
    }
}

