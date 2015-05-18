package com.lyk.im.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyk.im.bean.UserBean;
import com.lyk.im.service.RegisterService;

public class RegisterServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse respone) {
		doPost(request, respone);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse respone) {
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String ip = request.getParameter("ip");
//		String result = "id: " + id + 
//				" password: " + password +
//				" ip: " + ip;
//		System.out.println(result);
		UserBean user = new UserBean();
		String path = getServletContext().getRealPath("/");
		PrintWriter writer = null;
		try {
			writer = respone.getWriter();
			if (RegisterService.doRegister(path, user))
				writer.write("success");
			else
				writer.write("failure");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		
	}
}
 