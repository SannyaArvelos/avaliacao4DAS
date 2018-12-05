import java.io.Console;
import java.rmi.Naming;
import java.util.Scanner;

public class Client {
	
	private String username = null;
	private ChatInterface chat = null;
	Scanner scanner = new Scanner(System.in);
	
	Client() {
		startChat();
		registrateUser();
		broadcastMessages();
		writeMessage();
	}
	
	
	public void startChat() {
		try {
			chat = (ChatInterface) Naming.lookup("Chat");
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	public ChatInterface getChat() {
		return chat;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void broadcastMessages() {
		new Thread(new Broadcast(this)).start();
	}
	
	public void writeMessage() {
		while(true) {
			System.out.print("\b \b");
			System.out.print(username + ": ");
			String message = scanner.nextLine();
			try {				
				chat.sendMessage(username, message);
			} catch (Exception exception) {
				System.out.println(exception);
				break;
			}
		}
	}
	
	public void registrateUser() {
		System.out.print("Digite seu username: ");
		username = scanner.nextLine();
		System.out.println(username);
		try {
			chat.registrateUser(username);			
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	public static void main(String[] args) {
		new Client();
	}

}
