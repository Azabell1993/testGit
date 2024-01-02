package com.azabellcode.blog.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Util {
	
	static Integer mode64 = 2; // 1: 미적용, 2: base64적용
    
    /**
	 * getPaging() paging 
	 * @param Integer offset, Integer limit
	 * @return Integer
	 */
	public static Integer getPaging(Integer offset, Integer limit) {
		Integer resultData = 1;
		resultData = ((offset * limit) - (limit - 1)) - 1;
		return resultData;
	}
	
	/**
	 * getPaging() paging 
	 * @param Integer offset
	 * @return Integer
	 */
	public static Integer getOffset(Integer offset) {
		Integer resultData = 1;
		resultData = (offset - 1);
		return resultData;
	}
	
	public static String getDecodedBase64(String obj) {
		String resultData = obj;
		
		if (mode64 == 2) {
			byte[] decodedBytes = Base64.getDecoder().decode(obj);
			resultData = new String(decodedBytes, StandardCharsets.UTF_8);
		}
		
		return resultData;
	}
	
	public static String setEncodedBase64(String obj) {
		String resultData = obj;
		
		if (mode64 == 2) {
			byte[] testToByte = obj.getBytes(StandardCharsets.UTF_8);
			String encodedString = Base64.getEncoder().encodeToString(testToByte);
			resultData = encodedString;
		}
		
		return resultData;
	}
}
