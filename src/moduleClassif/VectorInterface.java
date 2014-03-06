package moduleClassif;

public interface VectorInterface{
	
	public boolean [] getLabels();
	public void setLabels(boolean [] labels0);
	public int [] getCoord();
	public void setCoord(int [] coord0);
	public  int counter2(int i);
	public  int counter1(int i);
	public  int value(); //renvoie le minimum de |counter1(i)-counter2(i)|
	

}
