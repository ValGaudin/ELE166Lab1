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
		
		// �tablie la connexion avec le serveur en prenant les param�tres par d�faut du client
		client.etablirConnexion(client.obtenirHostName(), client.obtenirPortNumber());
		
		// Cr�e la fen�tre 
		frame.launch(frame);

		// Centre la fen�tre 
		frame.setLocationRelativeTo(null);
		
		// Affiche le nombre de forme voulue
		for(int i=0;i<NOMBRE_FORMES_TOTAL;i++){
			// Requ�te serveur pour obtenir une instruction de forme
			client.ecritureServeur("GET");
			
			// R�cup�ration de la forme demand�e au serveur apr�s un traitement de la r�ponse serveur
			forme = CreateurDeFormes.obtenirForme(client.decoupageInstructionForme(client.lectureServeur())); 
			
			// �criture dans le fichier IDLogger du num�ro correspondant � la forme envoy�e
			idLogger.logID(forme.obtenirIDLogger());
			
			// Ajout de la forme � la file de forme � dessiner
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
