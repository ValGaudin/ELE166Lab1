package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * Classe <b><i>Ligne</i></b> hérité de {@link Forme Forme} <br><br>
 * Ovale est une classe qui permet de créer un objet Ligne. 
 */
public class Ligne extends Forme{
	private static final Color couleur = Color.WHITE;
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;

	/**
	 * Constructeur de la classe <b><i>Ligne</i></b> 
	 * crée une nouvelle instance de la classe.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme
	 * @param x1 l'abscisse du point 1 
	 * @param y1 l'ordonnée du point 1
	 * @param x2 l'abscisse du point 2
	 * @param y2 l'ordonnée du point 2 
	 */
	public Ligne(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		super.definirDessin(dessinerForme());
	}

	/**
	 * <b><i>dessinerForme</i></b> 
	 * permet de dessiner une ligne en 2D.
	 * 
	 * @return Shape le dessin de la forme à afficher
	 */
	public Shape dessinerForme() {
		return new Line2D.Double(x1, x2, y1, y2);
	}
	
	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme ligne.
	 * 
	 * @return Color la couleur de la forme ligne
	 */
	public Color obtenirCouleur(){
		return couleur;
	}
}
