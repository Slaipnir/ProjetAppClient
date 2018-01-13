package Appli;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		try {
			
			//Connexion au serveur
			@SuppressWarnings("resource")
			Socket socketClient = new Socket(args[0],Integer.parseInt(args[1]));
			
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			PrintWriter socketOut = new PrintWriter(socketClient.getOutputStream(),true);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			String str;
			
			while(true){
				
				//Reception de ce que demande le serveur
				String recu = socketIn.readLine();
				recu = recu.replaceAll("##", "\n"); //dans le cas ou le serveur envoie une string sur plusieurs lignes
				
				
				//affichage de la demande du serveur
				System.out.println(recu);
				
				//Reponse du client
				str = sc.nextLine();
				
				//Envoie de la reponse du client au serveur				
				socketOut.println(str);

			}
			
			
		} catch (UnknownHostException e) {
			System.out.println("Ce Serveur n'exsite pas changer l'ip et/ou le port");
		} catch (IOException e) {
			System.out.println("exit");
			
		} catch (NullPointerException e) {
			System.out.println("Service terminé");
		}
	}
}