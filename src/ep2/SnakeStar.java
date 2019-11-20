package ep2;

public class SnakeStar extends Snake {

    private int tamanhoSnakeComum;
    private int pontos;

    //Testado
    public SnakeStar() {
        this.pontos = 0;
        this.tamanhoSnakeComum = 3;
        this.setNome("Star");
    }

    //Testado
    @Override
    public int getTamanhoSnake() {
        return this.tamanhoSnakeComum;
    }

    //Testado
    @Override
    public void resetTamanhoSnake() {
        this.tamanhoSnakeComum = 3;
    }

    //Testado
    @Override
    public void setTamanhoSnake(int tamanhoSnake) {
        this.tamanhoSnakeComum += tamanhoSnake;
    }

    //Testado
    @Override
    public int getPontos() {
        return this.pontos;
    }

    //Testado
    @Override
    public void setPontos(int pontos) {
        this.pontos += (2 * pontos);
    }

    //Testado
    @Override
    public void resetPontos() {
        this.pontos = 0;
    }
}
