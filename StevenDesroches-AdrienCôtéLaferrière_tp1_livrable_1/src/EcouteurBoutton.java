import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class EcouteurBoutton implements ActionListener {
	private OutilsBarre ob;
	private PanDessin pd;

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
				setCouleurContour(i);
				go = false;
				break;
			}
		}

		if (go) {
			tab = ob.getTabJBsceau();

			for (int i = 0; i < tab.length; i++) {
				if (e.getSource() == tab[i]) {
					setCouleurRemplissage(i);
					go = false;
					break;
				}
			}
		}

		if (go) {
			tab = ob.getTabJBforme();

			for (int i = 0; i < tab.length; i++) {
				if (e.getSource() == tab[i]) {
					setForme(i);
					go = false;
					break;
				}
			}
		}
	}

	public void setCouleurContour(int index) {

		switch (index) {
		case 0:
			this.pd.setContour(Color.BLUE);
			break;
		case 1:
			this.pd.setContour(Color.RED);
			break;
		case 2:
			this.pd.setContour(Color.GREEN);
			break;
		case 3:
			this.pd.setContour(Color.BLACK);
			break;
		case 4:
			this.pd.setContour(Color.GRAY);
			break;
		case 5:
			this.pd.setContour(Color.PINK);
			break;
		}
	}

	public void setCouleurRemplissage(int index) {
		switch (index) {
		case 0:
			this.pd.setRemplissage(Color.BLUE);
			break;
		case 1:
			this.pd.setRemplissage(Color.RED);
			break;
		case 2:
			this.pd.setRemplissage(Color.GREEN);
			break;
		case 3:
			this.pd.setRemplissage(Color.BLACK);
			break;
		case 4:
			this.pd.setRemplissage(Color.GRAY);
			break;
		case 5:
			this.pd.setRemplissage(Color.PINK);
			break;
		}
	}

	public void setForme(int index) {
		switch (index) {
		case 0:
			this.pd.setForme(this.pd.RECT);
			break;
		case 1:
			this.pd.setForme(this.pd.TRAIT);
			break;
		case 2:
			this.pd.setForme(this.pd.OVAL);
			break;
		}
	}
}
