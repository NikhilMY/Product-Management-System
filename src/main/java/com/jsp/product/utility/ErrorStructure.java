package com.jsp.product.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure {
	private int statuscode;
	private String errorMessage;
	private Object rootcause;
	
	public int getStatuscode() {
		return statuscode;
	}
	public ErrorStructure setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;

	}
	public Object getRootcause() {
		return rootcause;
	}
	public ErrorStructure setRootcause(Object rootcause) {
		this.rootcause = rootcause;
		return this;

	}
	@Override
	public String toString() {
		return "ErrorStructure [statuscode=" + statuscode + ", errorMessage=" + errorMessage + ", rootcause="
				+ rootcause + "]";
	}

}
