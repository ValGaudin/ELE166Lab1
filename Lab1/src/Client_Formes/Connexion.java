package Client_Formes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connexion extends Client{

	private static Socket socket = null;
	private static PrintWriter outSocket = null;
	private static BufferedReader inSocket = null;
	
	public void etablirConnexion(String hostName, int portNumber){
		try{
			if (socket == null){
				socket = new Socket(hostName, portNumber);
				outSocket = new PrintWriter(socket.getOutputStream(), true);
				inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				System.out.println("Connection établie.");
			}else
				throw new Exception("Déjà connecté !");			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void fermerConnexion(){
		
		try{
		if (socket != null){
			outSocket.println("END");
			socket.close();
			socket = null; 
			System.out.println("Connection fermée.");
		}else
			throw new Exception("Déjà fermé !");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static Socket obtenirSocket(){
		return socket;
	}
	
	public static PrintWriter obtenirPrinterWriter(){
		return outSocket;
	}

	public static BufferedReader obtenirBufferedReader(){
		return inSocket;
	}
}


