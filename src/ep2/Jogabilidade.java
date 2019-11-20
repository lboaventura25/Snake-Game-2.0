package ep2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogabilidade extends JPanel implements KeyListener, ActionListener{
	
	private boolean esquerda = false;
	private boolean direita = false;
	private boolean cima = false;
	private boolean baixo = false;

	private boolean morreu = false;
	
	private Timer tempo;
	private int atraso = 90;

	private Snake snakeEscolhida;

	//TODO frutos
	private Fruto frutos = new SimpleFruit();

	private int movimentos = 0;

	private Random random = new Random();

	private int contadorThread = random.nextInt();

	private int atrasoThread = 8000;

	public Timer tempoThread;
	
	private ImageIcon tituloImagem;
	
	
	public Jogabilidade(Snake snakeEscolhida) {
		// Construtor da classe TelaJogo
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		this.tempo = new Timer(this.atraso, this);
		//new Thread(new ThreadFrutos(this)).start();

		this.tempoThread = new Timer(atrasoThread, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				atualizaFruto();
			}
		});

		this.tempoThread.start();

		this.snakeEscolhida = snakeEscolhida;

		this.tempo.start();
	}
	
	public synchronized void paint(Graphics graphic) {

		//Jeito com classe
		if(this.movimentos == 0) {
			this.posicionaSnake();
		}
		
		// Desenha a borda do titulo do Jogo
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 10, 851, 55);
		
		// Desenha o título do Jogo
		tituloImagem = new ImageIcon("././assets/snaketitle.jpg");
		tituloImagem.paintIcon(this, graphic, 25, 11);
		 
		// Desenha borda do jogo
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 74, 851, 577);
		 
		// Desenha backdround do Jogo
		graphic.setColor(Color.BLACK);
		graphic.fillRect(25, 75, 850, 575);	 
		
		// Desenha pontuação do jogo
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("arial", Font.PLAIN, 16));
		graphic.drawString("Scores: " + this.snakeEscolhida.getPontos(), 770, 35);
		
		// Desenha tamanho da Cobra
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("arial", Font.PLAIN, 16));
		graphic.drawString("Tamanho: " + this.snakeEscolhida.getTamanhoSnake(), 770, 55);

		//jeito com classe
		this.snakeEscolhida.setCabecaDireita(new ImageIcon("././assets/rightmouth.png"));
		this.snakeEscolhida.getCabecaDireita().paintIcon(this, graphic, this.snakeEscolhida.getSnakeTamanhoX()[0],
														 this.snakeEscolhida.getSnakeTamanhoY()[0]);

		//Jeito com classe
		for(int x = 0; x < this.snakeEscolhida.getTamanhoSnake(); x++) {
			if(x == 0 && this.direita) {
				this.snakeEscolhida.setCabecaDireita(new ImageIcon("././assets/rightmouth.png"));
				this.snakeEscolhida.getCabecaDireita().paintIcon(this, graphic, this.snakeEscolhida.getSnakeTamanhoX()[x],
						this.snakeEscolhida.getSnakeTamanhoY()[x]);
			}
			if(x == 0 && this.esquerda) {
				this.snakeEscolhida.setCabecaEsquerda(new ImageIcon("././assets/leftmouth.png"));
				this.snakeEscolhida.getCabecaEsquerda().paintIcon(this, graphic, this.snakeEscolhida.getSnakeTamanhoX()[x],
						this.snakeEscolhida.getSnakeTamanhoY()[x]);
			}
			if(x == 0 && this.cima) {
				this.snakeEscolhida.setCabecaCima(new ImageIcon("././assets/upmouth.png"));
				this.snakeEscolhida.getCabecaCima().paintIcon(this, graphic, this.snakeEscolhida.getSnakeTamanhoX()[x],
						this.snakeEscolhida.getSnakeTamanhoY()[x]);
			}
			if(x == 0 && this.baixo) {
				this.snakeEscolhida.setCabecaBaixo(new ImageIcon("././assets/downmouth.png"));
				this.snakeEscolhida.getCabecaBaixo().paintIcon(this, graphic, this.snakeEscolhida.getSnakeTamanhoX()[x],
						this.snakeEscolhida.getSnakeTamanhoY()[x]);
			}
			if(x != 0) {
				this.snakeEscolhida.setSnakeImagem(new ImageIcon("././assets/snakeimage.png"));
				this.snakeEscolhida.getSnakeImagem().paintIcon(this, graphic, this.snakeEscolhida.getSnakeTamanhoX()[x],
						this.snakeEscolhida.getSnakeTamanhoY()[x]);
			}
		}

		//Jeito com classe Fruto
		if((this.frutos.getFrutoXPos()[this.frutos.getxPos()] == this.snakeEscolhida.getSnakeTamanhoX()[0] && this.frutos.getFrutoYPos()[this.frutos.getyPos()] == this.snakeEscolhida.getSnakeTamanhoY()[0])) {
			this.snakeEscolhida.setPontos(this.frutos.getPontos());
			this.snakeEscolhida.setTamanhoSnake(this.frutos.getAcrescentaTamanho());
			if(this.frutos.getFrutoImagem().getDescription().substring(this.frutos.getFrutoImagem().getDescription().lastIndexOf('/')+1, this.frutos.getFrutoImagem().getDescription().length()).equals("DecreaseFruit.png")) {
				this.snakeEscolhida.resetTamanhoSnake();
				System.out.println("DECREASEEEEEEEE");
			}
			else if(this.frutos.getFrutoImagem().getDescription().substring(this.frutos.getFrutoImagem().getDescription().lastIndexOf('/')+1, this.frutos.getFrutoImagem().getDescription().length()).equals("BombFruit.png")) {
				this.snakeEscolhida.resetTamanhoSnake();
				this.snakeEscolhida.resetPontos();
				this.posicionaSnake();
				System.out.println("BOOOOOOMB");
			}
			System.out.println("Comeu fruto " + this.frutos.getFrutoImagem().getDescription());
			this.atualizaFruto();
			this.frutos.atualizaRandom();
			this.tempoThread.restart();
		}

		//Jeito com classe Fruto
		this.frutos.getFrutoImagem().paintIcon(this, graphic, this.frutos.getFrutoXPos()[this.frutos.getxPos()], this.frutos.getFrutoYPos()[this.frutos.getyPos()]);

		//Jeito com classe
		for(int w = 1; w < this.snakeEscolhida.getTamanhoSnake(); w++) {
			if(this.snakeEscolhida.getSnakeTamanhoX()[w] == this.snakeEscolhida.getSnakeTamanhoX()[0] && this.snakeEscolhida.getSnakeTamanhoY()[w] == this.snakeEscolhida.getSnakeTamanhoY()[0]) {
				this.direita = false;
				this.esquerda = false;
				this.cima = false;
				this.baixo= false;
				this.morreu = true;
				this.snakeEscolhida.resetPontos();
				this.snakeEscolhida.resetTamanhoSnake();
				this.posicionaSnake();

				System.out.println("DEU RUIM -- {}" + w + " !!!");

				//this.gameOver(graphic);
			}
			if(this.snakeEscolhida.getNome().equals("Comum") || this.snakeEscolhida.getNome().equals("Star")) {
				this.checaColisaoComBarreiras();
			}
		}

		graphic.setColor(Color.RED);
		// Desenha obstáculos na tela
		for (int i = 100, j = 550; i < 225; i += 25)
			graphic.fillRect(i, j, 25, 25);
		for (int i = 100, j = 525; j > 425; j -= 25)
			graphic.fillRect(i, j, 25, 25);

		for (int i = 675, j = 550; i < 775; i += 25)
			graphic.fillRect(i, j, 25, 25);
		for (int i = 775, j = 550; j > 425; j -= 25)
			graphic.fillRect(i, j, 25, 25);

		// Desenha obstáculos na tela
		for(int i = 200, j = 150; j < 300; j+= 25)
			graphic.fillRect(i, j, 25, 25);
		for(int i = 300, j = 275; j < 450; j+= 25)
			graphic.fillRect(i, j, 25, 25);
		for (int i = 400, j = 350; j < 550; j += 25)
			graphic.fillRect(i, j, 25, 25);
		for (int i = 500, j = 275; j < 450; j += 25)
			graphic.fillRect(i, j, 25, 25);
		for(int i = 600, j = 150; j < 300; j += 25)
			graphic.fillRect(i, j, 25, 25);

		graphic.dispose();
	}

	private void checaColisaoComBarreiras() {
		for(int w = 1; w < this.snakeEscolhida.getTamanhoSnake(); w++) {
			for (int i = 100, j = 550; i < 225; i += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 100, j = 525; j > 425; j -= 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 675, j = 550; i < 775; i += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 775, j = 550; j > 425; j -= 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 200, j = 150; j < 300; j += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
					//System.out.println("-------- BARREIRAAAAA");
				}
			}

			for (int i = 300, j = 275; j < 450; j += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 400, j = 350; j < 550; j += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 500, j = 275; j < 450; j += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}

			for (int i = 600, j = 150; j < 300; j += 25) {
				if (this.snakeEscolhida.getSnakeTamanhoX()[w] == i && this.snakeEscolhida.getSnakeTamanhoY()[w] == j) {
					this.snakeEscolhida.resetTamanhoSnake();
					this.snakeEscolhida.resetPontos();
					this.posicionaSnake();
				}
			}
		}
	}

	private void posicionaSnake() {
		this.snakeEscolhida.getSnakeTamanhoX()[2] = 50;
		this.snakeEscolhida.getSnakeTamanhoX()[1] = 75;
		this.snakeEscolhida.getSnakeTamanhoX()[0] = 100;

		this.snakeEscolhida.getSnakeTamanhoY()[2] = 100;
		this.snakeEscolhida.getSnakeTamanhoY()[1] = 100;
		this.snakeEscolhida.getSnakeTamanhoY()[0] = 100;

		this.direita = false;
		this.esquerda = false;
		this.cima = false;
		this.baixo = false;

		this.repaint();
	}

	public void atualizaFruto() {
		int valor = this.contadorThread % 10;
		if(valor < 4) {
			 this.frutos = new SimpleFruit();
		}
		else if(valor >= 4 && valor < 6) {
			this.frutos = new BigFruit();
		}
		else if(valor >= 6 && valor < 8) {
			this.frutos = new DecreaseFruit();
		}
		else {
			this.frutos = new BombFruit();
		}
		this.frutos.atualizaRandom();
		this.repaint();
		this.contadorThread = random.nextInt(100);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.tempo.start();

			//Jeito com classe
			if (this.direita) {
				for (int x = this.snakeEscolhida.getTamanhoSnake() - 1; x >= 0; x--) {
					this.snakeEscolhida.getSnakeTamanhoY()[x + 1] = this.snakeEscolhida.getSnakeTamanhoY()[x];
				}
				for (int x = this.snakeEscolhida.getTamanhoSnake(); x >= 0; x--) {
					if (x == 0) {
						this.snakeEscolhida.getSnakeTamanhoX()[x] = this.snakeEscolhida.getSnakeTamanhoX()[x] + 25;
					} else {
						this.snakeEscolhida.getSnakeTamanhoX()[x] = this.snakeEscolhida.getSnakeTamanhoX()[x - 1];
					}
					if (this.snakeEscolhida.getSnakeTamanhoX()[x] > 850) {
						this.snakeEscolhida.getSnakeTamanhoX()[x] = 25;
					}
				}
				this.repaint();
			}

			//Jeito com classe
			if (this.esquerda) {
				for (int x = this.snakeEscolhida.getTamanhoSnake() - 1; x >= 0; x--) {
					this.snakeEscolhida.getSnakeTamanhoY()[x + 1] = this.snakeEscolhida.getSnakeTamanhoY()[x];
				}
				for (int x = this.snakeEscolhida.getTamanhoSnake(); x >= 0; x--) {
					if (x == 0) {
						this.snakeEscolhida.getSnakeTamanhoX()[x] = this.snakeEscolhida.getSnakeTamanhoX()[x] - 25;
					} else {
						this.snakeEscolhida.getSnakeTamanhoX()[x] = this.snakeEscolhida.getSnakeTamanhoX()[x - 1];
					}
					if (this.snakeEscolhida.getSnakeTamanhoX()[x] < 25) {
						this.snakeEscolhida.getSnakeTamanhoX()[x] = 850;
					}
				}
				this.repaint();
			}

			//jeito com classe
			if (this.cima) {
				for (int x = this.snakeEscolhida.getTamanhoSnake() - 1; x >= 0; x--) {
					this.snakeEscolhida.getSnakeTamanhoX()[x + 1] = this.snakeEscolhida.getSnakeTamanhoX()[x];
				}
				for (int x = this.snakeEscolhida.getTamanhoSnake(); x >= 0; x--) {
					if (x == 0) {
						this.snakeEscolhida.getSnakeTamanhoY()[x] = this.snakeEscolhida.getSnakeTamanhoY()[x] - 25;
					} else {
						this.snakeEscolhida.getSnakeTamanhoY()[x] = this.snakeEscolhida.getSnakeTamanhoY()[x - 1];
					}
					if (this.snakeEscolhida.getSnakeTamanhoY()[x] < 75) {
						this.snakeEscolhida.getSnakeTamanhoY()[x] = 625;
					}
				}
				this.repaint();
			}

			//Jeito com classe
			if (this.baixo) {
				for (int x = this.snakeEscolhida.getTamanhoSnake() - 1; x >= 0; x--) {
					this.snakeEscolhida.getSnakeTamanhoX()[x + 1] = this.snakeEscolhida.getSnakeTamanhoX()[x];
				}
				for (int x = this.snakeEscolhida.getTamanhoSnake(); x >= 0; x--) {
					if (x == 0) {
						this.snakeEscolhida.getSnakeTamanhoY()[x] = this.snakeEscolhida.getSnakeTamanhoY()[x] + 25;
					} else {
						this.snakeEscolhida.getSnakeTamanhoY()[x] = this.snakeEscolhida.getSnakeTamanhoY()[x - 1];
					}
					if (this.snakeEscolhida.getSnakeTamanhoY()[x] > 625) {
						this.snakeEscolhida.getSnakeTamanhoY()[x] = 75;
						System.out.println("DEU LALALAL == " + x);
					}
				}
				this.repaint();
			}
	}

	public void gameOver(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("arial", Font.BOLD, 50));
		graphic.drawString("Game Over!", 300, 300);

		graphic.setFont(new Font("arial", Font.BOLD, 20));
		graphic.drawString("Espaço para RECOMEÇAR!", 315, 375);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.movimentos = 0;
			this.snakeEscolhida.resetPontos();
			this.snakeEscolhida.resetTamanhoSnake();
			this.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.movimentos++;
			this.direita = true;
			
			if(!this.esquerda) {
				this.direita = true;
			} else {
				this.direita = false;
				this.esquerda = true;
			}
			
			this.cima = false;
			this.baixo = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.movimentos++;
			this.esquerda = true;
			
			if(!this.direita) {
				this.esquerda = true;
			} else {
				this.esquerda = false;
				this.direita = true;
			}
			
			this.cima = false;
			this.baixo = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.movimentos++;
			this.cima = true;
			
			if(!this.baixo) {
				this.cima = true;
			} else {
				this.cima = false;
				this.baixo = true;
			}
			
			this.esquerda = false;
			this.direita = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.movimentos++;
			this.baixo = true;
			
			if(!this.cima) {
				this.baixo = true;
			} else {
				this.cima = true;
				this.baixo = false;
			}
			
			this.esquerda = false;
			this.direita = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
