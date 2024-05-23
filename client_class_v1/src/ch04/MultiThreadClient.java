package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiThreadClient {
	
	public static void main(String[] args) {
		
		System.out.println("### 클라이언트 실행 ###");
		
		try {
		
			Socket socket = new Socket("192.168.0.111", 5000);
			System.out.println("*** connected to Server ***");
			
			// 클라이언트에서 서버로 메시지 보내기 write, out
			PrintWriter socketWriter 
				= new PrintWriter(socket.getOutputStream(),true);
			// 서버와 연결된 socket 을 통해 입력값 받기
			BufferedReader socketReader
				= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 키보드를 통한 입력 받기
			BufferedReader keyboardReader 
				= new BufferedReader(new InputStreamReader(System.in));
			
			// 서버로부터 데이터를 읽는 스레드
			Thread readThread = new Thread(() -> {
				String serverMessage;
				try {
					while ((serverMessage = socketReader.readLine()) != null) {
						System.out.println("서버에서 온 메시지 " + serverMessage);
					}
				} catch (IOException e) {

					e.printStackTrace();
				}
				
			});
			// 서버에게 데이터를 보내는 스레드
			Thread writeThread = new Thread(() -> {
				
				try {
					String clientMessage;
					while( (clientMessage = keyboardReader.readLine()) != null) {
						// 1 : 키보드에서 데이터를 응용 프로그램 안으로 입력받아서
						// 2 : 서버 측 소켓과 연결 되어있는 출력 스트림을 통해 데이터를 보낸다,
						socketWriter.println(clientMessage);					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			});
			
			readThread.start();
			writeThread.start();
			
			readThread.join();
			writeThread.join();
			
			System.out.println("클라이언트 측 프로그램 종료 ");
			
			
		} catch (Exception e) {

		}
		
	} // end of main
	
} // end of class
