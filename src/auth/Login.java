package auth;

public class Login {
	public boolean login(String phone,String password)throws Exception {
		
		return new SignUp().isUserExist(phone, password);
		
	}
}
