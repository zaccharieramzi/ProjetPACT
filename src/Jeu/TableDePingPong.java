package Jeu;

public class TableDePingPong  implements DecorInterface{

	private final double x;
	private final double y;
	private final double z;
	private boolean balleStaysInTheField=true;
	
	public TableDePingPong(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void Rebond(BalleInterface b) {
		// TODO Auto-generated method stub
		if (b.isAtLimitsY(this))
		{
			if (b.getY()<0)
			{
				double theta = b.getAngleTheta();
				b.setAngleTheta(theta-Math.PI/2);
				
			}
			else
			{
				double theta = b.getAngleTheta();
				b.setAngleTheta(theta+Math.PI/2);
			}
			
		}
		if (b.isAtLimitsZ(this))
		{
			
			
		}
		
	}

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
	public boolean getBalleStaysInTheField() {
		// TODO Auto-generated method stub
		return this.balleStaysInTheField;
	}

	@Override
	public void setBalleStaysInTheField(boolean position) {
		// TODO Auto-generated method stub
		this.balleStaysInTheField=position;
	}

}
