package com.Fred.Mike.Zingui;

/**
*@author Zingui Fred Mike
*@description Il s'agit de l'objet qui va nous permettre de génerer un Hash avec SHA256
*@version 1.01
*/
import java.util.*;
import java.security.*;
import java.lang.RuntimeException;
import java.lang.Exception;

public class HashUtil{

	/**
		 * Applies SHA-256 hashing to the given input string.
		 *
		 * @param data The string to be hashed.
		 * @return The SHA-256 hash of the input string.
		 * @throws NoSuchAlgorithmException If the SHA-256 algorithm is not supported.
		 */
	public static String ApplySha256(String sent){
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(sent.getBytes("UTF-8"));
			StringBuffer HexString = new StringBuffer();
			for(int i=0;i<hash.length;i++){

				String hex = Integer.toHexString(0xff & hash[i]);
				if(hash.length==1) HexString.append("0");
				HexString.append(hex);
			}
			return HexString.toString();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	};


}
