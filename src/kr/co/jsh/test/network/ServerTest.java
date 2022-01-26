package kr.co.jsh.test.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author 전상훈
 * 
 * 소켓을 통해 서버를 만들어보자
 *
 */
public class ServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(80);
			System.out.println("서버를 가동하였습니다.");
			System.out.println("=======================================================");
			
			//프로그램을 유지하기 위해 while(true) 사용
			while(true) {
				Socket socket = serverSocket.accept();
				
				synchronized (socket) {
					InetAddress inetAddress = socket.getInetAddress();
					System.out.println("클라이언트가 접속했습니다.");
					System.out.println("getHostAddress ::: "+inetAddress.getHostAddress());
				}
				
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				new Thread() {
					public void run() {
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						try {
							while(true) {
								String readLine = br.readLine();
								if(readLine == null) break;
								System.out.println("서버가 받은 데이터 ::: "+readLine);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							try {
								socket.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}.start();
				
				
				new Thread() {
					public void run() {
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
						int cnt = 0;
						try {
							while(true) {
								Thread.sleep(1000);
								bw.write("서버에서 전송하는 데이터 ["+cnt+"] \r\n");
								cnt++;
								bw.flush();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							try {
								socket.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
