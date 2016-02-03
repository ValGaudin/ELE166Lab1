package Client_Formes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
	private static final String hostName = "localhost";
	private static final int portNumber = 10000;
	private static Socket socket = null;
	private static PrintWriter outSocket = null;
	private static BufferedReader inSocket = null;

	public Client() {
		etablirConnection();
	}

	public void etablirConnection(){
		try{
			socket = new Socket(hostName, portNumber);
			outSocket = new PrintWriter(socket.getOutputStream(), true);
			inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("Connection OK.");	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public String lectureServeur(){
		String instractionForme = null;

		try {
			inSocket.readLine();					// Lecture de la ligne "commande"
			instractionForme = inSocket.readLine(); // Lecture du type de forme + numéro d'indentification

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 					

		return instractionForme;
	}

	public void ecritureServeur(String commande){

		outSocket.println(commande);
	}

	public void fermerConnection(){
		outSocket.println("END");
		System.out.println("Connection fermée.");
	}

	public String[] decoupageInstructionForme(String instructionForme){
		return instructionForme.replaceFirst("<", " ").replaceFirst(">", " ").split("\\s+");
	}
}
