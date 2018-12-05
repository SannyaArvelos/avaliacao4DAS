import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Chat extends UnicastRemoteObject implements ChatInterface {
	
	ArrayList<String> users = new ArrayList();
	int lastMessageId = 0;
	String username;
	String message;
	
	protected Chat() throws RemoteException {
		super();
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
	
	public String getMessage(String username) throws RemoteException {
		
		String direct = "@";
		String directUsername = "@" + username;
		boolean isDirectMessage = (message.substring(0, 1) == direct);
		boolean directMessageContainsUser = message.contains(directUsername);
		boolean showDirectMessage = (isDirectMessage && directMessageContainsUser);
	
		if (showDirectMessage) {
			return PrintMessage.privateMessage(this.username, message);
		} else if (!isDirectMessage) {
			return PrintMessage.publicMessage(this.username, message);
		} else {
			return PrintMessage.infoMessage(message);
		}
	}

}
