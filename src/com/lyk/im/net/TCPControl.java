package com.lyk.im.net;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.util.Iterator;

public interface TCPControl {
	
	public void onAccept (SelectionKey key) throws IOException;
	
	public void onRead (SelectionKey key) throws IOException;
	
	public void onWrite (SelectionKey key) throws IOException;
	
	public Iterator<SelectionKey> getSelectionKeys() throws IOException;
	
}
