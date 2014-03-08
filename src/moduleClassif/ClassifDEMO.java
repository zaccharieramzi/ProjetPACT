package moduleClassif;


import java.util.Date;
import java.util.GregorianCalendar;

import Jeu.Manitou;
import moduleIntegration.*;

public class ClassifDEMO implements DescripteurClassificationInterface {
	
	int[] matrice ;
	private String chemin = "data\\ReproductionEXEC" ;
	private String message = "";
	Manitou manitou = new Manitou();
	private int counter0 = 0;
	private int counter1 = 0;
	
	GregorianCalendar calendar = new GregorianCalendar();
	
	public ClassifDEMO(){
		super();
	}
	
	@Override
	public void giveMatrix(int[] matrix) {
		this.matrice = matrix;
		
		Date time  = calendar.getTime();
		message = message+"matrice du descripteur envoyée à Classif  " + time;
		sendPosition();
	}
	
	public void sendPosition(){
		
		for(int i =0; i<matrice.length;i++){
			if(matrice[i]==0) counter0++;
			else counter1++;
		}
		if(counter0>=counter1){
			manitou.setDirectionP1(0);
			message=message+"\n DirectionP1 envoyée : 0\n";
			System.out.println("direction 0");
		}
		else {
			manitou.setDirectionP1(1);
			message=message+"\n DirectionP1 envoyée : 1\n";	
			System.out.println("direction 1");
		}
		ReproduireExec.ecrire(chemin, message);
	}
	
}
