package moduleClassif;

public interface VectorInterface{
	
	public int [] getLabels();
	public void setLabels(int [] labels0);
	public double [] getCoord();
	public void setCoord(double [] coord0);
	public  int counter2(int i);
	public  int counter1(int i);
	public  int value(); //renvoie le minimum de |counter1(i)-counter2(i)|
	

}
