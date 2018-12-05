import java.rmi.Naming;

public class Server {
	
	Server() {
		try {
			Chat chat = new Chat();
			Naming.rebind("Chat", chat);
		} catch(Exception exc) {
			// Handle Exception
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}
