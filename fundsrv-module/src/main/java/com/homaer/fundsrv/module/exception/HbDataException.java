package com.homaer.fundsrv.module.exception;

public class HbDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8096047424463343731L;
	
	public HbDataException(String code) {
        super(code);
        alarm(code);
    }
	private void alarm(String code){
        //logger.error("code="+code+";msg="+ ErrCode.codeToMsg(code));

        //报警
    }
}
