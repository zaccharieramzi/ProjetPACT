package moduleClassif;

public class Vector implements VectorInterface {
	
	static int l ;

	private static boolean [] labels = new boolean[l];
	private int [] coord = new int[l];

	public Vector(int [] coord0, boolean [] labels0){
	
		labels = labels0 ;
		coord = coord0 ;
	
	}
	@Override
	public boolean [] getLabels(){
		return labels;
	}
	@Override
	public void setLabels(boolean [] labels0){
		labels = labels0 ;
	}
	@Override
	public int [] getCoord(){
		return coord ;
	}
	@Override
	public void setCoord(int [] coord0){
		coord = coord0 ;
	}
	@Override
	public int counter1(int i){
		int counter1 = 0;	
		
		for(int j=0; j<i; j++) {
			
			if (labels[j]==false) {
				counter1 ++ ;
			}
		}
		return counter1;
	}
	@Override
	public int counter2(int i){
		int counter2 = 0;	
		
		for(int j=i; j<l; j++) {
			
			if (labels[j]==false) {
				counter2 ++ ;
			}
		}
		return counter2;
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