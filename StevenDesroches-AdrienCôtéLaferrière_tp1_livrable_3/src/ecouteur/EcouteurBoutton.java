package ecouteur;

import java.awt.Color;
import graphique.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class EcouteurBoutton implements ActionListener {
	private OutilsBarre ob;
	private PanDessin pd;
	private final Color[] tabColor = { Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.GRAY, Color.PINK };
	private final float[] tabFloat = { 1.0f, 5.0f, 10.0f };

	public EcouteurBoutton(OutilsBarre ob, PanDessin pd) {
		this.ob = ob;
		this.pd = pd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean go = true;
		JToggleButton[] tab = this.ob.getTabJBcouleur();
		
		for (int i = 0; i < tab.length; i++) {
			if (e.getSource() == tab[i]) {
				this.pd.setContour(this.tabColor[i]);
				go = false;
				this.pd.setRemplissage( Color.WHITE );
				this.ob.getGroupFormeRemplissage().clearSelection();
				break;
			}
		}

		if (go) {
			tab = ob.getTabJBsceau();

			for (int i = 0; i < tab.length; i++) {
				if (e.getSource() == tab[i]) {
					this.pd.setRemplissage(this.tabColor[i]);
					go = false;
					this.pd.setContour(this.tabColor[i]);
					this.ob.getGroupCouleurTrait().clearSelection();
					break;
				}
			}
		}

		if (go) {
			tab = ob.getTabJBforme();

			for (int i = 0; i < tab.length; i++) {
				if (e.getSource() == tab[i]) {
					this.pd.setForme(i);
					go = false;
					break;
				}
			}
		}
		
		if (go) {
			tab = ob.getTabBrush();
			for (int i = 0; i < tab.length; i++) {
				if(e.getSource() == tab[i]) {
					this.pd.setBrush(this.tabFloat[i]);
					break;
				}
			}
		}
	}
}
