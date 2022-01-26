package kr.co.jsh.test.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 전상훈
 * 
 * 소켓을 통해 클라이언트를 만들자
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket socket = new Socket("localhost", 80);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			new Thread() {
				public void run() {
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					try {
						while(true) {
							String readLine = br.readLine();
							if(readLine == null) break;
							System.out.println("클라이언트가 받은 데이터 ::: "+readLine);
						}
					} catch (IOException e) {
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
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							bw.write("클라이언트에서 전송하는 데이터 ["+cnt+ "] \r\n");
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
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
