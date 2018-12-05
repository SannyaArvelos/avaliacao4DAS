import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
	public boolean sendMessage(String message) throws RemoteException;
	public boolean registrateUser(String username) throws RemoteException;
}
