import java.io.*;
import java.net.*;

public class Client {

	public static void main(String arg[]) {
		try {
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello!");
			dout.flush();
			dout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}