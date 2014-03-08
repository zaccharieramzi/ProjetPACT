package moduleClassif;

import moduleIntegration.*;

public class ClassifDEMO implements DescripteurClassificationInterface {
	
	int[] matrice ;
	static String chemin = "src\\data\\fichierClassif";
	static String message= "";
	
	
	public ClassifDEMO(){
		super();
	}
	
	@Override
	public void giveMatrix(int[] matrix) {
		this.matrice = matrix;
		message = message+"matrice du descripteur récupérée";
	}
	
	public static void main(String[] args){
		Test.ecrire(chemin, message);
	}
}
