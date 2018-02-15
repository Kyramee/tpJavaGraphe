import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Paint extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelDessin;
	private JToolBar outilsBar;
	private JMenuBar menuBar;

	public Paint() {
		super("Paint");
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		ImageIcon iconeFenetre = new ImageIcon("src/images/Logo.png");
		setIconImage(iconeFenetre.getImage());
		
		menuBar = new BarreMenu();
		outilsBar = new OutilsBarre();
		panelDessin = new ZoneDessin();
		getContentPane().add( panelDessin );
		setJMenuBar( menuBar );
		add( outilsBar, BorderLayout.SOUTH );
	}
	
	public static void main(String[] args) {
		Paint f = new Paint();
		f.setVisible( true );
	}
}
