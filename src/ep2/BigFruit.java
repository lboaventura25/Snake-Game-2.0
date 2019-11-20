package ep2;

import javax.swing.*;

public class BigFruit extends Fruto {

    private int pontos;

    private int acrescentaTamanho;

    public BigFruit() {
        this.setAcrescentaTamanho(1);
        this.setPontos(2);
        this.setFrutoImagem(new ImageIcon("././assets/BigFruit.png"));
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
