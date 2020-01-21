package com.mantabs.collection.master.area_assignment.view;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Testing {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String password = "sangat rahasia sekali";
        
		// generate random salt
		SecureRandom randomizer = new SecureRandom();
		BigInteger random = new BigInteger(32, randomizer);
		String salt = random.toString(64);

		int perulangan = 1000;
		String algoritma = "PBKDF2WithHmacSHA1";
		int panjangKey = 256;

		PBEKeySpec keyspec = new PBEKeySpec(password.toCharArray(), salt.getBytes("UTF-8"), perulangan, panjangKey);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritma);
		SecretKey key = keyFactory.generateSecret(keyspec);

		System.out.println("Password asli : "+password);
		System.out.println("Salt : "+salt);
		System.out.println("Generated Key : " + Base64.encodeBase64String(key.getEncoded()));
		
	}

}
