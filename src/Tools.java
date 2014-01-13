
public class Tools implements MovingObject {

	private double x;
	private double y;
	public Tools(double x, double y, double z, double theta,double phi, int v) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.theta = theta;
		this.v = v;
		this.phi=phi;
	}

	private double z;
	private double theta;
	private double phi;
	private int v;
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public double getZ() {
		// TODO Auto-generated method stub
		return this.z;
	}

	@Override
	public double getAngleTheta() {
		// TODO Auto-generated method stub
		return this.theta;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.v;
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x=x;
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y=y;
	}

	@Override
	public void setZ(double z) {
		// TODO Auto-generated method stub
		this.z=z;
	}

	@Override
	public void setAngleTheta(double theta) {
		// TODO Auto-generated method stub
		this.theta=theta;
	}

	@Override
	public void setSpeed(int v) {
		// TODO Auto-generated method stub
		this.v=v;
	}

	@Override
	public boolean isAtLimitsX(DecorInterface d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.x)<d.getX());
	}

	@Override
	public boolean isAtLimitsY(DecorInterface d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.y)<d.getY());
	}

	@Override
	public boolean isAtLimitsZ(DecorInterface d) {
		// TODO Auto-generated method stub
		return (Math.abs(this.z)<d.getZ());
	}

	@Override
	public double getAnglePhi() {
		// TODO Auto-generated method stub
		return this.phi;
	}

	@Override
	public void setAnglePhi(double phi) {
		// TODO Auto-generated method stub
		this.phi=phi;
	}

	@Override
	public void reInitialize() {
		// TODO Auto-generated method stub
		this.setX(0);
		this.setY(0);
		this.setZ(0);
		this.setAnglePhi(0);
		this.setAngleTheta(0);
	}

}
