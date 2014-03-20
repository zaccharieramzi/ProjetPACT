package Jeu;

public class Score {

	private int tableau[] = new int[2];
	
	public Score(int i, int j) {
		this.tableau[0]=i;
		this.tableau[1]=j;
		// TODO Auto-generated constructor stub
	}

	
	public int getP1Score() {
		// TODO Auto-generated method stub
		return this.tableau[0];
	}

	
	public int getP2Score() {
		// TODO Auto-generated method stub
		return this.tableau[1];
	}

	
	public void setP1Score(int i) {
		// TODO Auto-generated method stub
		this.tableau[0]=i;
	}

	
	public void setP2Score(int i) {
		// TODO Auto-generated method stub
		this.tableau[1]=i;
	}

	
	public boolean limiteAtteinte(int x) {
		// TODO Auto-generated method stub
		return ((this.tableau[0]<x)&&(this.tableau[1]<x));
	}

}
