/**
 * 
 */
package com.seu.wsn.Model.Pojo;

import java.util.Date;

/**
 * @author CSS
 * �û���
 */
public class User {
	private String userName;			//�û���
	private String pwd;					//�û�����
	private Date registerDate;			//ע������
	private boolean onLine;				//�Ƿ�����
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * @return
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 
	 * @param passWord
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 
	 * @return
	 */
	public Date getRegisterDate() {
		return registerDate;
	}
	/**
	 * 
	 * @param registerDate
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isOnLine() {
		return onLine;
	}
	/**
	 * 
	 * @param admin
	 */
	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}
	
	

}
