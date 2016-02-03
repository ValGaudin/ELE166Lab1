package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Forme{
	private static final Color couleur = Color.RED;
	
	protected int x1 = 0;
	protected int y1 = 0;
	protected int x2 = 0;
	protected int y2 = 0;
	
	public Rectangle(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		super.definirDessin(dessinerForme());
	}
	
	public Shape dessinerForme() {
		int largeur = Math.abs(x2-x1);
		int longueur = Math.abs(y2-y1);
		
		return new Rectangle2D.Double(x1, y1, largeur, longueur);
				
	}
	
	public Color obtenirCouleur(){
		return couleur;
	}
}
