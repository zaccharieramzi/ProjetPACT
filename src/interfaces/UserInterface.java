package interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserInterface implements GraphicInterface{

	@Override
	public JFrame instanceOfWindow(String name) {
		// TODO Auto-generated method stub
<<<<<<< HEAD:src/interfaces/Graphics.java
		JFrame window = new JFrame(name);
		window.setVisible(true);
		window.setSize(5, 5);
		return window;
=======
		return null;
>>>>>>> refs/remotes/ProjetPACT/master:src/interfaces/UserInterface.java
	}

	@Override
	public void clickBehavior(Object action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JButton instanceOfButton(String textOnButton) {
		// TODO Auto-generated method stub
		return null;
	}

}
