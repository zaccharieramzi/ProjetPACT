package Jeu;

public class Raquette extends Tools implements RaquetteInterface {
	

	private int width;
	public Raquette(double x, double y, double z, int v, int width) {
		super(x, y, z, 0,0, v);
		this.width=width;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Rebond(BalleInterface b) {
		// TODO Auto-generated method stub
		//a modifier
		b.setAnglePhi(b.getAnglePhi());
		b.setAngleTheta(b.getAngleTheta());
	}
	
	@Override
	public boolean isAtLimitsY(DecorInterface d){
		return ((this.getY()+this.width/2>d.getY()/2)||(this.getY()-this.width/2<d.getY()/2));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
