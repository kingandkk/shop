package com.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.util.Base64Utils;


/**
 * 安全工具类
 */
public class SafeUtil {
	
	/**
	 * md5加密字符串
	 * @param str
	 * @return
	 */
	public final static String md5(String str){
		if (Objects.isNull(str) || str.isEmpty()) {
			return null;
		}
		MessageDigest messageDigest = null;
		try {
			//生成一个MD5加密计算摘要
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//计算MD5函数
		messageDigest.update(str.getBytes());
		//digest()确认返回MD5的hash值
		return Base64Utils.encodeToString(messageDigest.digest());
	}
	
	/**
	 * sha1(安全hash算法)加密字符串
	 * @param str
	 * @return
	 */
	public final static String sha1(String str){
		if (Objects.isNull(str) || str.isEmpty()) {
			return null;
		}
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.update(str.getBytes());
		return Base64Utils.encodeToString(messageDigest.digest());
	}

	/**
	 * 使用特定加密范式加密
	 * @param str
	 * @return
	 */
	public final static String encode(String str){
		return md5(sha1(md5(str)));
	}
	
}
