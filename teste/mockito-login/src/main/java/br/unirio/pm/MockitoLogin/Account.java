package br.unirio.pm.MockitoLogin;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma conta de usuario em um sistema de login
 * 
 * @author PM
 */
public class Account
{
	private @Getter String userName;
	private String password;
	private @Getter @Setter boolean loggedIn;
	private @Getter @Setter boolean revoked;
	private @Getter @Setter int failedAttempts;
	
	/**
	 * Inicializa a conta
	 */
	public Account(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
		this.loggedIn = false;
		this.revoked = false;
		this.failedAttempts = 0;
	}
	
	/**
	 * Verifica se uma senha e igual a senha da conta
	 */
	public boolean passwordMatches(String password)
	{
		return this.password.compareTo(password) == 0;
	}
}