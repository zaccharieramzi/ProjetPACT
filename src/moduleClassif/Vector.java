package moduleClassif;

public class Vector implements VectorInterface {
	
	static int l ;

	private static int [] labels = new int[l];
	private double [] coord = new double[l];

	public Vector(double [] coord0, int [] labels0){
	
		labels = labels0 ;
		coord = coord0 ;
	
	}
	@Override
	public int[] getLabels(){
		return labels;
	}
	@Override
	public double [] getCoord(){
		return coord ;
	}
	@Override
	public void setCoord(double [] coord0){
		coord = coord0 ;
	}
	@Override
	public int counter1(int i){
		int counter1 = 0;	
		
		for(int j=0; j<i; j++) {
			
			if (labels[j]==-1) {
				counter1 ++ ;
			}
		}
		return counter1;
	}
	@Override
	public int counter2(int i){
		int counter2 = 0;	
		
		for(int j=i; j<l; j++) {
			
			if (labels[j]==-1) {
				counter2 ++ ;
			}
		}
		return counter2;
	}
	

	public double error( double[] weight, int[] newlabels, int[] labels){
		int i;
		double Err = 0;
		for(i=0; i<l; i++){
			if(newlabels[i]!=labels[i]) {
				Err = Err + weight[i]/l;
			}
		}
		return Err;
		
	}
	@Override
	public void setLabels(int[] labels0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int value() {
		// TODO Auto-generated method stub
		return 0;
	} 
}



/*public int counter2(int i){
	int counter2 = 0;	
	
	for(int j=0; j<i; j++) {
		
		if (labels[j]==false) {
			counter2 ++ ;
		}
	}
	
	return counter2;
	
}

public int counter1(int i){
	int counter1 = 0;	
	
	for(int j=i; j<d; j++) {
		
		if (labels[j]==true) {
			counter1 ++ ;
		}
	}

		return counter1;

}

public int value(){
	int value =  abs(counter2(1)-counter1(1));
	for(int i=0; i<d; i++) {	
           if (abs(counter2(i)-counter1(i))<value) {
			value = abs(counter2(i)-counter1(i)) ;
		}
	}
	return value ;
		}

private static int abs(int i) {
		if (i > 0) {
			return i;
		} else {
			return -i;
		}

	}

}
*/