package ep2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public abstract class Snake {

	private String nome = new String();

	private int[] snakeTamanhoX = new int[750];
	private int[] snakeTamanhoY = new int[750];
	
	private ImageIcon cabecaDireita;
	private ImageIcon cabecaEsquerda;
	private ImageIcon cabecaCima;
	private ImageIcon cabecaBaixo;
	
	private ImageIcon snakeImagem;

	//Testado
	public Snake() {
		this.snakeTamanhoX[2] = 50;
		this.snakeTamanhoX[1] = 75;
		this.snakeTamanhoX[0] = 100;
		
		this.snakeTamanhoY[2] = 100;
		this.snakeTamanhoY[1] = 100;
		this.snakeTamanhoY[0] = 100;
	}

	//Testado
	public void setCabecaBaixo(ImageIcon cabecaBaixo) {
		this.cabecaBaixo = cabecaBaixo;
	}

	//Testado
	public void setCabecaCima(ImageIcon cabecaCima) {
		this.cabecaCima = cabecaCima;
	}

	//Testado
	public void setCabecaEsquerda(ImageIcon cabecaEsquerda) {
		this.cabecaEsquerda = cabecaEsquerda;
	}

	//Testado
	public void setSnakeImagem(ImageIcon snakeImagem) {
		this.snakeImagem = snakeImagem;
	}

	//Testado
	public ImageIcon getCabecaBaixo() {
		return cabecaBaixo;
	}

	//Testado
	public ImageIcon getCabecaCima() {
		return cabecaCima;
	}

	//Testado
	public ImageIcon getCabecaEsquerda() {
		return cabecaEsquerda;
	}

	//Testado
	public ImageIcon getSnakeImagem() {
		return snakeImagem;
	}

	//Testado
	public abstract int getTamanhoSnake();

	//Testado
	public ImageIcon getCabecaDireita() {
		return cabecaDireita;
	}

	//Testado
	public void setCabecaDireita(ImageIcon cabecaDireita) {
		this.cabecaDireita = cabecaDireita;
	}

	public int[] getSnakeTamanhoX() {
		return this.snakeTamanhoX;
	}

	public int[] getSnakeTamanhoY() {
		return snakeTamanhoY;
	}

	//Testado
	public String getNome() {
		return this.nome;
	}

	//Testado
	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract void resetTamanhoSnake();

	public abstract void setTamanhoSnake(int tamanhoSnake);

	public abstract int getPontos();

	public abstract  void setPontos(int pontos);

	public abstract void resetPontos();

}
