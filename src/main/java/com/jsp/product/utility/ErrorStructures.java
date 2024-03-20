package com.jsp.product.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructures<T> {
	
	private int statuscode;
	private String errorMessage;
	private T errorData;
	
	public int getStatuscode() {
		return statuscode;
	}
	public ErrorStructures<T> setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructures<T> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;

	}
	public T getErrorData() {
		return errorData;
	}
	public ErrorStructures<T> setErrorData(T errorData) {
		this.errorData = errorData;
		return this;

	}
	@Override
	public String toString() {
		return "ErrorStructure [statuscode=" + statuscode + ", errorMessage=" + errorMessage + ", errorData="
				+ errorData + "]";
	}

}




//public class ErrorStructure<T> {
//private int statuscode;
//private String errorMessage;
//private T errorData;
//
//public int getStatuscode() {
//	return statuscode;
//}
//public ErrorStructure<T> setStatuscode(int statuscode) {
//	this.statuscode = statuscode;
//	return this;
//}
//public String getErrorMessage() {
//	return errorMessage;
//}
//public ErrorStructure<T> setErrorMessage(String errorMessage) {
//	this.errorMessage = errorMessage;
//	return this;
//
//}
//public T getErrorData() {
//	return errorData;
//}
//public ErrorStructure<T> setErrorData(T errorData) {
//	this.errorData = errorData;
//	return this;
//
//}
//@Override
//public String toString() {
//	return "ErrorStructure [statuscode=" + statuscode + ", errorMessage=" + errorMessage + ", errorData="
//			+ errorData + "]";
//}
//
//
//
//}