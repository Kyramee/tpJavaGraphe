package graphique;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Paint extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanDessin panelDessin;
	private OutilsBarre outilsBar;
	private BarreMenu menuBar;

	public Paint() {
		super("Paint");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		ImageIcon iconeFenetre = new ImageIcon("src/images/Logo.png");
		this.setIconImage(iconeFenetre.getImage());
		
		this.panelDessin = new PanDessin();
		this.menuBar = new BarreMenu(this.panelDessin, this);
		this.outilsBar = new OutilsBarre(this.panelDessin);
		this.getContentPane().add( this.panelDessin );
		this.setJMenuBar( this.menuBar );
		this.add( this.outilsBar, BorderLayout.SOUTH );
	}
	
	public static void main(String[] args) {
		Paint f = new Paint();
		f.setVisible( true );
	}
}
