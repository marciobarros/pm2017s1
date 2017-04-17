package br.unirio.pm.MockitoLogin;

/**
 * Exceção gerada quando se tenta um login em uma conta previamente logada
 * 
 * @author PM
 */
public class AccountLoginLimitReachedException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
}