package graphique;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import ecouteur.EcouteurBoutton;

public class OutilsBarre extends JToolBar {

	private static final long serialVersionUID = 1L;
	private final String[] tabCouleur = { "bleu", "rouge", "vert", "noir", "gris", "rose" };
	private final String[] tabNomForme = { "Carré", "Trait", "Ovale" };

	private ButtonGroup groupCouleurTrait, groupCouleurRemplissage, groupForme, groupBrush;
	private JToggleButton[] tabButtcouleurs = new JToggleButton[6], 
			tabForme = new JToggleButton[3],
			tabSceau = new JToggleButton[6];
	private static JToggleButton[] tabToggleBrush = new JToggleButton[3];

	public OutilsBarre(PanDessin pd) {
		super();
		insertionBoutons(pd);
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

	public void insertionBoutons(PanDessin pd) {
		
		EcouteurBoutton ecouteur = new EcouteurBoutton(this, pd);
		
		groupCouleurTrait = new ButtonGroup();
		groupForme = new ButtonGroup();
		groupCouleurRemplissage = new ButtonGroup();
		groupBrush = new ButtonGroup();

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

		addSeparator();
		
		groupBrush = new ButtonGroup();
		tabToggleBrush[0] = new JToggleButton("Petit");
		tabToggleBrush[1] = new JToggleButton("Moyen");
		tabToggleBrush[2] = new JToggleButton("Grand");
		
		for ( int i = 0; i < tabToggleBrush.length; i++ ) {
			groupBrush.add( tabToggleBrush[i] );
			add(tabToggleBrush[i]);
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
	
	public static float verification() {
		float valeur;
		if ( tabToggleBrush[2].isSelected() ) {
			valeur = 10.0f;
		} else if ( tabToggleBrush[1].isSelected() ) {
			valeur = 5.0f;
		} else {
			valeur = 1.0f;
		}
		
		return valeur;
	}
}
