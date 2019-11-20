package ep2;

import java.awt.*;

import javax.swing.*;

public class TelaJogo {

	public static void playJogo(Snake snakeEscolhida) {
		//Jogabilidade jogabilidade = new Jogabilidade();
		//Jogabilidade jogabilidade = new Jogabilidade(snakeEscolhida);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
						JFrame frame = new JFrame();
						frame.setBounds(10, 10, 905, 700);
						frame.setBackground(Color.DARK_GRAY);
						frame.setResizable(false);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						Jogabilidade jogabilidade = new Jogabilidade(snakeEscolhida);
						System.out.println("comecou thread");
						frame.add(jogabilidade);
						frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("Acabou thread");
	}

}
