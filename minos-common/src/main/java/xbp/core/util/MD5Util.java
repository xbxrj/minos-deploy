package xbp.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author junsu.zhang
 *
 */
public class MD5Util {
	
	public static String generateMD5code(String password) {
		
		StringBuilder md5Str  = null;
		try {
            // 创建加密对象
			MessageDigest messageDigest=MessageDigest.getInstance("md5");
            // 加密
			byte[] bs = messageDigest.digest(password.getBytes());
			
			md5Str = new StringBuilder(40);
	        for(byte x:bs) {
	            if((x & 0xff)>>4 == 0) {
	            	md5Str.append("0").append(Integer.toHexString(x & 0xff));
	            } else {
	            	md5Str.append(Integer.toHexString(x & 0xff));
	            }
	        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5Str.toString();
	}
}
