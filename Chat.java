import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/* A classe chat irá gerar o Chat_stub ela implementa a
 * ChatInterface que define os métodos remotos que poderão ser invocados pelos clientes.
 * A classe Chat será instânciada para criar o objeto remoto.
 */
public class Chat extends UnicastRemoteObject implements ChatInterface {
	
	ArrayList<String> users = new ArrayList();
	int lastMessageId = 0;
	String username;
	String message;
	
	protected Chat() throws RemoteException {
		super();
	}
	
	public boolean sendMessage(String message) throws RemoteException {
		lastMessageId += 1;
		this.message = message;
		return true;
	}
	
	public boolean sendMessage(String username, String message) throws RemoteException {
		lastMessageId += 1;
		this.message = message;
		this.username = username;
		return true;
	}
	
	public boolean registrateUser(String username) throws RemoteException {
		return users.add(username);
	}
	
	public int getLastMessageId() throws RemoteException {
		return lastMessageId;
	}
	
	private boolean isDirectMessage() {
		String direct = "@";
		return (message.substring(0, 1).equals(direct));
	}
	
	public boolean canGetMessage(String username) throws RemoteException {
	
		String directUsername = "@" + username;
		boolean userCanSeeMessage = (isDirectMessage() && message.contains(directUsername));
		
		// User can see message if it is not a direct image or is a direct
		// message to the given user
		return (userCanSeeMessage || !isDirectMessage());
	}
	
	public String getMessage(String username) throws RemoteException {

		String directUsername = "@" + username;
		boolean isDirectMessageToUser = message.contains(directUsername);
		boolean isPrivateMessage = (isDirectMessage() && isDirectMessageToUser);
	
		if (isPrivateMessage) {
			return PrintMessage.privateMessage(this.username, message);
		} else if (!isDirectMessage()) {
			return PrintMessage.publicMessage(this.username, message);
		} else {
			return PrintMessage.infoMessage(message);
		}
	}

}
