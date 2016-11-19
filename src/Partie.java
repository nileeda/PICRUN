import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Partie extends JFrame implements KeyListener{	
	
		private Panneau panPersos = new Panneau();
		private boolean stop = false;
		JLabel labelInfo = new JLabel();
		int debut = 0;
		int etatPartie = 0;
		int xSP=panPersos.getPosXSP();
		int ySP=panPersos.getPosYSP();
		int xVolt=panPersos.getPosXVolt();
		int yVolt=panPersos.getPosYVolt();
		
		public Partie(){			
			//paramètres fenêtre
			this.setTitle("PICSRUN");
			this.setSize(620, 550);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						
			this.setResizable(true);
			this.setVisible(true);
			this.addKeyListener(this);
			labelInfo.setText("Partie en cours...");

			this.add(panPersos);
			this.add(labelInfo,BorderLayout.SOUTH);
			
			gameloop();
		}
		
		private void gameloop(){
			startup();
					
				while(!stop) {				
					update();
					draw();
					pause();	
				}
			
			shutdown();		
		}
		
		
		private void startup() {
			etatPartie = 0;
			stop=false;
		}
		
		
		private void update() {
			// mets à jour la position du panneau{			
			xVolt=panPersos.getPosXVolt();
			yVolt=panPersos.getPosYVolt();
			xVolt=xVolt+1;
			panPersos.setPosXVolt(xVolt);
			panPersos.setPosYVolt(yVolt);
			
			if(etatPartie==1){			
				xSP=panPersos.getPosXSP();
				ySP=panPersos.getPosYSP();
				xSP=xSP+12;
				panPersos.setPosXSP(xSP);
				panPersos.setPosYSP(ySP);
				etatPartie=2;
			}
							
				if (xSP >= 600){
					labelInfo.setText("Tu as gagné !");
					stop = true;
				}
				
				else if(xVolt >= 600){
					labelInfo.setText("Dommage, tu as perdu...");
					stop = true;
				}
		}
		
		
		private void draw() {
			// redessinner le panneau
			panPersos.repaint();
		}
		
		
		private void pause() {
			// attendre le temps nécessaire
			try {
				Thread.sleep(10); //la pause en millième de s.
			}				
			catch (InterruptedException e){
				e.printStackTrace();
			}
			
		}

		private void shutdown() {
			// une fois la ligne dépassée arrêter le jeu + afficher temps/nb clic
			this.dispose();
			new Button();
		}

			public void keyPressed(KeyEvent e){
				if(etatPartie==0){
					if(e.getKeyCode() == e.VK_LEFT|| e.getKeyCode() == e.VK_RIGHT){
						etatPartie=1;
					}
				}
				else if (etatPartie==1) {
					if(e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_RIGHT){
						etatPartie=2;
					}
				}
				
			}

				@Override
				public void keyReleased(KeyEvent e) {
					//sert à ne pas avancer quand reste appuyé sur la touche
					if(etatPartie==1 || etatPartie==2){
						if(e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_RIGHT){
							etatPartie=0;
						}
					}
				}

				@Override
				public void keyTyped(KeyEvent e) {
					//chercher à quoi ça sert
				}
}