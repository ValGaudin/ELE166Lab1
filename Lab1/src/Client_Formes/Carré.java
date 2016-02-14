package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Classe <b><i>Carré</i></b> hérité de {@link Rectangle Rectangle} <br><br>
 * Carré est une classe qui permet de créer un objet Carré. 
 */
public class Carré extends Rectangle{
	private static final Color couleur = Color.ORANGE;
	
	/**
	 * Constructeur de la classe <b><i>Carré</i></b> 
	 * crée une nouvelle instance de la classe.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme
	 * @param x1 l'abscisse du coin en haut à gauche 
	 * @param y1 l'ordonnée du coin en haut à gauche
	 * @param x2 l'abscisse du coin en bas à droite
	 * @param y2 l'ordonnée du coin en bas à droite 
	 */
	public Carré(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger,x1,y1,x2,y2);
	}

	/**
	 * <b><i>dessinerForme</i></b> 
	 * permet de dessiner un carré en 2D.
	 * 
	 * @return Shape le dessin de la forme à afficher
	 */
	public Shape dessinerForme() {
		int coté = Math.abs(x2-x1);

		return new Rectangle2D.Double(x1, y1, coté, coté);
	}

	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme carré.
	 * 
	 * @return Color la couleur de la forme carré
	 */
	public Color obtenirCouleur(){
		return couleur;
	}
}
