package com.http.Utilities;

public class ReponseFormatter 
{
	private String responsePayload;
	private int statusCode;
	
	public String getResponsePayload() {
		return responsePayload;
	}
	public int getStatusCode() {
		return statusCode;
	}
	
	public ReponseFormatter(int code, String body)
	{
		this.statusCode = code;
		this.responsePayload = body;
	}
	
	public String toString()
	{
		return String.format("Status code : %1s and Response Payload is : %2s ", this.statusCode, this.responsePayload);
	}
	

}
