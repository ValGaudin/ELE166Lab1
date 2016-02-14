package Client_Formes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Classe <b><i>Carr�</i></b> h�rit� de {@link Rectangle Rectangle} <br><br>
 * Carr� est une classe qui permet de cr�er un objet Carr�. 
 */
public class Carr� extends Rectangle{
	private static final Color couleur = Color.ORANGE;
	
	/**
	 * Constructeur de la classe <b><i>Carr�</i></b> 
	 * cr�e une nouvelle instance de la classe.
	 * 
	 * @param numeroIDLogger le IDLogger de la forme
	 * @param x1 l'abscisse du coin en haut � gauche 
	 * @param y1 l'ordonn�e du coin en haut � gauche
	 * @param x2 l'abscisse du coin en bas � droite
	 * @param y2 l'ordonn�e du coin en bas � droite 
	 */
	public Carr�(int numeroIDLogger, int x1,int y1,int x2,int y2){
		super(numeroIDLogger,x1,y1,x2,y2);
	}

	/**
	 * <b><i>dessinerForme</i></b> 
	 * permet de dessiner un carr� en 2D.
	 * 
	 * @return Shape le dessin de la forme � afficher
	 */
	public Shape dessinerForme() {
		int cot� = Math.abs(x2-x1);

		return new Rectangle2D.Double(x1, y1, cot�, cot�);
	}

	/**
	 * <b><i>obtenirCouleur</i></b> 
	 * permet de retourner la couleur de la forme carr�.
	 * 
	 * @return Color la couleur de la forme carr�
	 */
	public Color obtenirCouleur(){
		return couleur;
	}
}
