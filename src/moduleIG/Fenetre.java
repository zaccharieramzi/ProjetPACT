package moduleIG;

import javax.swing.JFrame;

public class Fenetre implements FenetreInterface {

	@Override
	public JFrame createWindow(String nameOfWindow) {
		JFrame window = new JFrame(nameOfWindow) ;
		return window;
	}

	@Override
	public void setWindow(int locationOfButton) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeWindow(JFrame windowToClose) {
		windowToClose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void openWindow(JFrame WindowToSetVisible) {
		WindowToSetVisible.setVisible(true) ;
		
	}

}
