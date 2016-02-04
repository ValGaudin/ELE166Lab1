package Client_Formes;

import ca.etsmtl.log.util.IDLogger;

public class Client_Formes {
	
	private static final int NOMBRE_FORMES_TOTAL = 500;
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
		
		// Établie la connexion avec le serveur en prenant les paramètres par défaut du client
		client.etablirConnexion(client.obtenirHostName(), client.obtenirPortNumber());
		
		// Crée la fenêtre 
		frame.launch(frame);

		// Centre la fenêtre 
		frame.setLocationRelativeTo(null);
		
		// Affiche le nombre de forme voulue
		for(int i=0;i<NOMBRE_FORMES_TOTAL;i++){
			// Requête serveur pour obtenir une instruction de forme
			client.ecritureServeur("GET");
			
			// Récupération de la forme demandée au serveur après un traitement de la réponse serveur
			forme = CreateurDeFormes.obtenirForme(client.decoupageInstructionForme(client.lectureServeur())); 
			
			// Écriture dans le fichier IDLogger du numéro correspondant à la forme envoyée
			idLogger.logID(forme.obtenirIDLogger());
			
			// Ajout de la forme à la file de forme à dessiner
			frame.queueForme.ajouterFormeListe(forme);
			
			// Redessine l'interface avec ses changements (l'ajout d'une forme par exemple)
			frame.repaint();
			
			// Attente entre le dessin de chaque forme 
			frame.attendre();
		}
		
		//Fermeture de la connection avec le serveur
		client.fermerConnexion();
	}
}
