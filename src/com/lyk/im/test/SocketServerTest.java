package com.lyk.im.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

	public static void main(String[] args) {
		SocketServerTest socketServer = new SocketServerTest();
		socketServer.startServer();
	}
	
	public void startServer() {
		ServerSocket serverSocket;
		BufferedReader reader;
		try {
			serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String receivedMsg;
			while((receivedMsg = reader.readLine()) != null) {
				System.out.println(receivedMsg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
