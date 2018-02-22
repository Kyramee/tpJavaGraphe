import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class BarreMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu menuFichier;
	private JMenu menuAide;

	public BarreMenu() {
		super();
		menuFichier();
		menuAide();
		this.add(menuFichier);
		this.add(menuAide);
	}

	public void menuFichier() {
		this.menuFichier = new JMenu("Fichier");
		this.menuFichier.setMnemonic(KeyEvent.VK_F);

		initialise(this.menuFichier, KeyEvent.VK_N, "Nouveau");
		initialise(this.menuFichier, KeyEvent.VK_S, "Enregistrer");
		initialise(this.menuFichier, KeyEvent.VK_E, "Enregistrer-sous");
		initialise(this.menuFichier, KeyEvent.VK_O, "Ouvrir");
		initialise(this.menuFichier, KeyEvent.VK_Q, "Quitter");
	}

	public void menuAide() {
		this.menuAide = new JMenu("?");
		this.menuAide.setMnemonic(KeyEvent.VK_H);
		initialise(this.menuAide, KeyEvent.VK_A, "Afficher l'aide");
		initialise(this.menuAide, KeyEvent.VK_P, "� propos de votre nom de logiciel");
	}

	public void initialise(JMenu menu, int key, String nom) {
		JMenuItem jI = new JMenuItem(nom);
		jI.setMnemonic(key);
		jI.setAccelerator(KeyStroke.getKeyStroke(key, KeyEvent.CTRL_DOWN_MASK));
		menu.add(jI);
	}
}