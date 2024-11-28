package auth;

public class Main {
	public static void main(String[] args)throws Exception {
//		new SignUp().sign(Input.readString("phone"), Input.readString("password"));
	
		if(new Login().login(Input.readString("phone"), Input.readString("password"))) {
			System.out.println("Login Success!");
		}
		else {
			
			System.out.println("Let's Signup Here!");
			if(new SignUp().sign(Input.readString("phone"), Input.readString("password"))) {
				System.out.println("SignUp Success!");
				Thread.sleep(2000);
				
				System.out.println("Let's Login here!");
				if(new Login().login(Input.readString("phone"), Input.readString("password"))) {
					System.out.println("Login Success!");
				}else {
					System.out.println("Login Failed!");
				}
			}
			
		}
		
	}
}
