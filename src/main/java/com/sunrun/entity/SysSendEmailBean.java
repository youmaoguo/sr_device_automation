package com.sunrun.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SysSendEmailBean {
	
    String  mailTitle="";
    String mailContxt ="";
    public  ArrayList mailConsignee = new ArrayList();
  
     public String getMailTitle() {
		return mailTitle;
	}

 
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

 
	public String getMailContxt() {
		return mailContxt;
	}

 
	public void setMailContxt(String mailContxt) {
		this.mailContxt = mailContxt;
	}


 
	public   class MailConsignee{
    	 
    	String mailConsigneeName="";
        String mailConsigneeEmail="";
        Integer mailConsigneeSelected=1;
        
        
        
		public String getMailConsigneeName() {
			return mailConsigneeName;
		}
		public void setMailConsigneeName(String mailConsigneeName) {
			this.mailConsigneeName = mailConsigneeName;
		}
		public String getMailConsigneeEmail() {
			return mailConsigneeEmail;
		}
		public void setMailConsigneeEmail(String mailConsigneeEmail) {
			this.mailConsigneeEmail = mailConsigneeEmail;
		}
		public Integer getMailConsigneeSelected() {
			return mailConsigneeSelected;
		}
		public void setMailConsigneeSelected(Integer mailConsigneeSelected) {
			this.mailConsigneeSelected = mailConsigneeSelected;
		}
        
        
        }
}
