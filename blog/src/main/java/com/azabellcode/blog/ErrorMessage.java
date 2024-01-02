package com.azabellcode.blog;

import java.util.HashMap;
import java.util.Map;

public enum ErrorMessage {
    //CODE 선언
	CODE_400("RESPONSE", "400", "Bad Request"),
	CODE_401("RESPONSE", "401", "Unauthorized"),
	CODE_402("RESPONSE", "402", "Payment Required"),
	CODE_403("RESPONSE", "403", "Forbidden"),
	CODE_404("RESPONSE", "404", "Not Found"),
	CODE_405("RESPONSE", "405", "Method Not Allowed"),
	CODE_406("RESPONSE", "406", "Not Acceptable"),
	CODE_408("RESPONSE", "408", "Request Timeout"),
	CODE_409("RESPONSE", "409", "Conflict"),
	CODE_413("RESPONSE", "412", "Payload Too Large"),
	CODE_423("RESPONSE", "423", "Locked"),
	CODE_428("RESPONSE", "428", "Precondition Required"),
	CODE_429("RESPONSE", "429", "Too Many Requests"),
	CODE_500("RESPONSE", "500", "server Error"),

	CODE_101("RESPONSE", "101", "본인의 휴대폰에서만 로그인이 가능합니다. 관리자에게 문의하세요."),
	CODE_102("RESPONSE", "102", "등록된 휴대폰 정보가 존재하지 않아 현재의 휴대폰 정보로 갱신하였습니다."),
	CODE_103("RESPONSE", "103", "조회된 데이터가 존재하지 않습니다."),
	CODE_104("RESPONSE", "104", "게시판이 존재하지 않습니다."),

	CODE_200("RESPONSE", "200", "Ok"),
	CODE_201("RESPONSE", "201", "Created"),
	CODE_202("RESPONSE", "202", "Accepted"),
	CODE_203("RESPONSE", "203", "No Content"),

	CODE_ADM000_1("API", "LGD1000_1",   "아이디 혹은 비밀번호가 일치하지 않습니다."),
	CODE_ADM1000_2("API", "LGD1000_2",  "개인회원의 로그인을 이용해 주시기 바랍니다."),
	CODE_ADM1000_3("API", "LGD1000_3",  "청음복지관 회원의 로그인을 이용해 주시기 바랍니다."),
	
	
	CODE_JOB1000_1("API", "JOB1000_1", "이미 생성된 계좌가 존재합니다."),
	
	CODE_SUCCESS("API", "000", "정상적으로 처리되었습니다."),
	
    CODE_AUTH("API", "-002", "해당 메뉴에 대한 권한이 없습니다."),
	CODE_DELETE("API", "000", "정상적으로 삭제 처리되었습니다."),
	CODE_FALSE("API", "-001", "처리 중 오류가 발생하였습니다.");
	
	private String type;  //타입
    private String code;  //코드
    private String message; //메시지

    private ErrorMessage(String type,String code, String message) {
	  this.type = type;
      this.code = code;
      this.message = message;
    }

	public String getMessage() {
       return this.message;
    }

    public String getCode() {
       return this.code;
    }
    
    public String getType() {
        return this.type;
    }
    
    /**
	 * 코드관리 code로 message 가져오기 
	 */
  	public static String getMessage(String code) {
  		
  		ErrorMessage data = ErrorMessage.valueOf("CODE_" + code);
  		String resultMsg = data.getMessage();
  		
  		return resultMsg;
  	}
  	
  	 /**
	 * 코드관리 code로 code 가져오기 
	 */
  	public static String getCode(String code) {
  		
  		ErrorMessage data = ErrorMessage.valueOf("CODE_" + code);
  		String resultMsg = data.getCode();
  		
  		return resultMsg;
  	}
  	
  	/**
	 * responseReturn() 코드 관리
	 * @param String code
	 * @return "map"
	 */
	public static Map<Object, Object> responseReturn(String code) {
		
	    Map<Object, Object> map = new HashMap<Object, Object>();  
	    map.put("rtnCode", getCode(code));
	    map.put("retMessage", getMessage(code));
		
		return map;
	}
}
