package ep2;

import javax.swing.*;
import java.util.Random;

public abstract class Fruto {

    private ImageIcon frutoImagem;

    private int[] frutoXPos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
            350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650,
            675, 700, 725, 750, 775, 800, 825, 850};

    private int[] frutoYPos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
            350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};

    private Random random = new Random();

    private int xPos = this.random.nextInt(34);
    private int yPos = this.random.nextInt(23);

    public Fruto() {}

    //Testado
    public ImageIcon getFrutoImagem() {
        return frutoImagem;
    }

    //Testado
    public void setFrutoImagem(ImageIcon frutoImagem) {
        this.frutoImagem = frutoImagem;
    }

    //Testado
    public int[] getFrutoXPos() {
        return frutoXPos;
    }

    //Testado
    public int[] getFrutoYPos() {
        return frutoYPos;
    }

    //Testado
    public int getxPos() {
        return xPos;
    }

    //Testado
    public int getyPos() {
        return yPos;
    }

    //  Gera posição dos frutos randomicamente e não permite que gere um espaço onde tem um obstáculo
    public void atualizaRandom() {
        boolean check = true;

        while(check) {
            this.xPos = this.random.nextInt(34);
            this.yPos = this.random.nextInt(23);

            for (int i = 100, j = 550; i < 225; i += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 100, j = 525; j > 425; j -= 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 675, j = 550; i < 775; i += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 775, j = 550; j > 425; j -= 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 200, j = 150; j < 300; j += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 300, j = 275; j < 450; j += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 400, j = 350; j < 550; j += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 500, j = 275; j < 450; j += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }

            for (int i = 600, j = 150; j < 300; j += 25) {
                if(this.xPos != i && this.yPos != j) {
                    check = false;
                    break;
                }
            }
        }
    }

    //Testado
    public abstract int getAcrescentaTamanho();

    //Testado
    public abstract int getPontos();

    //Testado
    public abstract void setAcrescentaTamanho(int acrescentaTamanho);

    //Testado
    public abstract void setPontos(int pontos);
}
