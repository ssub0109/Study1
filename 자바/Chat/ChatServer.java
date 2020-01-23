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
			System.out.println("������ ��ٸ��� �ֽ��ϴ�....");
			socket = listener.accept();
			System.out.println("����Ǿ����ϴ�.");
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
					System.out.println("Ŭ���̾�Ʈ���� ������ �����մϴ�.");
					sc.close();
					socket.close();
					break;
				}
				System.out.println("Ŭ���̾�Ʈ : " + inputMessage);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}