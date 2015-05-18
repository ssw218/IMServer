package com.lyk.im.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lyk.im.dao.PrimeNumberDao;
import com.lyk.im.service.EncryptionService;
import com.lyk.im.util.RSAManager;
import com.lyk.im.util.RSAManager.KR;
import com.lyk.im.util.RSAManager.KU;
import com.lyk.im.util.RSAManager.Primes;

public class RSATest {
	

	public static void main(String[] args) {
		String text = "user:15620519921 password:123456";
		
		for (int i = 0; i < 1; i ++) {
			long time = System.currentTimeMillis();
			EncryptionService service = new EncryptionService();
			service.createKeys();
			service.encryption(text);
//			System.out.println(System.currentTimeMillis() - time);
		}
	}
	
	
	
	public static void allocKey() {
		// n = p * q;
		// e (p - 1) * (q - 1)
		// (e * d) mod ((p - 1) * (q - 1)) = 1
		
	}

	
	
}
