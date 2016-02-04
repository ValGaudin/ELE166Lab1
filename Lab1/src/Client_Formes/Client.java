package Client_Formes;

import java.io.IOException;

public abstract class Client{
	private static final String HOST_NAME = "localhost";
	private static final int PORT_NUMBER = 10000;

	public abstract void etablirConnexion(String hostName, int portNumber);
	public abstract void fermerConnexion();

	public String obtenirHostName(){
		return HOST_NAME;
	}

	public int obtenirPortNumber(){
		return PORT_NUMBER;
	}

	public String lectureServeur(){
		String instractionForme = null;

		try {
			Connexion.obtenirBufferedReader().readLine();					 // Lecture de la ligne "commande"
			instractionForme = Connexion.obtenirBufferedReader().readLine(); // Lecture du type de forme + numéro d'indentification

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 					

		return instractionForme;
	}

	public void ecritureServeur(String commande){
		Connexion.obtenirPrinterWriter().println(commande);
	}

	public String[] decoupageInstructionForme(String instructionForme){
		return instructionForme.replaceFirst("<", " ").replaceFirst(">", " ").split("\\s+");
	}


}
