import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

	public class Panneau extends JPanel {
		private int posXSP = 5;
		private int posYSP = 130;
		private int posXVolt = 5;
		private int posYVolt = 250;
		
		private int backgroundX = 0;
		private int backgroundY = 0;
				
		public void paintComponent(Graphics g){			
			super.paintComponent(g);
			
			try{
				Image img = ImageIO.read(new File("pictures/Background.png"));
				g.drawImage(img, backgroundX, backgroundY, this);
			}
			
			catch (Exception e){
				e.printStackTrace();
			}
			
			try { 
				Image img = ImageIO.read(new File("pictures/volt2.png"));
				g.drawImage(img, posXVolt, posYVolt, this);
			}
			
			catch (Exception e){
				e.printStackTrace();
			}
			
			try { 
				Image img = ImageIO.read(new File("pictures/SPAnim2.gif"));
				g.drawImage(img, posXSP, posYSP, this);
			}
			
			catch (Exception e){
				e.printStackTrace();
			}
  }
		
		public int getPosXVolt() {
			return posXVolt;
  }
		
		public void setPosXVolt(int posXVolt) {
			this.posXVolt = posXVolt;
  }
		
		public int getPosYVolt() {
			return posYVolt;
  }
		
		public void setPosYVolt(int posYVolt) {
			this.posYVolt = posYVolt;
  }   
		
		public int getPosXSP() {
			return posXSP;
  }
		
		public void setPosXSP(int posXSP) {
			this.posXSP = posXSP;
  }
		
		public int getPosYSP() {
			return posYSP;
  }
		
		public void setPosYSP(int posYSP) {
			this.posYSP = posYSP;
  }     
		
}