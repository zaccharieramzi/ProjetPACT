package Jeu;

public interface Controleur {
void lancerJeu() throws InterruptedException;
void setDirectionP1(int direction);
void setDirectionP2(int direction);
void setSpeed(int vitesse);
Balle getBalle();
Raquette getRaquetteP1();
Raquette getRaquetteP2();

}
