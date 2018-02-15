import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class OutilsBarre extends JToolBar {

	private static final long serialVersionUID = 1L;
	private final String[] tabCouleur = { "bleu", "rouge", "vert", "noir", "gris", "rose" };
	private final String[] tabNomForme = { "Carré", "Trait", "Ovale" };

	private ButtonGroup groupCouleurTrait, groupCouleurRemplissage, groupForme;
	private JToggleButton[] tabButtcouleurs = new JToggleButton[6], tabForme = new JToggleButton[3],
			tabSceau = new JToggleButton[6];

	public OutilsBarre() {
		super();
		insertionBoutons();
	}

	public void insertionBoutons() {

		groupCouleurTrait = new ButtonGroup();
		groupForme = new ButtonGroup();
		groupCouleurRemplissage = new ButtonGroup();

		boucleTableau( groupCouleurTrait, tabButtcouleurs, "Trait", "vide" );
		boucleTableau( groupCouleurRemplissage, tabSceau, "sceau", "pleine" );

		for ( int i = 0; i < tabForme.length; i++ ) {
			tabForme[i] = new JToggleButton( new ImageIcon( "src/images/" + tabNomForme[i] + ".png" ) );
			tabForme[i].setToolTipText( tabNomForme[i] );
		}

		for ( JToggleButton jToggleButton : tabForme ) {
			groupForme.add( jToggleButton );
			add( jToggleButton );
		}

	}

	public void boucleTableau( ButtonGroup groupButton, JToggleButton[] groupeToggle, String nom, String type ) {
		for ( int i = 0; i < groupeToggle.length; i++ ) {
			groupeToggle[i] = new JToggleButton( new ImageIcon( "src/images/" + nom + ( i + 1 ) + ".png" ) );
			groupeToggle[i].setToolTipText( "Forme " + type + " de couleur " + tabCouleur[i] );
			groupButton.add( groupeToggle[i] );
			add( groupeToggle[i] );
		}
		addSeparator();
	}
}
