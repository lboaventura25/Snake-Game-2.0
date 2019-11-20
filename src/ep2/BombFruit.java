package ep2;

import javax.swing.*;

public class BombFruit extends Fruto {

    private int pontos;

    private int acrescentaTamanho;

    public BombFruit() {
        this.setFrutoImagem(new ImageIcon("././assets/BombFruit.png"));
    }

    @Override
    public int getAcrescentaTamanho() {
        return this.acrescentaTamanho;
    }

    @Override
    public int getPontos() {
        return this.pontos;
    }

    @Override
    public void setAcrescentaTamanho(int acrescentaTamanho) {
        this.acrescentaTamanho = acrescentaTamanho;
    }

    @Override
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
