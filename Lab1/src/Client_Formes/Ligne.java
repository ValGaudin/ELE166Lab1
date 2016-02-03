package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class Ligne extends Forme{
	private static final Color couleur = Color.BLACK;
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;

	public Ligne(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		super.definirDessin(dessinerForme());
	}

	public Shape dessinerForme() {
		return new Line2D.Double(x1, x2, y1, y2);
	}
	
	public Color obtenirCouleur(){
		return couleur;
	}
}
