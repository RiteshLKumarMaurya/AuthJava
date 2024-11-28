package auth;

import java.util.Scanner;

public class Input {
	private static String msg;
	
	static Scanner scan=new Scanner(System.in);

	public static int readInt(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"a number: ":"Enter "+msg+": ");
		return scan.nextInt();
		
	}

	public static byte readByte(String s) {
		msg=s;		
		System.out.print("Enter "+msg==null?"a number: ":"Enter "+msg+": ");
		return scan.nextByte();
	}

	public static boolean readBoolean(String s) {
		msg=s;
		System.out.println("Enter "+msg==null?"a boolean value: ":"Enter "+msg+": ");
		return scan.nextBoolean();
	}

	public static short readShort(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"a number: ":"Enter "+msg+": ");
		return scan.nextShort();
	}

	public static long readLong(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"a number: ":"Enter "+msg+": ");
		return scan.nextLong();
	}

	public static float readFloat(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"a decimal number: ":"Enter "+msg+": ");
		return scan.nextFloat();
	}

	public static double readDouble(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"a decimal number: ":"Enter "+msg+": ");
		return scan.nextDouble();
	}

	public static String readString(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"your string: ":"Enter "+msg+": ");
		return scan.next();
	}

	public static char readChar(String s) {
		msg=s;
		System.out.print("Enter "+msg==null?"a character: ":"Enter "+msg+": ");
		return scan.next().charAt(0);
	}

	// which thing executes in the last in the java 
	//	scan.close();

}
