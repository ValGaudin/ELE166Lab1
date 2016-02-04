package Client_Formes;

import java.util.LinkedList;
import java.util.Queue;

public class QueueForme {
	private static Queue<Forme> listeForme;
	private static int maximumQueue;
	
	public QueueForme(int maximumQueue){
		listeForme = new LinkedList<Forme>();
		this.maximumQueue = maximumQueue;
	}
	
	public void ajouterFormeListe(Forme forme){
		
		if(listeForme.size() < maximumQueue){
			listeForme.add(forme);
		}else
		{	
			listeForme.remove();
			listeForme.add(forme);
		}
	}
	
	public Queue<Forme> obtenirListe(){
		return listeForme;
	}
}
