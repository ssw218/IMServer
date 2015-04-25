package com.lyk.im.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyk.im.service.ImageService;

public class PhotoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		System.out.println("PhotoServlet: doGet");
		doPost(request, respone);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		System.out.println("PhotoServlet: doPost");
		String photo = request.getParameter("photo");
		String path = getServletContext().getRealPath("/");
		byte[] imageByte = ImageService.imageToByte(path, photo);
		ServletOutputStream output = respone.getOutputStream();
		output.write(imageByte);
		output.flush();
		System.out.println(imageByte.length + " " +Arrays.toString(imageByte));
	}

}
