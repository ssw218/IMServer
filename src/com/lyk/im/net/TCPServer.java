package com.lyk.im.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TCPServer implements TCPControl {
	private static final int PORT = 12345;
	private static final int TIME_OUT = 3000;
	private static final int CHAR_BUFFER_SIZE = 200;
	private static final int BYTE_BUFFER_SIZE = 417;
	
	private static final int MESSAGE_TYPE_HEART = 0;
	private static final int MESSAGE_TYPE_TEXT = 1;
	
	private static TCPServer mServer;
	private Selector mSelector = null;
	private ServerSocketChannel mServerChannel = null;
	
	private volatile Map<SelectionKey, Integer> mClientMap = 
			new HashMap<SelectionKey, Integer>();
	
	private volatile List<SocketMessage> mBufferList = new ArrayList<SocketMessage>();
	
	class SocketMessage {
		public int id;
		public ByteBuffer buffer;
	}
	
	private TCPServer() {
		try {
			mSelector = Selector.open();
			mServerChannel = ServerSocketChannel.open();
			mServerChannel.configureBlocking(false);
			bind(PORT);
			register();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Iterator<SelectionKey> getSelectionKeys() throws IOException {
		mSelector.select();
		Set<SelectionKey> keys = mSelector.selectedKeys();
		Iterator<SelectionKey> iter = keys.iterator();
		return iter;
	}
	
	void bind(int port) throws IOException {
		SocketAddress address = new InetSocketAddress(port);
		mServerChannel.socket().bind(address); 
	}
	
	void register() throws ClosedChannelException {
		mServerChannel.register(mSelector, SelectionKey.OP_ACCEPT);
	}
	
	public synchronized static TCPServer getInstance() {
		if (mServer == null)
			mServer = new TCPServer();
		return mServer;
	}

	@Override
	public void onAccept(SelectionKey key) throws IOException {
		SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
		channel.configureBlocking(false);
		channel.register(key.selector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(BYTE_BUFFER_SIZE));
	}

	@Override
	public void onRead(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(BYTE_BUFFER_SIZE);
		buffer.clear();
		int length = channel.read(buffer);
		if (length == -1)
			return ;
		
		buffer.flip();
		buffer.mark();
		int type = buffer.get();
		int id = buffer.get();
		buffer.reset();
		switch(type) {
		case MESSAGE_TYPE_HEART: {
			boolean has = false;
			for (Integer next : mClientMap.values()) {
				if (next.intValue() == id) {
					mClientMap.put(key, next);
					has = true;
					break;
				}
			}
			if (!has) {
				mClientMap.put(key, new Integer(id));
			}
			break; }
		case MESSAGE_TYPE_TEXT : {
			SocketMessage message = new SocketMessage();
			message.id = id;
			message.buffer = buffer;
			mBufferList.add(message);
			break; }
		} 
		key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
	}

	@Override
	public void onWrite(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		Integer id = mClientMap.get(key);
		if (id != null) {
			for (int i = 0; i < mBufferList.size(); i++) {
				if (mBufferList.get(i).id == id.intValue()) {
					channel.write(mBufferList.get(i).buffer);
					mBufferList.remove(i);
					i--;
				}
			}
		}
		key.interestOps(SelectionKey.OP_READ);
	}

}
