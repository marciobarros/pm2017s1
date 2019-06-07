package br.unirio.pm.MockitoLogin;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Casos de teste para o serviço de login
 * 
 * @author PM
 */
public class LoginServiceTest 
{
	/**
	 * Verifica se o serviço de login marca uma conta como logada quando a senha é igual
	 */
	@Test
	public void itShouldSetAccountToLoggedInWhenPasswordMatches() 
	{
		Account accountForJoao = new Account("joao", "password");
		Account accountForJoaoSpy = spy(accountForJoao);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);

		LoginService service = new LoginService(accountRepository);
		service.login("joao", "password");

		verify(accountForJoaoSpy, times(1)).setLoggedIn(true);
	}

	/**
	 * Verifica se o serviço de login bloqueia a conta após três falhas no login
	 */
	@Test
	public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() 
	{
		Account accountForJoao = new Account("joao", "password1");
		Account accountForJoaoSpy = spy(accountForJoao);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);

		LoginService service = new LoginService(accountRepository);

		for (int i = 0; i < 3; ++i)
			service.login("joao", "password");

		verify(accountForJoaoSpy, times(1)).setRevoked(true);
	}

	/**
	 * Verifica se o serviço de login marca uma conta como não logada quando a senha é diferente
	 */
	@Test
	public void itShouldNotSetAccountLoggedInIfPasswordDoesNotMatch() 
	{
		Account accountForJoao = new Account("joao", "password1");
		Account accountForJoaoSpy = spy(accountForJoao);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);

		LoginService service = new LoginService(accountRepository);
		service.login("joao", "password");
		
		verify(accountForJoaoSpy, never()).setLoggedIn(true);
	}

	/**
	 * Verifica se o serviço de login não bloqueia a conta após três falhas de login em contas diferentes
	 */
	@Test
	public void itShouldNotRevokeSecondAccountAfterTwoFailedAttemptsFirstAccount() 
	{
		Account accountForJoao = new Account("joao", "password1");
		Account accountForJoaoSpy = spy(accountForJoao);

		Account accountForMaria = new Account("maria", "password1");
		Account accountForMariaSpy = spy(accountForMaria);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);
		when(accountRepository.find("maria")).thenReturn(accountForMariaSpy);

		LoginService service = new LoginService(accountRepository);
		service.login("joao", "password");
		service.login("joao", "password");
		service.login("maria", "password");

		verify(accountForMariaSpy, never()).setRevoked(true);
	}

	/**
	 * Verifica se o serviço de login gera uma exceção quando tenta logar duas vezes na mesma conta
	 */
	@Test(expected = AccountLoginLimitReachedException.class)
	public void itShouldNotAllowConcurrentLogins() 
	{
		Account accountForJoao = new Account("joao", "password");
		Account accountForJoaoSpy = spy(accountForJoao);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);

		when(accountForJoaoSpy.isLoggedIn()).thenReturn(true);

		LoginService service = new LoginService(accountRepository);
		service.login("joao", "password");
	}

	/**
	 * Verifica se o serviço de login gera uma exceção quando não encontra uma conta
	 */
	@Test(expected = AccountNotFoundException.class)
	public void ItShouldThrowExceptionIfAccountNotFound() 
	{
		Account accountForJoao = new Account("joao", "password");
		Account accountForJoaoSpy = spy(accountForJoao);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);
		when(accountRepository.find("maria")).thenReturn(null);

		LoginService service = new LoginService(accountRepository);
		service.login("maria", "password");
	}

	/**
	 * Verifica se o serviço de login gera uma exceção quando tenta logar em uma conta bloqueada
	 */
	@Test(expected = AccountRevokedException.class)
	public void ItShouldNotBePossibleToLogIntoRevokedAccount() 
	{
		Account accountForJoao = new Account("joao", "password");
		Account accountForJoaoSpy = spy(accountForJoao);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(accountForJoaoSpy);
		
		when(accountForJoaoSpy.isRevoked()).thenReturn(true);

		LoginService service = new LoginService(accountRepository);
		service.login("joao", "password");
	}
}