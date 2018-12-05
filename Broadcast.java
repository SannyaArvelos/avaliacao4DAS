
public class Broadcast implements Runnable {
	
	Client client = null;
	Integer lastMessageId = 0;
	
	Broadcast(Client client) {
		this.client = client;
	}
	
	public void run() {
		ChatInterface chat = client.getChat();
		String username = client.getUsername();
		System.out.println("Run");
		while (true) {
			try {
				Integer chatLastMessageId = chat.getLastMessageId();
				if (lastMessageId != chatLastMessageId) {
					lastMessageId = chatLastMessageId;
					System.out.println(chat.getMessage(username));
				}			
			} catch(Exception exception) {
				System.out.println(exception);
			}
		}
	}

}
