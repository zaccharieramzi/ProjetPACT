package moduleClassif;

public class ClassifieurFaible {
	
	static int p, d ; //represente le nombre de features et le nombre de composantes
	private static boolean [] newlabels = new boolean[d];
	
	//represente la matrice des features les colonnes sont les features. 
	//Je veux faire une concaténation des colonnes
	private Vector[] matrixOfFeatures = new Vector[p] ; 
	
	private double[] weight ; //represente les poids en entree
	
	public ClassifieurFaible(double[] weight, Vector[] matrixOfFeatures){
		this.matrixOfFeatures = matrixOfFeatures;
		this.weight = weight;
	}
	
	public Vector[] getMatrixOfFeatures(){
		return matrixOfFeatures;
	}
	
	
	public double error( double[] weight, boolean[] newlabels, boolean[] labels){
		int i;
		double Err = 0;
		for(i=0; i<d; i++){
			if(newlabels[i]!=labels[i]) {
				Err = Err + weight[i]/d;
			}
		}
		return Err;
		
	} //pas sur de ca..
	
	public void setNewLabels(){
		int i,j,k ;
		for(j=0; j<p;j++){
			for(i=0;i<d;i++){
				counter1(i);
				counter2(i);
				//Ã  finir
			}
		}
	}
	
	
	
	
}

