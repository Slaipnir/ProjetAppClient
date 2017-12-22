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
			String stop = new String("stop");
			
			//Connexion au serveur
			Socket socketClient = new Socket("localhost",2500);
			
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			PrintWriter socketOut = new PrintWriter(socketClient.getOutputStream(),true);
			Scanner sc = new Scanner(System.in);
			
			String str;
			
			while(true){
				
				//Reception de ce que demande le serveur
				String recu = socketIn.readLine();
				recu = recu.replaceAll("##", "\n");
				
				System.out.println(recu);
				//Choix Livre
				str = sc.nextLine();
				
				//Envoie de l'ID				
				socketOut.println(str);

			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Service terminé");
		}catch (NullPointerException e) {
			System.out.println("Service terminé");
		}
	}
}