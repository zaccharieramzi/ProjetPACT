package Jeu;

public class Tools implements MovingObject {

	private double x;
	private double y;
	public Tools(double x, double y, double z, double dx ,double dy, double dz) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.dx=dx;
		this.dy=dy;
		this.dz=dz;
		
	}

	private double z;
	private double dx;
	private double dy;
	private double dz;
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
	public double getDx() {
		// TODO Auto-generated method stub
		return this.dx;
	}

	@Override
	public double getDy() {
		// TODO Auto-generated method stub
		return this.dy;
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
	public void setDx(double dx) {
		// TODO Auto-generated method stub
		this.dx=dx;
	}

	@Override
	public void setDy(double dy) {
		// TODO Auto-generated method stub
		this.dy=dy;
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
	public double getDz() {
		// TODO Auto-generated method stub
		return this.dz;
	}

	@Override
	public void setDz(double dz) {
		// TODO Auto-generated method stub
		this.dz=dz;
	}

	@Override
	public void reInitialize() {
		// TODO Auto-generated method stub
		this.setX(0);
		this.setY(0);
		this.setZ(0);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.x=+this.dx;
		this.y=+this.dy;
		this.z=+this.dz;
	}

}
