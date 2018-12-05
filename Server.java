import java.rmi.Naming;

/* O servidor cria objetos remotos e faz referências a esses objetos disponíveis.
 * Então, ele espera que os clientes invoquem métodos nos objetos.
 */
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
