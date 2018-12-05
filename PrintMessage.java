public class PrintMessage {
    public static final String RESET = "\033[0m"; 
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREEN = "\033[0;32m";
    public static final String BLUE = "\033[0;34m";
	
	public static String privateMessage(String username, String message) {		
		String msg = Helpers.formatMessage(username, message);
		return RED + msg + RESET;
	}
	
	public static String infoMessage(String message) {
		String msg = Helpers.formatMessage(message);
		return YELLOW + msg + RESET;
	}
	
	public static String successMessage(String message) {
		return GREEN + message + RESET;
	}
	
	public static String primaryMessage(String message) {
		return GREEN + message + RESET;
	}
	
	
	public static String publicMessage(String username, String message) {
		String msg = Helpers.formatMessage(username, message);
		return CYAN + msg + RESET;
		
	}

}
