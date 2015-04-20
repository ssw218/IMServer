package com.lyk.im.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocketClientTest {

	public static void main(String[] args) {
		SocketClientTest s = new SocketClientTest();
		s.start();
	}
	
	public void start() {
		try {
			BufferedReader inputReader;
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			String inputContent;
			while(!(inputContent = inputReader.readLine()).equals("bye")) {
				System.out.println(inputContent);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
