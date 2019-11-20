package ep2;

import javax.swing.*;

public class SimpleFruit extends Fruto {

    private int pontos;

    private int acrescentaTamanho;

    public SimpleFruit() {
        this.setPontos(1);
        this.setAcrescentaTamanho(1);
        this.setFrutoImagem(new ImageIcon("././assets/SimpleFruit.png"));
    }

    //Testado
    @Override
    public int getAcrescentaTamanho() {
        return this.acrescentaTamanho;
    }

    //Testado
    @Override
    public int getPontos() {
        return this.pontos;
    }

    //Testado
    @Override
    public void setAcrescentaTamanho(int acrescentaTamanho) {
        this.acrescentaTamanho = acrescentaTamanho;
    }

    //Testado
    @Override
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
