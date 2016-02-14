package Client_Formes;

/**
 * Classe abstraite <b><i>Client</i></b> <br><br>
 * Client est une classe qui permet de cr�er un objet h�rit�. 
 */
public abstract class Client{
	private static final String HOST_NAME = "localhost";
	private static final int PORT_NUMBER = 10000;

	/**
	 * <b><i>etablirConnexion</i></b> 
	 * permet d'�tablir la connexion sur le portNumber du serveur depuis le hostName.
	 * 
	 * @param hostName nom de l'h�te
	 * @param portNumber num�ro du port
	 */
	public abstract void etablirConnexion(String hostName, int portNumber);
	
	/**
	 * <b><i>fermerConnexion</i></b> 
	 * permet de fermer la connexion avec le serveur.
	 */
	public abstract void fermerConnexion();

	/**
	 * <b><i>obtenirHostName</i></b> 
	 * permet d'obtenir le nom de l'h�te.
	 * 
	 * @return String le nom de l'h�te
	 */
	public String obtenirHostName(){
		return HOST_NAME;
	}

	/**
	 * <b><i>obtenirPortNumber</i></b> 
	 * permet d'obtenir le num�ro du port.
	 * 
	 * @return String le num�ro du port
	 */
	public int obtenirPortNumber(){
		return PORT_NUMBER;
	}
	
	/**
	 * <b><i>lectureServeur</i></b> 
	 * permet de lire la r�ponse du serveur.
	 * 
	 * @return String la r�ponse du serveur
	 */
	public String lectureServeur(){
		String instractionForme = null;

		try {
			Connexion.obtenirBufferedReader().readLine();					 // Lecture de la ligne "commande"
			instractionForme = Connexion.obtenirBufferedReader().readLine(); // Lecture du type de forme + num�ro d'indentification

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 					

		return instractionForme;
	}	
	
	/**
	 * <b><i>ecritureServeur</i></b> 
	 * permet d'envoyer une requ�te au serveur.
	 * 
	 * @param commande la requ�te � envoyer au serveur
	 */
	public void ecritureServeur(String commande){
		Connexion.obtenirPrinterWriter().println(commande);
	}

	/**
	 * <b><i>decoupageInstructionForme</i></b> 
	 * permet de d�couper la r�ponse du serveur dans un tableau.
	 * 
	 * @param instructionForme la r�ponse du serveur
	 * @return String[] l'instruction d�coup�e
	 */
	public String[] decoupageInstructionForme(String instructionForme){
		return instructionForme.replaceFirst("<", " ").replaceFirst(">", " ").split("\\s+");
	}


}
