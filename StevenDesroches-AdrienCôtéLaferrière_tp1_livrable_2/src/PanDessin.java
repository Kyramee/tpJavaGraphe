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
	
	public PanDessin() {
		this.Fg = Color.WHITE;
		this.Bg = Color.WHITE;
		this.formeCourante = this.AUCUN;
		this.premierClic = null;
		this.liste = new ArrayList<>();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
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
		super.paintComponent(g);
		for (Forme forme : liste) {
			forme.tracer(g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if ( !this.liste.isEmpty() ) {
			this.liste.get(this.liste.size() - 1).setParametre(this.premierClic.getX(), e.getX(), this.premierClic.getY(), e.getY());
			this.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.premierClic = e;
		
		switch (this.formeCourante) {
		case RECT:
			this.liste.add(new Rectangle(e.getX(), e.getY(), this.Fg, this.Bg));
			break;
			
		case OVAL:
			this.liste.add(new Ovale(e.getX(), e.getY(), this.Fg, this.Bg));
			break;
			
		case TRAIT:
			this.liste.add(new Trait(e.getX(), e.getY(), this.Fg));
		default:
			break;
		}
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
