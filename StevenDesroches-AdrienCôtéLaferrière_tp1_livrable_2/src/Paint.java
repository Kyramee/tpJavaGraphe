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
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ImageIcon iconeFenetre = new ImageIcon("src/images/Logo.png");
		setIconImage(iconeFenetre.getImage());
		
		this.menuBar = new BarreMenu();
		this.panelDessin = new PanDessin();
		this.outilsBar = new OutilsBarre(this.panelDessin);
		getContentPane().add( this.panelDessin );
		setJMenuBar( this.menuBar );
		add( this.outilsBar, BorderLayout.SOUTH );
	}
	
	public static void main(String[] args) {
		Paint f = new Paint();
		f.setVisible( true );
	}
}
