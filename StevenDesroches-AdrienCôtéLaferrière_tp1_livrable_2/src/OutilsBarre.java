import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class OutilsBarre extends JToolBar {

	private static final long serialVersionUID = 1L;
	private final String[] tabCouleur = { "bleu", "rouge", "vert", "noir", "gris", "rose" };
	private final String[] tabNomForme = { "Carré", "Trait", "Ovale" };

	private ButtonGroup groupCouleurTrait, groupCouleurRemplissage, groupForme;
	private JToggleButton[] tabButtcouleurs = new JToggleButton[6], 
			tabForme = new JToggleButton[3],
			tabSceau = new JToggleButton[6];
	
	private PanDessin pd;

	public OutilsBarre(PanDessin pd) {
		super();
		this.pd = pd;
		insertionBoutons();
	}
	
	public JToggleButton[] getTabJBcouleur() {
		return this.tabButtcouleurs;
	}
	
	public JToggleButton[] getTabJBforme() {
		return this.tabForme;
	}
	
	public JToggleButton[] getTabJBsceau() {
		return this.tabSceau;
	}
	
	public ButtonGroup getGroupFormeRemplissage() {
		return this.groupCouleurRemplissage;
	}
	
	public ButtonGroup getGroupCouleurTrait() {
		return this.groupCouleurTrait;
	}

	public void insertionBoutons() {
		
		EcouteurBoutton ecouteur = new EcouteurBoutton(this, this.pd);
		
		groupCouleurTrait = new ButtonGroup();
		groupForme = new ButtonGroup();
		groupCouleurRemplissage = new ButtonGroup();

		boucleTableau( groupCouleurTrait, tabButtcouleurs, "Trait", "vide", ecouteur);
		boucleTableau( groupCouleurRemplissage, tabSceau, "sceau", "pleine", ecouteur);

		for ( int i = 0; i < tabForme.length; i++ ) {
			tabForme[i] = new JToggleButton( new ImageIcon( "src/images/" + tabNomForme[i] + ".png" ) );
			tabForme[i].setToolTipText( tabNomForme[i] );
			tabForme[i].addActionListener(ecouteur);
		}
		
		for ( JToggleButton jToggleButton : tabForme ) {
			groupForme.add( jToggleButton );
			add( jToggleButton );
		}

	}

	public void boucleTableau( ButtonGroup groupButton, JToggleButton[] groupeToggle, String nom, String type, EcouteurBoutton ecouteur ) {
		for ( int i = 0; i < groupeToggle.length; i++ ) {
			groupeToggle[i] = new JToggleButton( new ImageIcon( "src/images/" + nom + ( i + 1 ) + ".png" ) );
			groupeToggle[i].setToolTipText( "Forme " + type + " de couleur " + tabCouleur[i] );
			groupeToggle[i].addActionListener(ecouteur);
			groupButton.add( groupeToggle[i] );
			add( groupeToggle[i] );
		}
		addSeparator();
	}
}
