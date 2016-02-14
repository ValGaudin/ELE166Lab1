package Client_Formes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe <b><i>QueueForme</i></b><br><br>
 * QueueForme est une classe qui permet de créer un objet Queue. 
 */
public class QueueForme {
	private static Queue<Forme> listeForme;
	private int maximumQueue;
	
	/**
	 * Constructeur de la classe <b><i>QueueForme</i></b> 
	 * crée une nouvelle instance de la
	 * classe avec le nombre maximum de formes qui seront dans la liste (queue). 
	 * Autrement dit, combien de figures seront affichées.
	 * 
	 * @param maximumQueue le maximum dans la queue
	 */
	public QueueForme(int maximumQueue){
		listeForme = new LinkedList<Forme>();
		this.maximumQueue = maximumQueue;
	}
	
	/**
	 * <b><i>ajouterFormeListe</i></b> 
	 * permet d'ajouter une forme à la liste (queue).
	 * 
	 * @param forme le forme à ajouter
	 */
	public void ajouterFormeListe(Forme forme){
		
		if(listeForme.size() < maximumQueue){
			listeForme.add(forme);
		}else
		{	
			listeForme.remove();
			listeForme.add(forme);
		}
	}
	
	/**
	 * <b><i>obtenirListe</i></b> 
	 * permet d'obtenir la liste (queue).
	 * 
	 * @return Queue le Queue de formes
	 */
	public Queue<Forme> obtenirListe(){
		return listeForme;
	}
}
