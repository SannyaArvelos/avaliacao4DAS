import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Chat extends UnicastRemoteObject implements ChatInterface {
	
	protected Chat() throws RemoteException {
		super();
	}
	
	public boolean sendMessage(String message) throws RemoteException {
		return true;
	}

}
