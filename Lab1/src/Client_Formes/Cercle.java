package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Cercle extends Ovale{
	private static final Color couleur = Color.CYAN;

	public Cercle(int numeroIDLogger, int centreX, int centreY, int rayon){
		super(numeroIDLogger, centreX, centreY, rayon, rayon);
	}

	public Shape dessinerForme() {
		return new Ellipse2D.Double(centreX, centreY, rayonH, rayonV);
	}

	public Color obtenirCouleur(){
		return couleur;
	}

}
