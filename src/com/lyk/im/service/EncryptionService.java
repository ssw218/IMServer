package com.lyk.im.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.lyk.im.dao.PrimeNumberDao;
import com.lyk.im.util.RSAManager;
import com.lyk.im.util.RSAManager.KR;
import com.lyk.im.util.RSAManager.KU;
import com.lyk.im.util.RSAManager.Primes;

public class EncryptionService {
	private KU ku;
	private KR kr;
	
	public void createKeys() {
		Primes primes = RSAManager.getRandomPrimes();
		long n = primes.p * primes.q;
		long m = (primes.p - 1) * (primes.q - 1);
		
		KU ku = null;
		KR kr = null;
		
		while (kr == null) {
			ku = RSAManager.getRandomKU(m);
			ku.n = n;

			kr = RSAManager.getRandomKR(m, ku.e);
		}
		
		kr.n = n;
		
		this.ku = ku;
		this.kr = kr;
		
		System.out.println("Primes : " + primes.p + " " + primes.q);
		System.out.println("KU : " + ku.e + " " + ku.n);
		System.out.println("KR : " + kr.d + " " + kr.n);
		
	}
	
	public void encryption(String text) {
		long e = pow(2, ku.e) % ku.n;
		System.out.println(e);
		long d = pow(e, kr.d) % kr.n;
		System.out.println(d);
	}
	
	long pow(long a, long b) {
		long result = 1;
		for(long i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
	
	
	// put prime numbers between 100000~999999 into Text or SQL, use at first and just once
	public static void putIntoSQL() {
		List<Long> primes = new ArrayList<Long>();
		FileOutputStream output = null;
		PrintWriter writer = null;
		PrimeNumberDao primeNumberDao = new PrimeNumberDao();
		boolean isPrime;
		File file = new File("E:/Primes.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			output = new FileOutputStream(file);
			writer = new PrintWriter(output);
			for (long i = 100; i < 999; i++) {
				isPrime = true;
				for (long j = 2; j < Math.sqrt(i); j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					primes.add(i);
					//writer.println(i);
					primeNumberDao.insert(i);
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			try {
				output.close();
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(primes.size());
		}
	}
}
