import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
	public boolean sendMessage(String username, String message) throws RemoteException;
	public boolean registrateUser(String username) throws RemoteException;
	public String getMessage(String username) throws RemoteException;
	public boolean canGetMessage(String username) throws RemoteException;
	public int getLastMessageId() throws RemoteException;
}
