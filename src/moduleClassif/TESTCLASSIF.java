package moduleClassif;


public class TESTCLASSIF {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] matrix = new int[5];
		matrix[0]=1;
		matrix[1]=0;
		matrix[2]=0;
		matrix[3]=0;
		matrix[4]=1;
		ClassifDEMO classifier = new ClassifDEMO();
		
		classifier.giveMatrix(matrix);
	}

}
