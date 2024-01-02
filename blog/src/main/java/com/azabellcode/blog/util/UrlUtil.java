package com.azabellcode.blog.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UrlUtil {
	protected static final Logger LOGGER = LoggerFactory.getLogger(UrlUtil.class);
	
	public static String getProgramId() {
		try {
			HttpServletRequest request = Utilities.getRequest();
			String rurl = request.getRequestURI(); // /api/adm013/selectTblSettlementList
			String[] url = rurl.split("/");
			String programId = url[2];
			return programId;
		} catch(RuntimeException e) {
			String errorResult = "info to RuntimeException(line:" + Thread.currentThread().getStackTrace()[1].getLineNumber() + ")";
			LOGGER.error(errorResult);
			return null;
		} catch (Exception ex) {
			String errorResult = "info to Exception(line:" + Thread.currentThread().getStackTrace()[1].getLineNumber() + ")";
			LOGGER.error(errorResult);
			return null;
		}
	}
}