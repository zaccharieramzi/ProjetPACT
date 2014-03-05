package Jeu;

public class Score implements ScoreInterface{

	private int tableau[] = new int[2];
	
	public Score(int i, int j) {
		this.tableau[0]=i;
		this.tableau[1]=j;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getP1Score() {
		// TODO Auto-generated method stub
		return this.tableau[0];
	}

	@Override
	public int getP2Score() {
		// TODO Auto-generated method stub
		return this.tableau[1];
	}

	@Override
	public void setP1Score(int i) {
		// TODO Auto-generated method stub
		this.tableau[0]=i;
	}

	@Override
	public void setP2Score(int i) {
		// TODO Auto-generated method stub
		this.tableau[1]=i;
	}

	@Override
	public boolean limiteAtteinte(int x) {
		// TODO Auto-generated method stub
		return ((this.tableau[0]<x)&&(this.tableau[1]<x));
	}

}
