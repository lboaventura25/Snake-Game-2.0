package ep2;

import javax.swing.*;

public class DecreaseFruit extends Fruto {

    private int pontos;

    private int acrescentaTamanho;

    public DecreaseFruit() {
        this.setAcrescentaTamanho(0);
        this.setPontos(0);
        this.setFrutoImagem(new ImageIcon("././assets/DecreaseFruit.png"));
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
