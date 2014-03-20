package Jeu;

public interface MovingObject {
public double getX();
public double getY();
public double getZ();
public double getDx();
public double getDy();
public double getDz();
public void setX(double x);
public void setY(double y);
public void setZ(double z);
public void setDx(double dx);
public void setDy(double dy);
public void setDz(double dz);
public boolean isAtLimitsX(DecorInterface d);
public boolean isAtLimitsY(DecorInterface d);
public boolean isAtLimitsZ(DecorInterface d);
public void reInitialize();
public void move();

}
