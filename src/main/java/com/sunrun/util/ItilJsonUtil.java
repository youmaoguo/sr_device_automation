package com.sunrun.util;

import java.util.Arrays;

public class ItilJsonUtil {
	
	private Integer ReturnCode;
	private ItilGenrequestBo GenRequest;
	private String[] Messages;
	
	public Integer getReturnCode() {
		return ReturnCode;
	}
	public void setReturnCode(Integer returnCode) {
		ReturnCode = returnCode;
	}
	public ItilGenrequestBo getGenRequest() {
		return GenRequest;
	}
	public void setGenRequest(ItilGenrequestBo genRequest) {
		GenRequest = genRequest;
	}
	public String[] getMessages() {
		return Messages;
	}
	public void setMessages(String[] messages) {
		Messages = messages;
	}
	@Override
	public String toString() {
		return "ItilRestfulUtil [ReturnCode=" + ReturnCode + ", GenRequest="
				+ GenRequest + ", Messages=" + Arrays.toString(Messages) + "]";
	}
	
	
	
}
