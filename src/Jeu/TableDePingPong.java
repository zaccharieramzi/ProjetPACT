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
	public void Rebond(Balle b) {
		// TODO Auto-generated method stub
		if (b.isAtLimitsY(this))
		{
			b.setDx(-b.getDx());
			
		}
		if (b.isAtLimitsZ(this))
		{
			
			b.setDz(-b.getDz());
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
