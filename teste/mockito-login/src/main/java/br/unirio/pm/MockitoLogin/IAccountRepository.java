package br.unirio.pm.MockitoLogin;

/**
 * Interface abstrata para um repositorio de contas
 * 
 * @author PM
 */
interface IAccountRepository
{
	Account find(String userName);
}