package com.lyk.im.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

public class ImageService {
	
	private static final String IMAGE_FORMAT = "png";
	
	public static byte[] imageToByte(String rpath, String photo) {
		String path = rpath + "\\Photo\\" + photo;
		FileInputStream inputStream = null;
		BufferedImage image = null;
		ByteArrayOutputStream outputStream = null;
		byte[] imageByte = null; 
		try {
			inputStream = new FileInputStream(path);
			image = ImageIO.read(inputStream);
			outputStream = new ByteArrayOutputStream();
			boolean result = ImageIO.write(image, IMAGE_FORMAT, outputStream);
			imageByte = outputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return imageByte;
	}

	public static void saveImage(byte[] imageByte, String path) {
		System.out.println("Save image at path : " + path);
		FileImageOutputStream outputStream = null;
		File file = new File(path);
		try {
			outputStream = new FileImageOutputStream(file);
			outputStream.write(imageByte);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
