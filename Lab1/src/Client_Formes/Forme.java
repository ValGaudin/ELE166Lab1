package Client_Formes;

import java.awt.Color;
import java.awt.Shape;

/**
 * Classe abstraite <b><i>Forme</i></b><br><br>
 * Forme est une classe qui permet de créer un objet hérité. 
 */
public abstract class Forme{
	private int numeroIDLogger;
	
	/**
	 * Constructeur protégé de la classe <b><i>Forme</i></b> 
	 * Cette methode renseigne les attributs numeroIDLogger et couleur.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme 
	 */
	protected Forme(int numeroIDLogger){
		this.numeroIDLogger = numeroIDLogger;
	}
	
	/**
	 * <b><i>dessinerForme</i></b>
	 * permet de dessiner la forme en 2D.
	 * 
	 * @return Shape le dessin de la forme à afficher
	 */
	public abstract Shape dessinerForme();
	
	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme.
	 * 
	 * @return Color la couleur de la forme
	 */
	public abstract Color obtenirCouleur();
	
	/**
	 * <b><i>obtenirIDLogger</i></b> 
	 * permet de retourner le IDLogger de la forme.
	 * 
	 * @return int le IDLogger de la forme
	 */
	public int obtenirIDLogger() {
		return numeroIDLogger;
	}
}
