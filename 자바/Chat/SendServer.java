package Chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class SendServer implements Runnable {
	BufferedWriter out = null;
	Scanner sc = new Scanner(System.in);

	public SendServer(BufferedWriter out) {
		this.out = out;
	}

	public void run() {
		try {
			while (true) {
				System.out.println("������>>");
				String outputMessage = sc.nextLine();
				if (outputMessage.contentEquals("bye")) {
					out.write(outputMessage + "\n");
					out.flush();
					System.out.println("�����մϴ�");
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
