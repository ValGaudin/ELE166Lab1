package Client_Formes;

import ca.etsmtl.log.util.IDLogger;

/**
 * Classe <b><i>Client_Formes</i></b><br><br>
 * Client_Formes est une classe qui est le main. 
 * 
 * @author Valentin GAUDIN 
 */
public abstract class Client_Formes {
	
	private static final int NOMBRE_FORMES_TOTAL = 300;
	private static Affichage frame = new Affichage();
	private static IDLogger idLogger = IDLogger.getInstance();
	private static Client client = new Connexion();
	
	/**
	 * Describe <code>main</code> method here.
	 *
	 * @param args a <code>String[]</code> value
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable
	{
		Forme forme = null;
		
		// �tablir la connexion avec le serveur en prenant les param�tres par d�faut du client
		client.etablirConnexion(client.obtenirHostName(), client.obtenirPortNumber());
		
		// Cr�er la fen�tre 
		frame.launch(frame);

		// Centrer la fen�tre 
		frame.setLocationRelativeTo(null);
		
		// Afficher le nombre de forme voulue
		for(int i=0;i<NOMBRE_FORMES_TOTAL;i++){
			// Obtenir une instruction de forme du serveur
			client.ecritureServeur("GET");
			
			// R�cup�rer la forme demand�e au serveur apr�s un traitement de la r�ponse serveur
			forme = CreateurDeFormes.obtenirForme(client.decoupageInstructionForme(client.lectureServeur())); 
			
			// �crir dans le fichier IDLogger le num�ro correspondant � la forme envoy�e
			idLogger.logID(forme.obtenirIDLogger());
			
			// Ajouter de la forme � la file de formes � dessiner
			frame.queueForme.ajouterFormeListe(forme);
			
			// Redessiner l'interface avec ses changements (l'ajout d'une forme par exemple)
			frame.repaint();
			
			// Attendre entre le dessin de chaque forme 
			frame.attendre();
		}
		
		//Fermer la connection avec le serveur
		client.fermerConnexion();
	}
}
