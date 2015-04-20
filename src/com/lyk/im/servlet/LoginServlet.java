package com.lyk.im.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyk.im.dao.UserInfoDao;
import com.lyk.im.service.LoginService;

public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse respone) {
		System.out.println("doGet");
		doPost(request, respone);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse respone) {
		System.out.println("doPost");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String ip = request.getParameter("ip");
		String result = "id: " + id + 
				" password: " + password +
				" ip: " + ip;
		System.out.println(result);
		PrintWriter writer = null;
		String path = getServletContext().getRealPath("/");
		try {
			writer = respone.getWriter();
			writer.write(LoginService.getServletMessage(path, id, password));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		
	}
	
}