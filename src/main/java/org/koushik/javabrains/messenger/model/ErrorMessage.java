package org.koushik.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private int errorCode;
	private String documentatiom;
	public ErrorMessage(){
		
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentatiom() {
		return documentatiom;
	}
	public void setDocumentatiom(String documentatiom) {
		this.documentatiom = documentatiom;
	}
}
