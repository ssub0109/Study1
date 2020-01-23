package Chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Thread clientThread = new Thread(new SendClient(out));
			clientThread.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		try {
			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.contentEquals("bye")) {
					System.out.println("서버에서 연결을 종료합니다.");
					sc.close();
					socket.close();
					break;
				}
				System.out.println("서버 : " + inputMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
