package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Classe <b><i>Ovale</i></b> hérité de {@link Forme Forme} <br><br>
 * Ovale est une classe qui permet de créer un objet Ovale. 
 */
public class Ovale extends Forme{
	private static final Color couleur = Color.BLUE;

	protected int centreX;
	protected int centreY;
	protected int rayonH;
	protected int rayonV;

	/**
	 * Constructeur de la classe <b><i>Ovale</i></b> 
	 * crée une nouvelle instance de la
	 * classe.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme
	 * @param centreX l'abscisse du centre 
	 * @param centreY l'ordonnée du centre
	 * @param rayonH le rayon horizontale
	 * @param rayonV le rayon verticale
	 */
	public Ovale(int numeroIDLogger, int centreX, int centreY, int rayonH, int rayonV){
		super(numeroIDLogger);
		this.centreX = centreX;
		this.centreY = centreY;
		this.rayonH = rayonH;
		this.rayonV = rayonV;
		super.definirDessin(dessinerForme());
	}

	/**
	 * <b><i>dessinerForme</i></b> 
	 * permet de dessiner un ovale en 2D.
	 * 
	 * @return Shape le dessin de la forme à afficher
	 */
	public Shape dessinerForme() {
		return new Ellipse2D.Double(centreX, centreY, rayonH, rayonV);
	}

	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme ovale.
	 * 
	 * @return Color la couleur de la forme ovale
	 */
	public Color obtenirCouleur(){
		return couleur;
	}
}
