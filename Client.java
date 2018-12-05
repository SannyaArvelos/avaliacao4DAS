import java.rmi.Naming;
import java.util.Scanner;

public class Client {
	
	Client() {
		startChat();
		registrateUser();
	}
	
	Chat chat = null;
	
	public void startChat() {
		try {
			chat = (Chat) Naming.lookup("Chat");
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	public void registrateUser() {
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println(username);
		try {
			chat.registrateUser(username);			
		} catch (Exception exception) {
			System.out.println(exception);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();

	}

}
