/**
 * 
 */
package com.seu.wsn.Core.Pojo;

/**
 * 
 * @ClassName: User 
 * @Description: �û���
 * @author: CSS
 * @date: 2016-10-23 ����11:24:29
 */
public class User {
	private String userName;			//�û���
	private String pwd;					//�û�����
	private String registerDate;		//ע������
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
	public String getRegisterDate() {
		return registerDate;
	}
	/**
	 * 
	 * @param registerDate
	 */
	public void setRegisterDate(String registerDate) {
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
