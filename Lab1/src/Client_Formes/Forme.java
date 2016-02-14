package Client_Formes;

import java.awt.Color;
import java.awt.Shape;

/**
 * Classe abstraite <b><i>Forme</i></b><br><br>
 * Forme est une classe qui permet de cr�er un objet h�rit�. 
 */
public abstract class Forme{
	private Shape dessin = null;
	private Color couleur = null;
	private int numeroIDLogger = 0;
	
	/**
	 * Constructeur prot�g� de la classe <b><i>Forme</i></b> 
	 * Cette methode renseigne les attributs numeroIDLogger et couleur.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme 
	 */
	protected Forme(int numeroIDLogger){
		this.numeroIDLogger = numeroIDLogger;
		this.couleur = obtenirCouleur();
	}
	
	/**
	 * <b><i>dessinerForme</i></b>
	 * permet de dessiner la forme en 2D.
	 * 
	 * @return Shape le dessin de la forme � afficher
	 */
	protected abstract Shape dessinerForme();
	
	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme.
	 * 
	 * @return Color la couleur de la forme
	 */
	public abstract Color obtenirCouleur();
	
	/**
	 * <b><i>definirDessin</i></b> 
	 * permet de d�finir le dessin de la forme.
	 * 
	 * @param dessin le dessin de la forme
	 */
	protected void definirDessin(Shape dessin){
		this.dessin = dessin;
	}
	
	/**
	 * <b><i>obtenirDessin</i></b> 
	 * permet de retourner le dessin de la forme.
	 * 
	 * @return Shape le dessin de la forme
	 */
	public Shape obtenirDessin() {
		return dessin;
	}
	
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
