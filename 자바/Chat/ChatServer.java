package Chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);

		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다....");
			socket = listener.accept();
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
			Thread serverThread = new Thread(new SendServer(out));
			serverThread.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		try {
			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.contentEquals("bye")) {
					System.out.println("클라이언트에서 연결을 종료합니다.");
					sc.close();
					socket.close();
					break;
				}
				System.out.println("클라이언트 : " + inputMessage);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}