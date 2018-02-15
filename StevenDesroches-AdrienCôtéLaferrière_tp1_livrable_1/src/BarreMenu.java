import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarreMenu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	private JMenu menuFichier;
	private JMenu menuAide;
	
	public BarreMenu() {
		super();
		menuFichier();
		menuAide();
		this.add( menuFichier );
		this.add( menuAide);
	}
	
	public void menuFichier() {
		this.menuFichier = new JMenu("Fichier");
		JMenuItem nouveau = new JMenuItem("Nouveau");
		JMenuItem enregistrer = new JMenuItem("Enregistrer");
		JMenuItem enregSous = new JMenuItem("Enregistrer-sous");
		JMenuItem ouvrir = new JMenuItem("Ouvrir");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		this.menuFichier.add(nouveau);
		this.menuFichier.add(enregistrer);
		this.menuFichier.add(enregSous);
		this.menuFichier.add(ouvrir);
		this.menuFichier.add(quitter);
	}
	
	public void menuAide() {
		this.menuAide = new JMenu("?");
		JMenuItem afficher = new JMenuItem("Afficher l'aide");
		JMenuItem aPropos = new JMenuItem("À propos de votre nom de logiciel");
		
		this.menuAide.add(afficher);
		this.menuAide.add(aPropos);
	}
}
