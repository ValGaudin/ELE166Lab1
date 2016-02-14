package Client_Formes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Classe <b><i>Connexion</i></b> h�rit� de {@link Client Client}<br><br>
 * Connexion est une classe qui permet de cr�er une connexion avec le serveur. 
 */
public class Connexion extends Client{

	private static Socket socket = null;
	private static PrintWriter outSocket = null;
	private static BufferedReader inSocket = null;

	/**
	 * <b><i>etablirConnexion</i></b> 
	 * permet d'�tablir la connexion sur le portNumber du serveur depuis le hostName.
	 * 
	 * @param hostName nom de l'h�te,
	 * @param portNumber num�ro du port
	 */
	public void etablirConnexion(String hostName, int portNumber){
		try{
			if (socket == null){
				socket = new Socket(hostName, portNumber);
				outSocket = new PrintWriter(socket.getOutputStream(), true);
				inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				System.out.println("Connection �tablie.");
			}else
				throw new Exception("D�j� connect� !");			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <b><i>fermerConnexion</i></b> 
	 * permet de fermer la connexion avec le serveur.
	 */
	public void fermerConnexion(){

		try{
			if (socket.isConnected()){
				outSocket.println("END");
				
				System.out.println("Requ�tes termin�es.");
			}else
				throw new Exception("D�j� ferm� !");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <b><i>obtenirSocket</i></b> 
	 * permet de retourner le socket.
	 * 
	 * @return Socket le socket
	 */
	public static Socket obtenirSocket(){
		return socket;
	}

	/**
	 * <b><i>obtenirPrinterWriter</i></b> 
	 * permet de retourner le PrinterWriter.
	 * 
	 * @return PrinterWriter le print writer
	 */
	public static PrintWriter obtenirPrinterWriter(){
		return outSocket;
	}

	/**
	 * <b><i>obtenirBufferedReader</i></b> 
	 * permet de retourner le BufferedReader.
	 * 
	 * @return BufferedReader le buffered reader
	 */
	public static BufferedReader obtenirBufferedReader(){
		return inSocket;
	}
}


