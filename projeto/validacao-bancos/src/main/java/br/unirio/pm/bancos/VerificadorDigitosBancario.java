package br.unirio.pm.bancos;

/**
 * Classe que verifica a validade de digitos bancarios 
 * 
 * @author marcio.barros
 */
public abstract class VerificadorDigitosBancario
{
	/**
	 * Captura os digitos e alfanumericos de um codigo bancario
	 */
	protected char[] capturaDigitos(String codigo, int numeric, int alpha)
	{
		char[] digitos = new char[numeric + alpha];
		int walker = 0;
		
		for (int i = 0; i < codigo.length(); i++)
		{
			char c = codigo.charAt(i);
			
			if (Character.isLetter(c) || Character.isDigit(c))
			{
				if (walker >= digitos.length)
					return null;
				
				digitos[walker++] = c;
			}
		}
		
		if (walker < digitos.length)
		{
			for (int i = 0; i < walker; i++)
				digitos[digitos.length-i-1] = digitos[walker-i-1];

			for (int i = 0; i < digitos.length-walker; i++)
				digitos[i] = '0';
		}
		
		for (int i = 0; i < numeric; i++)
			if (!Character.isDigit(digitos[i]))
				return null;
		
		return digitos;
	}
	
	/**
	 * Verifica se um codigo de agencia e valido 
	 */
	public abstract boolean verificaAgencia(String codigo);

	/**
	 * Verifica se um codigo de conta corrente e valido 
	 */
	public abstract boolean verificaContaCorrente(String codigoAgencia, String codigoConta);
}