package auth;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SignUp {
	File f0, f;
	public String projectName;

	{
		projectName = new File(System.getProperty("user.dir")).getName();
		File folder = new File("e:/Projects/" + projectName);
		if (folder.exists()) {
			f0 = new File("E:/Projects/" + projectName);
			f = new File("E:/Projects/" + projectName + "/users.txt");
			if (f0.exists()) {
				if (f.exists()) {

				} else {
					try {
						f.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				f0.mkdir();
			}

		} else {
			f.mkdir();
		}
		
	}

	public boolean sign(String phone, String password) throws Exception {
		boolean flag = false;

		if (isUserExist2(phone)) {
			System.out.println("User Already Exists!");
		} else {

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
		FileReader fr=new FileReader(f);
		if(fr.read()==-1) {
			fw.write("------------------ User Authentical Records ------------------\r\n"
					+ "phone   password\n\n");
		}
		fr.close();
		
		fw.write(phone + " ");
		fw.flush();
		fw.write(password+"\n");
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
			String phone2=(temp[0].replace(" ", ""));
			String password2=null;
			try{
				password2=(temp[1]).replace(" ", "");
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				try{
					password2=(temp[1]).replace(" ", "");
				}catch(Exception e) {
//					System.out.println(e.getLocalizedMessage());
				}
			}
//			System.out.println("phone: "+phone);
//			System.out.println("password: "+password);
			
			if (phone2.equals(phone) && password2.equals(password)) {
				flag = true;
				break;
			}else if(phone2.equals(phone) && password2.equals(password)==false){
				try {
					throw new InvalidUserCredential("unmatched password!");
				}
				catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
					break;
				}
			}else if(phone2.equals(password)==true&&password2.equals(phone) ==false){
				try {
					throw new InvalidUserCredential("unmatched phone!");
				}
				catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
					break;
				}
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
