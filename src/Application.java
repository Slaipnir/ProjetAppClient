import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Application {
	public static String HOST = "localhost";
	private static int PORT = 1234;

	public static void main(String[] args) throws UnknownHostException, IOException{
	
		Socket client = new Socket(HOST, PORT);
		
		//flux sortant de la socket vers le serveur (écriture) :
		PrintWriter socketOut = new PrintWriter(client.getOutputStream(), true);
		
		//flux entrant de la socket pour lecture :
		BufferedReader socketIn = new BufferedReader(new InputStreamReader(client.getInputStream()));	
		
		//lecture clavier : 
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));	

		String line;
		System.out.println(" Saisir le message au clavier : ");
		line = clavier.readLine();
		
		//on envoie la saisie au serveur :
		socketOut.println(line);
		
		
		//on récupère la chaine inversée par le service :
		line = socketIn.readLine();
		
		System.out.println(line);
		
	}
}
