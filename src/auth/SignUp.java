package auth;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class SignUp {
	File f0 = new File("E:/Projects/");
	File f = new File("E:/Projects/" + "/users.txt");

	public boolean sign(String phone, String password) throws Exception {
		boolean flag = false;
	
		if(isUserExist2(phone)) {
			System.out.println("User Already Exists!");
		}else {
			if (f0.exists()) {
				if (f.exists()) {

				} else {
					f.createNewFile();
				}
			} else {
				f0.mkdir();
			}

			if (phone != null && phone.length() == 10) {
				if (password.length() >= 6 && password.length() < 80) {
					flag = saveToFile(phone, password);
				}
			} else {
				System.out.println("invalid phone!");
			}

		}
		return flag;

		
	}

	public boolean saveToFile(String phone, String password) throws Exception {
		boolean flag;
		FileWriter fw = new FileWriter(f, true);
		fw.write(phone + " ");
		fw.write(password + "\n");
		fw.flush();
		fw.close();
		flag = true;

		return flag;
	}

	public boolean isUserExist(String phone, String password) throws Exception {
		boolean flag = false;

		FileReader fr = new FileReader(f);
		char arr[] = new char[1000];
		int count = 0;
		int x = fr.read();

		while (x > -1) {
			count++;
			arr[count] = (char) x;
			x = fr.read();
		}

		String data = Arrays.toString(arr).replace("[", "").replace("]", "").replace(", ", "");

		String s1[] = data.split("\n");
		for (int i = 0; i < s1.length; i++) {
			String temp[] = (s1[i]).split(" ");
			if (temp[0].equals(phone) && temp[1].equals(password)) {
				flag = true;
				break;
			}

		}
		fr.close();
		return flag;

	}


	public boolean isUserExist2(String phone) throws Exception {
		boolean flag = false;

		FileReader fr = new FileReader(f);
		char arr[] = new char[1000];
		int count = 0;
		int x = fr.read();

		while (x > -1) {
			count++;
			arr[count] = (char) x;
			x = fr.read();
		}

		String data = Arrays.toString(arr).replace("[", "").replace("]", "").replace(", ", "");

		String s1[] = data.split("\n");
		for (int i = 0; i < s1.length; i++) {
			String temp[] = (s1[i]).split(" ");
			if (temp[0].equals(phone)) {
				flag = true;
				break;
			}

		}
		fr.close();
		return flag;

	}

	
}
