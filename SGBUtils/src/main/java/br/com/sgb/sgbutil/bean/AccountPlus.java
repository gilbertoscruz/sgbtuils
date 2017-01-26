/**
 * 
 */
package br.com.sgb.sgbutil.bean;

import android.accounts.Account;

/**
 * @author egilcru
 *
 */
public class AccountPlus extends Account {

	private String password;

	/**
	 * @param name
	 * @param type
	 */
	public AccountPlus(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
