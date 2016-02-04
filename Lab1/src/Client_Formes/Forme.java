package Client_Formes;

import java.awt.Color;
import java.awt.Shape;

public abstract class Forme{
	private Shape dessin = null;
	private Color couleur = null;
	private int numeroIDLogger = 0;
	
	protected Forme(int numeroIDLogger){
		this.numeroIDLogger = numeroIDLogger;
		this.couleur = obtenirCouleur();
	}
	
	protected abstract Shape dessinerForme();
	
	protected void definirDessin(Shape dessin){
		this.dessin = dessin;
	}
	
	public Shape obtenirDessin() {
		return dessin;
	}
	
	public Color obtenirCouleur() {
		return couleur;
	}
	
	public int obtenirIDLogger() {
		return numeroIDLogger;
	}
}
