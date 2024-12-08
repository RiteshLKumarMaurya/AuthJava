package auth;

public class AuthMain {
	static boolean flag = false;

	public static void main(String[] args) {

//		//1.i  just load and register
//		SignUp loading=new SignUp();

//		new SignUp().sign(Input.readString("phone"), Input.readString("password"));
		int choice = 0;
		do {
			exec();
			if (flag == false) {
				System.out.println();
				System.out.println("Enter -1 to Exit!");
				choice = Input.readInt("choice");
			}
		} while (choice != -1 && flag == false);
	}

	public static void exec() {
		System.out.println("-----------------------------Login------------------------------------");
		try {
			String p1 = Input.readString("phone");
			String p2 = Input.readString("password");
			if (new Login().login(p1, p2) && validate(p1, p2)) {
				flag = true;
				System.out.println("Login Success!\n");
			} else {
				System.out.println("User doesnot exists!\n");
				System.out.println("--------------------- Let's Signup Here!-----------------");
				String ph = Input.readString("phone");
				String pass = Input.readString("password");

				if (new SignUp().sign(ph, pass) && validate(ph, pass)) {
					System.out.println("SignUp Success!\n");
					flag = true;
					Thread.sleep(2000);

					System.out.println("---------------Let's Login here!------------------");
					String phon = Input.readString("phone");
					String paswd = Input.readString("password");
					if (new Login().login(phon, paswd) && validate(phon, paswd)) {
						flag = true;
						System.out.println("Login Success!");
						System.out.println();
					} else {

						System.out.println("Login Failed!\n");
						System.out.println();
					}

				}

			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static boolean validate(String phone, String password) throws Exception {
		if (phone != null && phone.length() == 10) {
			if (password.length() >= 6 && password.length() <= 80) {

				return true;

			} else {
				throw new InvalidUserCredential("weak password!");
			}
		} else {
			throw new InvalidUserCredential("phone should be 10 digit!");
		}
	}
}
