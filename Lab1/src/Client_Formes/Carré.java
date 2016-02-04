package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Carr� extends Rectangle{
	private static final Color couleur = Color.ORANGE;

	public Carr�(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger,x1,y1,x2,y2);
	}

	public Shape dessinerForme() {
		int cot� = Math.abs(x2-x1);

		return new Rectangle2D.Double(x1, y1, cot�, cot�);
	}

	public Color obtenirCouleur(){
		return couleur;
	}
}
