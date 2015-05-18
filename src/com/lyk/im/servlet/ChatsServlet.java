package com.lyk.im.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyk.im.service.ChatService;

public class ChatsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse respone)
			throws ServletException, IOException {
		ChatService chatService = ChatService.getInstance();
		chatService.start();
	}

}
