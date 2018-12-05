import java.io.Console;
import java.rmi.Naming;
import java.util.Scanner;

/* A classe client é o Cliente no sistema RMI.
 * Ela é responsável por invocar os métodos remotos dos objetos criados pelo servidor.
 */
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
//			System.out.print("\b \b");
//			System.out.print(username + ": ");
			String message = scanner.nextLine();
			try {				
				chat.sendMessage(username, message);
			} catch (Exception exception) {
				System.out.println(exception);
				break;
			}
		}
	}
	
	private void printWelcomeMessage() {
		System.out.println(PrintMessage.successMessage("BEM-VINDO AO CHAT DE TPPS!\n\n"));
		System.out.print(PrintMessage.successMessage("Para enviar uma mensagem direta: "));
		System.out.println("@username sua mensagem");
		System.out.print("Digite seu username: ");
	}
	
	public void registrateUser() {
		printWelcomeMessage();
		username = scanner.nextLine();
		try {
			chat.registrateUser(username);
			chat.sendMessage(username + " entrou no chat!");
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	public static void main(String[] args) {
		new Client();
	}

}
