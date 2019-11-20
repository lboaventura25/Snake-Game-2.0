package ep2;

import javax.swing.*;

public class SnakeComum extends Snake {

    private int tamanhoSnakeComum;
    private int pontos;
    private ImageIcon imageIcon;

    public SnakeComum() {
        this.tamanhoSnakeComum = 3;
        this.pontos = 0;
        this.setNome("Comum");
    }

    @Override
    public void resetTamanhoSnake() {
        this.tamanhoSnakeComum = 3;
    }

    @Override
    public void setTamanhoSnake(int tamanhoSnake) {
         this.tamanhoSnakeComum += tamanhoSnake;
    }

    @Override
    public int getPontos() {
        return this.pontos;
    }

    @Override
    public void setPontos(int pontos) {
        this.pontos += (1 * pontos);
    }

    @Override
    public void resetPontos() {
        this.pontos = 0;
    }

    @Override
    public int getTamanhoSnake() {
        return this.tamanhoSnakeComum;
    }

}
