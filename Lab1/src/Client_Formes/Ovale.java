package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ovale extends Forme{
	private static final Color couleur = Color.BLUE;

	protected int centreX;
	protected int centreY;
	protected int rayonH;
	protected int rayonV;

	public Ovale(int numeroIDLogger, int centreX, int centreY, int rayonH, int rayonV){
		super(numeroIDLogger);
		this.centreX = centreX;
		this.centreY = centreY;
		this.rayonH = rayonH;
		this.rayonV = rayonV;
		super.definirDessin(dessinerForme());
	}

	public Shape dessinerForme() {
		return new Ellipse2D.Double(centreX, centreY, rayonH, rayonV);
	}

	public Color obtenirCouleur(){
		return couleur;
	}
}
