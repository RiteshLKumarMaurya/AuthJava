package auth;

public class Login {
	public boolean login(String phone,String password) {
		
		try{
			return new SignUp().isUserExist(phone, password);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
		
	}
}
