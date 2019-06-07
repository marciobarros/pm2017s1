package br.unirio.pm.MockitoLogin;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/**
 * Casos de teste para o serviço de login - versão refatorada
 * 
 * @author PM
 */
public class LoginServiceRefactoredTest 
{
	private Account accountForJoaoSpy;
	private Account accountForMariaSpy;
	private IAccountRepository accountRepository;
	private LoginService loginService;
	
	/**
	 * Preparação do cenário de testes
	 */
	@Before
	public void init()
	{
		Account accountForJoao = new Account("joao", "password");
		accountForJoaoSpy = spy(accountForJoao);

		Account accountForMaria = new Account("maria", "password");
		accountForMariaSpy = spy(accountForMaria);

		accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find("joao")).thenReturn(accountForJoaoSpy);
		when(accountRepository.find("maria")).thenReturn(accountForMariaSpy);

		loginService = new LoginService(accountRepository);
	}
	
	/**
	 * Verifica se o serviço de login marca uma conta como logada quando a senha é igual
	 */
	@Test
	public void itShouldSetAccountToLoggedInWhenPasswordMatches() 
	{
		loginService.login("joao", "password");
		verify(accountForJoaoSpy, times(1)).setLoggedIn(true);
	}

	/**
	 * Verifica se o serviço de login bloqueia a conta após três falhas no login
	 */
	@Test
	public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() 
	{
		for (int i = 0; i < 3; ++i)
			loginService.login("joao", "password1");

		verify(accountForJoaoSpy, times(1)).setRevoked(true);
	}

	/**
	 * Verifica se o serviço de login marca uma conta como não logada quando a senha é diferente
	 */
	@Test
	public void itShouldNotSetAccountLoggedInIfPasswordDoesNotMatch() 
	{
		loginService.login("joao", "password1");
		verify(accountForJoaoSpy, never()).setLoggedIn(true);
	}

	/**
	 * Verifica se o serviço de login não bloqueia a conta após três falhas de login em contas diferentes
	 */
	@Test
	public void itShouldNotRevokeSecondAccountAfterTwoFailedAttemptsFirstAccount() 
	{
		loginService.login("joao", "password1");
		loginService.login("joao", "password1");
		loginService.login("maria", "password1");
		verify(accountForMariaSpy, never()).setRevoked(true);
	}

	/**
	 * Verifica se o serviço de login gera uma exceção quando tenta logar duas vezes na mesma conta
	 */
	@Test(expected = AccountLoginLimitReachedException.class)
	public void itShouldNotAllowConcurrentLogins() 
	{
		when(accountForJoaoSpy.isLoggedIn()).thenReturn(true);
		loginService.login("joao", "password");
	}

	/**
	 * Verifica se o serviço de login gera uma exceção quando não encontra uma conta
	 */
	@Test(expected = AccountNotFoundException.class)
	public void ItShouldThrowExceptionIfAccountNotFound() 
	{
		loginService.login("pedro", "password");
	}

	/**
	 * Verifica se o serviço de login gera uma exceção quando tenta logar em uma conta bloqueada
	 */
	@Test(expected = AccountRevokedException.class)
	public void ItShouldNotBePossibleToLogIntoRevokedAccount() 
	{
		when(accountForJoaoSpy.isRevoked()).thenReturn(true);
		loginService.login("joao", "password");
	}
}