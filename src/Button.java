import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Button extends JFrame implements ActionListener{
	private JPanel panSelect = new JPanel();
	private JLabel regles = new JLabel();
	
	public JButton quit = new JButton("QUITTER");
	public JButton play = new JButton("JOUER");
	
	public Button(){
		//paramètres fenêtre
		this.setTitle("PICSRUN");
		this.setSize(620, 550);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						
		this.setResizable(true);
		this.setVisible(true);
		
		//paramètre JLabel
		Font police = new Font("Georgia", Font.BOLD, 11);
		regles.setFont(police);
		regles.setForeground(Color.magenta);
		
		regles.setText("<html>Règle du jeu : Atteindre la ligne d'arrivée le premier. <p>"
				+ "Pour jouer, appuyer sur les flèches gauche et droite du clavier. </html>");
		
		//paramètre JPanel
		panSelect.setBackground(Color.white);
		panSelect.setLayout(null);
			
		//ajout du bouton, paramètre JButton
		play.setBounds(220, 235, 150, 25);
		panSelect.add(play);
		play.addActionListener(this);
		
		quit.setBounds(220, 200, 150, 25);
		panSelect.add(quit);
		quit.addActionListener(this);
		
		this.add(panSelect);
		this.add(regles, BorderLayout.NORTH);
		this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == play) {
			this.dispose();
			play.setEnabled(false);
			new Thread() {
				public void run() {
					try {
						new Partie();
					}
					
					finally {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
	                              play.setEnabled(true);
	                         }
						});
					}
				}
			}.start();			 
		}
		
		if(a.getSource() == quit){
			System.exit(0);
		}
		
	}

}
