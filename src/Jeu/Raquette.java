package Jeu;

public class Raquette extends Tools {
	

	private double width;
	public Raquette(double x, double y, double z, double width) {
		super(x, y, z, 0,3,0);
		this.width=width;
		// TODO Auto-generated constructor stub
	}

	public void Rebond(Balle b) {
		// TODO Auto-generated method stub
		b.setDy(-b.getDy());
	}
	
	@Override
	public boolean isAtLimitsY(DecorInterface d){
		return ((this.getY()+this.width/2>d.getY()/2)||(this.getY()-this.width/2<d.getY()/2));
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

}
