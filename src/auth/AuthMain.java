package auth;

public class AuthMain {
	public static void main(String[] args)throws Exception {
//		new SignUp().sign(Input.readString("phone"), Input.readString("password"));
	
		if(new Login().login(Input.readString("phone"), Input.readString("password"))) {
			System.out.println("Login Success!\n");
		}
		else {
			System.out.println("User doesnot exists!\n");
			System.out.println("--------------------- Let's Signup Here!-----------------");
			if(new SignUp().sign(Input.readString("phone"), Input.readString("password"))) {
				System.out.println("SignUp Success!\n");
				Thread.sleep(2000);
				
				System.out.println("---------------Let's Login here!------------------");
				if(new Login().login(Input.readString("phone"), Input.readString("password"))) {
					System.out.println("Login Success!\n");
				}else {
					
					System.out.println("Login Failed!\n");
				}
				
			}
			
		}
		
	}
}
