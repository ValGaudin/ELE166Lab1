package Client_Formes;

import java.awt.Color;
import java.awt.Shape;

public abstract class Forme{
	private Color couleur;
	private int numeroIDLogger;
	
	protected Forme(int numeroIDLogger){
		this.numeroIDLogger = numeroIDLogger;
		this.couleur = obtenirCouleur();
	}
	
	public abstract Shape dessinerForme();
	
	public Color obtenirCouleur() {
		return couleur;
	}
	
	public int obtenirIDLogger() {
		return numeroIDLogger;
	}
}
