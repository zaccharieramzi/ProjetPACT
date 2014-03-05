
public class Vector implements VectorInterface {
	
static int d ;

private static boolean [] labels = new boolean[d];
private int [] coord = new int[d];

public Vector(int [] coord0, boolean [] labels0){
	
	labels = labels0 ;
	coord = coord0 ;
	
}
public boolean [] getLabels(){
	return labels;
}

public void setLabels(boolean [] labels0){
	labels = labels0 ;
}
public int [] getCoord(){
	return coord ;
}

public void setCoord(int [] coord0){
	coord = coord0 ;
}

public int counter2(int i){
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