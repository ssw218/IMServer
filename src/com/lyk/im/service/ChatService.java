package com.lyk.im.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.lyk.im.net.TCPServer;

public class ChatService {
	private static int PORT = 12345;
	private static ChatService mChatService;
	private TCPServer mTCPServer;
	private TCPThread mTCPThread;

	class TCPThread extends Thread {
		
		public TCPThread() {
			super(); 
		}
		
		@Override
		public void run() {
			while (!isInterrupted()) {
				try {
					Iterator<SelectionKey> keys = mTCPServer.getSelectionKeys();
					while (keys.hasNext()) {
						try {
							SelectionKey key = keys.next();
							if (key.isAcceptable()) {
								// put it at a list
								mTCPServer.onAccept(key);
							} else if (key.isReadable()) {
								// read message
								mTCPServer.onRead(key);
							}
							if (key.isValid() && key.isWritable()) {
								// write message
								mTCPServer.onWrite(key);
							}
						} catch (IOException e) {
							System.out.println("1 IO expection");
						} finally {
							keys.remove();
						}
					}
				} catch (IOException e) {
					System.out.println("2 IO expection");
					continue;
				}
			}
			mTCPThread = new TCPThread();
			mTCPThread.start();
		}

	}

	
	private ChatService() {
		mTCPServer = TCPServer.getInstance();
	}
	
	public static ChatService getInstance() {
		if (mChatService == null)
			mChatService = new ChatService();
		return mChatService;
	}
	
	public void start() {
		System.out.println("Chat service start");
		mTCPThread = new TCPThread();
		mTCPThread.start();
	}
	
}
