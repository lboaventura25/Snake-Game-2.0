package ep2;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLabel lblSnakeGameMenu;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel lblSelecioneOTipo;
	private JLabel lblSnakeComum;
	private JLabel lblSnakeKitty;
	private JLabel lblSnakeStar;
	private JButton btnSnakeComum;
	private JButton btnSnakeKitty;
	private JButton btnSnakeStar;
	private JLabel SimpleFruit;
	private JLabel BigFruit;
	private JLabel DecreaseFruit;
	private JLabel BombFruit;

	/**
	 * Criando JFrame do Menu Principal.
	 */
	public Menu() throws FontFormatException {
		setBackground(UIManager.getColor("Button.darkShadow"));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 900, 700);
		System.out.println("Criou frame");


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.darkShadow"));
		menuBar.setBounds(new Rectangle(20, 20, 20, 20));
		menuBar.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 10));
		setJMenuBar(menuBar);

		lblSnakeGameMenu = DefaultComponentFactory.getInstance().createTitle("Snake Game Menu 2.0 ");
		lblSnakeGameMenu.setFont(new Font("Dyuthi", Font.BOLD, 50));

		menuBar.add(lblSnakeGameMenu);

		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new LineBorder(new Color(99, 130, 191), 5));
		contentPane.setLayout(new GridLayout(3, 1));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(99, 130, 191), 0));
		panel.setLayout(new GridLayout(4,1));
		panel.setBackground(Color.lightGray);
		contentPane.add(panel);

		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(99, 130, 191), 8));
		panel1.setLayout(new GridLayout(1,3));
		contentPane.add(panel1, BorderLayout.CENTER);

		lblSelecioneOTipo = DefaultComponentFactory.getInstance().createTitle("Selecione o tipo Snake Game que deseja jogar:\n\n");
		lblSnakeComum = DefaultComponentFactory.getInstance().createLabel("- Snake Comum: Snake2.0 comum");
		lblSnakeKitty = DefaultComponentFactory.getInstance().createLabel("- Snake Kitty: Snake atravessa as barreiras do Jogo");
		lblSnakeStar = DefaultComponentFactory.getInstance().createLabel("- Snake Star: Snake ganha o dobro de pontos");
		lblSelecioneOTipo.setFont(new Font("DialogInput", Font.BOLD, 30));
		lblSnakeComum.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblSnakeKitty.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblSnakeStar.setFont(new Font("DialogInput", Font.BOLD, 20));
		panel.add(lblSelecioneOTipo, BorderLayout.CENTER);
		panel.add(lblSnakeComum, BorderLayout.CENTER);
		panel.add(lblSnakeKitty, BorderLayout.CENTER);
		panel.add(lblSnakeStar, BorderLayout.CENTER);

		btnSnakeComum = new JButton("                Snake Comum!                ");
		btnSnakeComum.setBorder(new LineBorder(UIManager.getColor("CheckBox.foreground"), 5));
		btnSnakeComum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSnakeComumAcao();
			}
		});
		panel1.add(btnSnakeComum);

		btnSnakeKitty = new JButton("                    Snake Kitty!                    ");
		btnSnakeKitty.setBorder(new LineBorder(UIManager.getColor("CheckBox.foreground"), 5));
		btnSnakeKitty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSnakeKittyAcao();
            }
        });
		panel1.add(btnSnakeKitty);

		btnSnakeStar = new JButton("Snake Star");
		btnSnakeStar.setBorder(new LineBorder(UIManager.getColor("CheckBox.foreground"), 5));
		btnSnakeStar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSnakeStarAcao();
            }
        });
		panel1.add(btnSnakeStar);

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,1));
		panel2.setBackground(Color.lightGray);
		contentPane.add(panel2, BorderLayout.CENTER);

		SimpleFruit = DefaultComponentFactory.getInstance().createLabel("- Fruto Laranja: adiciona um ao tamanho e aos pontos");
		BigFruit = DefaultComponentFactory.getInstance().createLabel("- Fruto Amarelo: adiciona o dobro de pontos e um de tamanho");
		DecreaseFruit = DefaultComponentFactory.getInstance().createLabel("- Fruto Verde: faz a cobra voltar ao tamanho inicial sem perder pontos");
		BombFruit = DefaultComponentFactory.getInstance().createLabel("- Fruto Cinza: Mata a cobra e faz ela aparecer na posição inicial");
		SimpleFruit.setFont(new Font("Dyuthi", Font.ITALIC, 25));
		BigFruit.setFont(new Font("Dyuthi", Font.ITALIC, 25));
		DecreaseFruit.setFont(new Font("Dyuthi", Font.ITALIC, 25));
		BombFruit.setFont(new Font("Dyuthi", Font.ITALIC, 25));
		panel2.add(SimpleFruit, BorderLayout.CENTER);
		panel2.add(BigFruit, BorderLayout.CENTER);
		panel2.add(DecreaseFruit, BorderLayout.CENTER);
		panel2.add(BombFruit, BorderLayout.CENTER);

	}

	private void btnSnakeComumAcao() {
		TelaJogo.playJogo(new SnakeComum());
	}

	private void btnSnakeKittyAcao() {
	    TelaJogo.playJogo(new SnakeKitty());
    }

    private void btnSnakeStarAcao() {
	    TelaJogo.playJogo(new SnakeStar());
    }

}
