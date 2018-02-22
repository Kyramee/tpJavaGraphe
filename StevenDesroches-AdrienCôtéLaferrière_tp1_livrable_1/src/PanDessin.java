import java.awt.Color;

import javax.swing.JPanel;

public class PanDessin extends JPanel {
	public final int TRAIT = 1;
	public final int RECT = 0;
	public final int OVAL = 2;
	public final int AUCUN = 3;
	
	private Color contour, remplissage;
	private int forme;
	
	public PanDessin() {
		this.contour = Color.WHITE;
		this.remplissage = Color.WHITE;
		this.forme = this.AUCUN;
	}
	
	public void setContour(Color c) {
		this.contour = c;
	}
	
	public void setRemplissage(Color c) {
		this.remplissage = c;
	}
	
	public void setForme(int forme) {
		this.forme = forme;
	}
}
