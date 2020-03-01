package com.nf.wanjiamall.exception;


/**
 * 程序异常处理
 * @author Sam
 */
public class AppException extends RuntimeException {

	public AppException() { super(); };

	public AppException(String message) {
		super(message);
	};

	public AppException(String message, Throwable cause) {
		super(message, cause);
	};
}
