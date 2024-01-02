package com.azabellcode.blog.util;

import java.lang.reflect.Method;
import java.util.Map;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.List;

@Component
public class Utilities {
    	final static Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
        
    /**
	 * front에서 넘긴 userPrvdIdTk, lastLgnIp 명을 HttpServletRequest 객체에 저장
	 * @param so
	 */
	public static void setDefaultValue(Map<String, Object> so) {
		HttpServletRequest request = getRequest();
		// 사용자계정ID 대체키
		String userPrvdIdTk = "";
		if(Utilities.isNotEmpty(so.get("userPrvdIdTk"))) {
			userPrvdIdTk = Util.getDecodedBase64((String)so.get("userPrvdIdTk"));
			so.put("userPrvdIdTk", userPrvdIdTk);
			request.setAttribute("userPrvdIdTk", userPrvdIdTk);	
		}
		// 접속IP
		if(Utilities.isNotEmpty(so.get("cntnIp"))) {
			request.setAttribute("cntnIp", (String)so.get("cntnIp"));
		}
		// 접속메뉴(프로그램)
		String prgrm = UrlUtil.getProgramId().toUpperCase();
		if(!prgrm.equals("menu")) {
			request.setAttribute("prgrm", prgrm);
		}
	} // setDefaultValue()

    public static HttpServletRequest getRequest() {
		try {
			ServletRequestAttributes servletContainer = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			if(servletContainer != null) {
				return servletContainer.getRequest();
			} else {
				return null;
			}
		} catch(IllegalStateException e) {
			LOGGER.error("info to IllegalStateException : ", Thread.currentThread().getStackTrace()[1].getLineNumber());
			return null;
		} catch(Exception ex) {
			LOGGER.error("info to Exception : ", Thread.currentThread().getStackTrace()[1].getLineNumber());
			return null;
		}
	} // getRequest()

    public static boolean isNotEmpty(Object obj) {
		return !Utilities.isEmpty(obj);
	} // isNotEmpty

    @SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if(obj == null) {
			return true;
		} else if((obj instanceof String)) {
			return ((String) obj).isEmpty();
		} else if(obj instanceof Map) {
			return ((Map<?, ?>) obj).isEmpty();
		} else if(obj instanceof Collection) {
			return ((Collection<?>) obj).isEmpty();
		} else if(obj instanceof Object[]) {
			return (((Object[]) obj).length == 0);
		} else if(obj instanceof File) {
			return !((File) obj).exists();
		} else if(obj instanceof List) {
			return ((List) obj).size() == 0;
		} else if(obj instanceof Object) {
			return obj == null;
		}
		try {
			Method method = obj.getClass().getMethod("isEmpty", (Class<?>[]) null);
			return (Boolean) method.invoke(obj);
		} catch(IllegalArgumentException e) {
			LOGGER.error("info to IllegalArgumentException: ", e);
			return false;
		} catch(Exception ex) {
			LOGGER.error("info to Exception: ", ex);
			return false;
		}
	} // isEmpty()

}
