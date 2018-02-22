import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanDessin extends JPanel implements MouseListener, MouseMotionListener {
	static final int TRAIT = 1;
	static final int RECT = 0;
	static final int OVAL = 2;
	static final int AUCUN = 3;
	
	private Color Fg, Bg;
	private int formeCourante;
	
	private MouseEvent premierClic;
	
	private ArrayList<Forme> liste;
	private Forme temp = null;
	
	public PanDessin() {
		this.Fg = Color.WHITE;
		this.Bg = Color.WHITE;
		this.formeCourante = this.AUCUN;
		this.premierClic = null;
		this.liste = new ArrayList<>();
	}
	
	public void setContour(Color c) {
		this.Fg = c;
	}
	
	public void setRemplissage(Color c) {
		this.Bg = c;
	}
	
	public void setForme(int forme) {
		this.formeCourante = forme;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Rectangle r = new Rectangle(10, 20, 10, 25, Color.RED, Color.RED);
		r.tracer(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
