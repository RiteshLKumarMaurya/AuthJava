package auth;

public class InvalidUserCredential extends Exception {
	private String message;

	public InvalidUserCredential(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	

}
