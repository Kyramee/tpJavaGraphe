import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

public class EcouteurMenu implements ActionListener {
	private JMenu menuFichier;
	private JMenu menuAide;
	private PanDessin pd;

	public EcouteurMenu(JMenu ficher, JMenu aide, PanDessin pd) {
		this.menuFichier = ficher;
		this.menuAide = aide;
		this.pd = pd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean go = true;
		int compte = this.menuFichier.getItemCount();

		for (int i = 0; i < compte; i++) {
			if (e.getSource() == this.menuFichier.getItem(i)) {
				actionListe(i);
				go = false;
				break;
			}
		}

		if (go) {
			compte = this.menuAide.getItemCount();

			for (int i = 0; i < compte; i++) {
				if (e.getSource() == this.menuAide.getItem(i)) {
					actionListe(i + this.menuFichier.getItemCount());
					break;
				}
			}
		}
	}

	public void actionListe(int index) {
		switch (index) {
		case 0:
			if (!this.pd.isSauvegarder() && JOptionPane.showConfirmDialog(null,
					" la feuille de dessin en cours n�a pas encore �t� sauvegard�e\nVoulez-vous enregistrer?",
					"Syst�me", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				FileNameEmpty();
				this.pd.setFileName("");
			}
			this.pd.getListeForme().clear();
			this.pd.repaint();
			break;
		case 1:
			FileNameEmpty();
			break;
		case 2:
			sauvegarderSous();
			break;
		case 3:
			Ouvrir();
			break;
		case 4:
			int rep = JOptionPane.showConfirmDialog(null, "�tes-vous sure de vouloir fermer l'application?",
					"Fermeture de l'application", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (rep == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "� la prochaine", "Syst�me", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			break;
		case 5:

			break;
		case 6:

			break;
		default:
			break;
		}
	}

	public void sauvegarderSous() {
		JFileChooser choix = new JFileChooser();
		if (choix.showSaveDialog(this.pd) == JFileChooser.APPROVE_OPTION) {
			String file = choix.getSelectedFile().getAbsolutePath();
			this.pd.setFileName((file.matches(".*\\.pnt$")) ? file : file + ".pnt");

			sauvegarder();
		}
	}

	public void sauvegarder() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.pd.getFileName()))) {
			oos.writeObject(this.pd);
			JOptionPane.showMessageDialog(null, "Painture sauvegard�", "Syst�me", JOptionPane.PLAIN_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.pd.setSaugarder(true);
	}

	public void FileNameEmpty() {
		if (this.pd.getFileName().isEmpty()) {
			sauvegarderSous();
		} else {
			sauvegarder();
		}
	}

	public void Ouvrir() {
		JFileChooser choix = new JFileChooser();
		if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(choix.getSelectedFile().getAbsolutePath()))) {
				this.pd.setListeForme(((PanDessin) ois.readObject()).getListeForme());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
