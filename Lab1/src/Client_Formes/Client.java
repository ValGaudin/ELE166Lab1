package Client_Formes;

/**
 * Classe abstraite <b><i>Client</i></b> <br><br>
 * Client est une classe qui permet de créer un objet hérité. 
 */
public abstract class Client{
	private static final String HOST_NAME = "localhost";
	private static final int PORT_NUMBER = 10000;

	/**
	 * <b><i>etablirConnexion</i></b> 
	 * permet d'établir la connexion sur le portNumber du serveur depuis le hostName.
	 * 
	 * @param hostName nom de l'hôte
	 * @param portNumber numéro du port
	 */
	public abstract void etablirConnexion(String hostName, int portNumber);
	
	/**
	 * <b><i>fermerConnexion</i></b> 
	 * permet de fermer la connexion avec le serveur.
	 */
	public abstract void fermerConnexion();

	/**
	 * <b><i>obtenirHostName</i></b> 
	 * permet d'obtenir le nom de l'hôte.
	 * 
	 * @return String le nom de l'hôte
	 */
	public String obtenirHostName(){
		return HOST_NAME;
	}

	/**
	 * <b><i>obtenirPortNumber</i></b> 
	 * permet d'obtenir le numéro du port.
	 * 
	 * @return String le numéro du port
	 */
	public int obtenirPortNumber(){
		return PORT_NUMBER;
	}
	
	/**
	 * <b><i>lectureServeur</i></b> 
	 * permet de lire la réponse du serveur.
	 * 
	 * @return String la réponse du serveur
	 */
	public String lectureServeur(){
		String instractionForme = null;

		try {
			Connexion.obtenirBufferedReader().readLine();					 // Lecture de la ligne "commande"
			instractionForme = Connexion.obtenirBufferedReader().readLine(); // Lecture du type de forme + numéro d'indentification

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 					

		return instractionForme;
	}	
	
	/**
	 * <b><i>ecritureServeur</i></b> 
	 * permet d'envoyer une requête au serveur.
	 * 
	 * @param commande la requête à envoyer au serveur
	 */
	public void ecritureServeur(String commande){
		Connexion.obtenirPrinterWriter().println(commande);
	}

	/**
	 * <b><i>decoupageInstructionForme</i></b> 
	 * permet de découper la réponse du serveur dans un tableau.
	 * 
	 * @param instructionForme la réponse du serveur
	 * @return String[] l'instruction découpée
	 */
	public String[] decoupageInstructionForme(String instructionForme){
		return instructionForme.replaceFirst("<", " ").replaceFirst(">", " ").split("\\s+");
	}


}
