package br.unirio.pm.MockitoLogin;

/**
 * Classe que representa o serviço de login
 * 
 * @author PM
 */
public class LoginService
{
	/**
	 * Repositório de contas usado pelo serviço
	 */
	private IAccountRepository repository;
	
	/**
	 * Inicializa o serviço, indicando seu repositório de contas
	 */
	public LoginService(IAccountRepository repository)
	{
		this.repository = repository;
	}
	
	/**
	 * Executa um login
	 */
	public void login(String userName, String password)
	{
		Account account = repository.find(userName);
		
		if (account == null)
			throw new AccountNotFoundException();
		
		if (account.isLoggedIn())
			throw new AccountLoginLimitReachedException();
		
		if (account.isRevoked())
			throw new AccountRevokedException();
		
		if (account.passwordMatches(password))
		{
			account.setLoggedIn(true);
			account.setFailedAttempts(0);
		}
		else
		{
			int count = account.getFailedAttempts();
			account.setFailedAttempts(count+1);

			if (count+1 >= 3)
				account.setRevoked(true);
		}
	}
}