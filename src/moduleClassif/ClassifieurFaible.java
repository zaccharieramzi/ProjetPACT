
package moduleClassif;


public class ClassifieurFaible {

	private int[] labels;
	// private static final String String = null;
	static int l, d; // représente le nombre de lignes et de colonnes
	private static int[] newlabels = new int[l];
	private double[][] matrixOfFeatures = new double[l][d]; // représente la matrice des features les
															// colonnes sont les
															// features. Je veux
															// faire une
															// concaténation des
															// colonnes
	private double[] weight; // représente les poids en entree
	double[] errorI;

	public ClassifieurFaible(double[] weight, double[][] matrixOfFeatures,
			int[] labels) {
		this.matrixOfFeatures = matrixOfFeatures;
		this.weight = weight;
		this.labels = labels;

		int i, j, p, index_threshold;
		String[] labelshape = null;
		String labelshapep;
		double Ep;
		

		for (j = 0; j < d; j++) {   //parcours les colonnes

			double[] coord = null;

			for (i = 0; i < l; i++) {  
				coord[i] = matrixOfFeatures[i][j];
			}

			Vector vector = new Vector(coord, labels);

			for (i = 0; i < l; i++) {    //parcours les lignes

				vector.counter1(i);
				vector.counter2(i);

				if (vector.counter1(i) > vector.counter2(i)) {

					for (p = 0; p < i; p++) {
						newlabels[p] = -1;
					}
					;
					for (p = i; p < l; p++) {
						newlabels[p] = 1;
					}
					;
					labelshape[i] = "right1";
				} else {
					for (p = 0; p < i; p++) {
						newlabels[p] = 1;
					}
					;
					for (p = i; p < l; p++) {
						newlabels[p] = -1;
					}
					;
					labelshape[i] = "left1";
				}
<<<<<<< HEAD
				
				errorI[i] = vector.error(weight, newlabels, labels);
				
				if(i!=1 && errorI[i]<errorI[i-1]){
					index_threshold = i;
					Ep = errorI[i];
					labelshapep = labelshape[i];
=======

				errorI[i] = vector.error(weight, newlabels, labels);

				if (errorI[i+1] < errorI[i]) {
					index_threshold_feature[j] = i; // renvoie l'indice du seuil
													// correspondant à l'erreur
													// minimum et le stocke dans
													// le taleau
													// index_threshold_feature
					error_feature[j] = errorI[i]; // renvoie l'erreur minimum de
													// la ligne i et le stocke
													// dans le tableau
													// Error_feature[p]
					labelshape_feature[j] = labelshape[i]; // renvoie le
															// labelshape
															// associé et le
															// stocke dans le
															// tableau
															// labelfeature[]
>>>>>>> parent of 5173d0d... rajout d'une virgule
				}
					
				
				}
			
			
		}
	}

	public double[][] getMatrixOfFeatures() {
		return matrixOfFeatures;
	}
	
	

}
