package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Classe <b><i>Cercle</i></b> hérité de {@link Ovale Ovale} <br><br>
 * Cercle est une classe qui permet de créer un objet Cercle. 
 */
public class Cercle extends Ovale{
	private static final Color couleur = Color.CYAN;

	/**
	 * Constructeur de la classe <b><i>Cercle</i></b>  
	 * crée une nouvelle instance de la classe.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme
	 * @param centreX l'abscisse du centre 
	 * @param centreY l'ordonnée du centre
	 * @param rayon le rayon
	 * 
	 */
	public Cercle(int numeroIDLogger, int centreX, int centreY, int rayon){
		super(numeroIDLogger, centreX, centreY, rayon, rayon);
	}
	
	/**
	 * <b><i>dessinerForme</i></b> 
	 * permet de dessiner un cercle en 2D.
	 * 
	 * @return Shape le dessin de la forme à afficher
	 */
	public Shape dessinerForme() {
		return new Ellipse2D.Double(centreX, centreY, rayonH, rayonV);
	}

	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme cercle.
	 * 
	 * @return Color la couleur de la forme cercle
	 */
	public Color obtenirCouleur(){
		return couleur;
	}

}
