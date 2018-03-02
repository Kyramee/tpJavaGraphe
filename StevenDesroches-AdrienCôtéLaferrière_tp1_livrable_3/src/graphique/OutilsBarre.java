package graphique;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import ecouteur.EcouteurBoutton;

public class OutilsBarre extends JToolBar {

	private static final long serialVersionUID = 1L;
	private final String[] tabCouleur = { "bleu", "rouge", "vert", "noir", "gris", "rose" };
	private final String[] tabNomForme = { "Carré", "Trait", "Ovale" ,"Triangle" };
	private final String[] tabNomBrush = { "Petit", "Moyen", "Grand" };

	private ButtonGroup groupCouleurTrait, groupCouleurRemplissage, groupForme, groupBrush;
	private JToggleButton[] tabButtcouleurs = new JToggleButton[6], 
			tabForme = new JToggleButton[4],
			tabSceau = new JToggleButton[6],
			tabToggleBrush = new JToggleButton[3];

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
	
	public JToggleButton[] getTabBrush() {
		return this.tabToggleBrush;
	}
	
	public ButtonGroup getGroupFormeRemplissage() {
		return this.groupCouleurRemplissage;
	}
	
	public ButtonGroup getGroupCouleurTrait() {
		return this.groupCouleurTrait;
	}

	public void insertionBoutons(PanDessin pd) {
		
		EcouteurBoutton ecouteur = new EcouteurBoutton(this, pd);
		
		this.groupCouleurTrait = new ButtonGroup();
		this.groupForme = new ButtonGroup();
		this.groupCouleurRemplissage = new ButtonGroup();
		this.groupBrush = new ButtonGroup();

		boucleTableau( this.groupCouleurTrait, this.tabButtcouleurs, "Trait", "vide", ecouteur);
		boucleTableau( this.groupCouleurRemplissage, this.tabSceau, "sceau", "pleine", ecouteur);
		boucleTableau(this.groupForme, this.tabForme, this.tabNomForme, ecouteur);
		boucleTableau(this.groupBrush, this.tabToggleBrush, this.tabNomBrush, ecouteur);	
	}

	public void boucleTableau( ButtonGroup groupButton, JToggleButton[] groupeToggle, String nom, String type, EcouteurBoutton ecouteur ) {
		for ( int i = 0; i < groupeToggle.length; i++ ) {
			groupeToggle[i] = new JToggleButton( new ImageIcon( "src/images/" + nom + ( i + 1 ) + ".png" ) );
			groupeToggle[i].setToolTipText( "Forme " + type + " de couleur " + tabCouleur[i] );
			groupeToggle[i].addActionListener(ecouteur);
			groupButton.add( groupeToggle[i] );
			this.add( groupeToggle[i] );
		}
		this.addSeparator();
	}
	
	public void boucleTableau(ButtonGroup groupButton, JToggleButton[] groupToggle, String[] nom, EcouteurBoutton ecouteur) {
		for ( int i = 0; i < groupToggle.length; i++ ) {
			groupToggle[i] = new JToggleButton( new ImageIcon( "src/images/" + nom[i] + ".png" ) );
			groupToggle[i].setToolTipText( nom[i] );
			groupToggle[i].addActionListener(ecouteur);
			groupButton.add(groupToggle[i]);
			this.add(groupToggle[i]);
		}
		this.addSeparator();
	}
}
