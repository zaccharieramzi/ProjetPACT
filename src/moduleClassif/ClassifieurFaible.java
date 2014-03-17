package moduleClassif;


public class ClassifieurFaible {

	private int[] labels;
	// private static final String String = null;
	static int l = 3, d = 3; // représente le nombre de lignes et de colonnes
	private static int[] newlabels = new int[l];
	private double[][] matrixOfFeatures = new double[l][d]; // représente la matrice des features les
															// colonnes sont les
															// features. Je veux
															// faire une
															// concaténation des
															// colonnes
	private double[] weight; // représente les poids en entree
	double[] errorI;
	private double error_best;
	private String labelshape_best;  //labelshape lié au seuil du meilleur feature
	private int index_threshold_best; //indice du seuil liée au meilleur feature
	
	public ClassifieurFaible(double[] weight, double[][] matrixOfFeatures,
			int[] labels) {
		this.matrixOfFeatures = matrixOfFeatures;
		this.weight = weight;
		this.labels = labels;

		int i, j, p;
		String[] labelshape = null;
		int[] index_threshold_feature = null;
		double[] error_feature = null;
		String[] labelshape_feature = null;
		
		
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


				errorI[i] = vector.error(weight, newlabels, labels);

				if (errorI[i] < errorI[i-1]) {
				
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

				}


				}
			
			error_best = error_feature[0];
			setLabelshape_best(labelshape_feature[0]);
			index_threshold_best = index_threshold_feature[0];
			
			if(error_feature[j]<error_feature[j-1]) {
				
				
				error_best = error_feature[j];
				setLabelshape_best(labelshape_feature[j]);
				index_threshold_best = index_threshold_feature[j];
				
			}


			}
		}

	public double getError_best() {
		return error_best;
	}

	public void setError_best(double error_best) {
		this.error_best = error_best;
	}

	public int getIndex_threshold_best() {
		return index_threshold_best;
	}

	public void setIndex_threshold_best(int index_threshold_best) {
		this.index_threshold_best = index_threshold_best;
	}

	public String getLabelshape_best() {
		return labelshape_best;
	}

	public void setLabelshape_best(String labelshape_best) {
		this.labelshape_best = labelshape_best;
	}
	



}
