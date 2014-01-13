
public class Balle extends Tools implements BalleInterface{

	public Balle(double x, double y, double z, double theta,double phi, int v,int radius) {
		super(x, y, z, theta,phi, v);
		this.radius=radius;
		// TODO Auto-generated constructor stub
	}

	private int radius;
	@Override
	public boolean staysInTheField(RaquetteInterface r) {
		// TODO Auto-generated method stub
		
		return (Math.abs(r.getY()-this.getY())<r.getWidth()/2);
	}

	@Override
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
