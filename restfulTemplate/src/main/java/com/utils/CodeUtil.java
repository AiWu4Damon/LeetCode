package com.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 加解密工具类
 * 
 */
public class CodeUtil {

	/**
	 * DES算法密钥
	 */
	private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128,
			-65 };
	
	/**
	 * 核心DES算法密钥
	 */
	private static final String CORE_DES_KEY = "9E677BAC2FD4E30C";

	/**
	 * 数据加密，算法（DES）
	 * 
	 * @param data
	 *            要进行加密的数据
	 * @return 加密后的数据
	 */
	public static String encryptBasedDes(String data) {
		String encryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// 加密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			// 加密，并把字节数组编码成字符串
			encryptedData = new BASE64Encoder().encode(cipher.doFinal(data
					.getBytes()));
		} catch (Exception e) {
			// log.error("加密错误，错误信息：", e);
			throw new RuntimeException("加密错误，错误信息：", e);
		}
		return encryptedData;
	}

	/**
	 * 数据解密，算法（DES）
	 * 
	 * @param cryptData
	 *            加密数据
	 * @return 解密后的数据
	 */
	public static String decryptBasedDes(String cryptData) {
		String decryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// 解密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			// 把字符串解码为字节数组，并解密
			decryptedData = new String(
					cipher.doFinal(new sun.misc.BASE64Decoder()
							.decodeBuffer(cryptData)));
		} catch (Exception e) {
			// log.error("解密错误，错误信息：", e);
			throw new RuntimeException("解密错误，错误信息：", e);
		}
		return decryptedData;
	}

	/**
	 * 核心数据加密，算法（DES）
	 * 
	 * @param strMing
	 *            要进行加密的数据
	 * @return 加密后的数据
	 */
	public static String getEncString(String strMing) 
	{
		byte[] byteMi = null; 
		byte[] byteMing = null; 
		String strMi = ""; 
		BASE64Encoder base64en = new BASE64Encoder(); 
		try 
		{ 
			Key key;
			byteMing = strMing.getBytes("UTF8");
			KeyGenerator _generator = KeyGenerator.getInstance("DES"); 
			_generator.init(new SecureRandom(CORE_DES_KEY.getBytes())); 
			key = _generator.generateKey(); 
			_generator=null; 
			Cipher cipher = Cipher.getInstance("DES"); 
			cipher.init(Cipher.ENCRYPT_MODE, key); 
			byteMi = cipher.doFinal(byteMing); 
			
			strMi = base64en.encode(byteMi); 
		} 
		catch(Exception e) 
		{ 
			throw new RuntimeException("加密错误，错误信息：", e);
		} 
		finally 
		{ 
			base64en = null; 
			byteMing = null; 
			byteMi = null; 
		} 
		return strMi; 
	}

	// 创建Base64对象,用于加密和解密;
	private final static Base64 base64 = new Base64();

	// 加密时采用的编码方式;
	private final static String encoding = "UTF-8";

	/**
	 * 基于MD5算法的非对称加密(无解密算法)
	 * 
	 * @param strSrc
	 *            明文
	 * @return 返回密文
	 */
	public static String encryptMd5(String strSrc) {
		String outString = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] outByte = md5.digest(strSrc.getBytes("UTF-8"));
			outString = outByte.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outString;
	}

	/**
	 * 用Base64对加密好的byte数组进行编码，返回字符串
	 * 
	 * @param str
	 *            需要加密的字符串
	 * @param sKey
	 *            加密密钥
	 * @return 经过加密的字符串
	 */
	public static String encryptBase64(String str, String sKey) {
		// 声明加密后的结果字符串变量
		String result = str;
		if (str != null && str.length() > 0 && sKey != null
				&& sKey.length() >= 8) {
			try {
				// 调用DES 加密数组的 encrypt方法，返回加密后的byte数组;
				byte[] encodeByte = encryptBasedDes(str.getBytes(encoding),
						sKey);
				// 调用base64的编码方法，返回加密后的字符串;
				result = base64.encodeToString(encodeByte).trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 用Base64对字符串进行编码，返回byte数组
	 * 
	 * @param str
	 *            需要解密的字符串
	 * @param sKey
	 *            解密密钥
	 * @return 经过解密的字符串
	 */
	public static String decryptBase64(String str, String sKey) {
		String result = str;
		if (str != null && str.length() > 0 && sKey != null
				&& sKey.length() >= 8) {
			try {
				// 用base64进行编码，返回byte数组
				byte[] encodeByte = base64.decode(str);
				// 调用DES 解密数组的decrypte方法，返回解密后的数组;
				byte[] decoder = decryptBasedDes(encodeByte, sKey);
				// 对解密后的数组转化成字符串
				result = new String(decoder, encoding).trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 先用DES算法对byte[]数组加密
	 * 
	 * @param byteSource
	 *            需要加密的数据
	 * @param sKey
	 *            加密密钥
	 * @return 经过加密的数据
	 * @throws Exception
	 */
	private static byte[] encryptBasedDes(byte[] byteSource, String sKey)
			throws Exception {
		try {
			// 声明加密模式;
			int mode = Cipher.ENCRYPT_MODE;
			// 创建密码工厂对象;
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// 把字符串格式的密钥转成字节数组;
			byte[] keyData = sKey.getBytes();
			// 以密钥数组为参数，创建密码规则
			DESKeySpec keySpec = new DESKeySpec(keyData);
			// 以密码规则为参数，用密码工厂生成密码
			Key key = keyFactory.generateSecret(keySpec);
			// 创建密码对象
			Cipher cipher = Cipher.getInstance("DES");
			// 以加密模式和密码为参数对密码对象 进行初始化
			cipher.init(mode, key);
			// 完成最终加密
			byte[] result = cipher.doFinal(byteSource);
			// 返回加密后的数组
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 先用DES算法对byte[]数组解密
	 * 
	 * @param byteSource
	 *            需要解密的数据
	 * @param sKey
	 *            解密密钥
	 * @return 经过解密的数据
	 * @throws Exception
	 */
	private static byte[] decryptBasedDes(byte[] byteSource, String sKey)
			throws Exception {
		try {
			// 声明解密模式;
			int mode = Cipher.DECRYPT_MODE;
			// 创建密码工厂对象;
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// 把字符串格式的密钥转成字节数组;
			byte[] keyData = sKey.getBytes();
			// 以密钥数组为参数，创建密码规则
			DESKeySpec keySpec = new DESKeySpec(keyData);
			// 以密码规则为参数，用密码工厂生成密码
			Key key = keyFactory.generateSecret(keySpec);
			// 创建密码对象
			Cipher cipher = Cipher.getInstance("DES");
			// 以加密模式和密码为参数对密码对象 进行初始化
			cipher.init(mode, key);
			// 完成最终解密
			byte[] result = cipher.doFinal(byteSource);
			// 返回解密后的数组
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 测试对称加密算法
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		String sKey = "mowen520";
//		String str = "111111";
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
//				"yyyy-MM-dd HH:mm:ss");
//		String strDate = simpleDateFormat.format(date);
//		long start = System.currentTimeMillis();
//		System.out.println("开始时间：" + strDate + "   毫秒数：" + start);
//		for (int i = 0; i < 1; i++) {
//			String strEncrypto = CodeUtil.encryptBase64(str, sKey);
//			System.out.println("被加密的字符串：" + str + "\r\n加密后的结果：" + strEncrypto);
//			String strDecrypto = CodeUtil.decryptBase64(strEncrypto, sKey);
//			System.out.println("解密后的结果：" + strDecrypto);
//		}
//		Date date2 = new Date(System.currentTimeMillis());
//		String strDate2 = simpleDateFormat.format(date2);
//		long start2 = System.currentTimeMillis();
//		System.out.println("结束时间：" + strDate2 + "   毫秒数：" + start2);
//		long time = start2 - start;
//		System.out.println("间隔时间：" + time);x16YjoF1LNE= x16YjoF1LNE= P8Pfz23x8JI=
		System.out.println(CodeUtil.encryptBasedDes("1"));
	}

}
