package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Classe <b><i>Rectangle</i></b> hérité de {@link Forme Forme} <br><br>
 * Rectangle est une classe qui permet de créer un objet Rectangle. 
 */
public class Rectangle extends Forme{
	private static final Color couleur = Color.RED;
	
	protected int x1 = 0;
	protected int y1 = 0;
	protected int x2 = 0;
	protected int y2 = 0;
	
	/**
	 * Constructeur de la classe <b><i>Rectangle</i></b> 
	 * crée une nouvelle instance de la
	 * classe.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme
	 * @param x1 l'abscisse du coin en haut à gauche 
	 * @param y1 l'ordonnée du coin en haut à gauche
	 * @param x2 l'abscisse du coin en bas à droite
	 * @param y2 l'ordonnée du coin en bas à droite 
	 */
	public Rectangle(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		super.definirDessin(dessinerForme());
	}
	
	/**
	 * <b><i>dessinerForme</i></b>
	 * permet de dessiner un rectangle en 2D.
	 * 
	 * @return Shape le dessin de la forme à afficher
	 */
	public Shape dessinerForme() {
		int largeur = Math.abs(x2-x1);
		int longueur = Math.abs(y2-y1);
		
		return new Rectangle2D.Double(x1, y1, largeur, longueur);
	}
	
	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme rectangle.
	 * 
	 * @return Color la couleur de la forme rectangle
	 */
	public Color obtenirCouleur(){
		return couleur;
	}
}
