package Jeu;

public class Balle extends Tools {

	public Balle(double x, double y, double z, double dx,double dy, double dz,int radius) {
		super(x, y, z, dx,dy, dz);
		this.radius=radius;
		// TODO Auto-generated constructor stub
	}

	private int radius;
	
	public boolean staysInTheField(Raquette r) {
		// TODO Auto-generated method stub
		
		return (Math.abs(r.getY()-this.getY())<r.getWidth()/2);
	}

	
	public int getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}
	
	@Override
	public boolean isAtLimitsX(DecorInterface d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.getX())<d.getX()-this.getRadius());
	}

	@Override
	public boolean isAtLimitsY(DecorInterface d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.getY())<d.getY()-this.getRadius());
	}

	@Override
	public boolean isAtLimitsZ(DecorInterface d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.getZ())<d.getZ()-this.getRadius());
	}

	
}
