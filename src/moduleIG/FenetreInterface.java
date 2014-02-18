package moduleIG;

import javax.swing.JFrame;

public interface FenetreInterface {
	public JFrame createWindow(String nameOfWindow);
	public void setWindow(int locationOfButton);
	public void closeWindow(JFrame windowToClose); //automatiquement
	public void openWindow(JFrame WindowToSetVisible);
}
