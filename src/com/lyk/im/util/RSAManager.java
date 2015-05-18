package com.lyk.im.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lyk.im.dao.PrimeNumberDao;

public class RSAManager {
	
	private static final Long DOWN_PRIME = (long) 100;
	private static final Long UP_PRIME = (long) 999;
	private static final Long DOWN_E = (long) 100;
	private static final Long UP_E = (long) 999;
	private static final Long UP_2 = (long) 999999;
	
	static class Key {
		public long n;
	}
	
	public static class KU extends Key {
		public long e;
	}
	
	public static class KR extends Key {
		public long d;
	}
	
	public static class Primes {
		public Long p;
		public Long q;
	}
	
	public static Primes getRandomPrimes() {
		List<Long> list = new ArrayList<Long>();
		
		boolean isPrime;
		for (Long i = DOWN_PRIME; i < UP_PRIME; i++) {
			isPrime = true;
			for (long j = 2; j < Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				list.add(i);
			}
		}
		
		Random random = new Random();
		int id1, id2;
		do {
			id1 = random.nextInt(list.size());
			id2 = random.nextInt(list.size());
		} while (id1 == id2);
		
		Primes primes = new Primes();
		primes.p = list.get(id1);
		primes.q = list.get(id2);
		return primes;
	}
	
	public static KU getRandomKU(long m) {
		ArrayList<Long> list = new ArrayList<Long>();

		for (long i = DOWN_E; i < UP_E; i++) {
			long remainder = 0;
			long a = m, b = i, temp;

			do {
				remainder = a % b;
				temp = b;
				b = a / b;
				a = b;
			} while (remainder != 0);

			if (a == 1) {
				list.add(i);
			}
		}
//		System.out.println(list.size());
		Random random = new Random();
		int index = random.nextInt(list.size());
//		System.out.println(index + " e " + list.get(index));
		
		KU ku = new KU();
		ku.e = list.get(index);
		
		return ku;
	}
	
	public static KR getRandomKR(long m, long e) {
		ArrayList<Long> list = new ArrayList<Long>();
		// (e * d) mod ((p - 1) * (q - 1)) = 1
		for (long i = DOWN_PRIME; i < UP_2; i++) {
//			System.out.println((i * ku.e) % m);
			if ((i * e) % m == 1) {
//				System.out.println("d " + i);
				list.add(i);
			}
		}
		if (list.isEmpty()) return null;
		
		KR kr = new KR();
		Random random = new Random();
		kr.d = list.get(random.nextInt(list.size()));
		return kr;
	}
	
}
