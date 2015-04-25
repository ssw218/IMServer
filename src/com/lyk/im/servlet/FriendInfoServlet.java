package com.lyk.im.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyk.im.service.LoginService;

public class FriendInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		doPost(request, respone);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		respone.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String path = getServletContext().getRealPath("/");
		PrintWriter writer = respone.getWriter();
		writer.write(LoginService.getFriendMessage(path, id));
		writer.flush();
	}

}
