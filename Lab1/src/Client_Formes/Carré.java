package Client_Formes;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Carré extends Rectangle{
	private static final Color couleur = Color.ORANGE;

	public Carré(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger,x1,y1,x2,y2);
	}
	
	public Shape dessinerForme(Frame frame) {
		int coté = Math.abs(x2-x1);
				
		return new Rectangle2D.Double(x1, y1, coté, coté);
	}
	
	public Color obtenirCouleur(){
		return couleur;
	}
}
