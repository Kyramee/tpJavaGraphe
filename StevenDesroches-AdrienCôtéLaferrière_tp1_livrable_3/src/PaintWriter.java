
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class PaintWriter {
	
	public void save(PanDessin paint, String filePath) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
			oos.writeObject(paint);
			JOptionPane.showMessageDialog(null, "Painture sauvegardé", "Système", JOptionPane.PLAIN_MESSAGE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
