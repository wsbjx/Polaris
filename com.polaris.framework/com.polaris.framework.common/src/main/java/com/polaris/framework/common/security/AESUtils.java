package com.polaris.framework.common.security;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * AES加密解密工具类
 * 
 * @author wang.sheng
 * 
 */
final class AESUtils
{
	private static final String ALGORITHM = "AES";
	private static final int KEY_SIZE = 128;

	private AESUtils()
	{
	}

	/**
	 * <p>
	 * 生成随机密钥
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getSecretKey() throws Exception
	{
		return getSecretKey(null);
	}

	/**
	 * <p>
	 * 生成密钥
	 * </p>
	 * 
	 * @param seed
	 *            密钥种子
	 * @return
	 * @throws Exception
	 */
	public static String getSecretKey(String seed) throws Exception
	{
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
		SecureRandom secureRandom;
		if (!StringUtils.isEmpty(seed))
		{
			secureRandom = new SecureRandom(seed.getBytes());
		}
		else
		{
			secureRandom = new SecureRandom();
		}
		keyGenerator.init(KEY_SIZE, secureRandom);
		SecretKey secretKey = keyGenerator.generateKey();
		return Base64.encodeBase64String(secretKey.getEncoded());
	}

	/**
	 * <p>
	 * 加密
	 * </p>
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String key) throws Exception
	{
		Key k = toKey(Base64.decodeBase64(key));
		byte[] raw = k.getEncoded();
		SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		return cipher.doFinal(data);
	}

	/**
	 * <p>
	 * 解密
	 * </p>
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String key) throws Exception
	{
		Key k = toKey(Base64.decodeBase64(key));
		byte[] raw = k.getEncoded();
		SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		return cipher.doFinal(data);
	}

	/**
	 * <p>
	 * 转换密钥
	 * </p>
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception
	{
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		return secretKey;
	}

}