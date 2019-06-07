package br.unirio.pm.bancos;

/**
 * Classe que verifica a validade de digitos do Banco do Brasil
 * 
 * @author marcio.barros
 */
class VerificadorDigitosBancoBrasil extends VerificadorDigitosBancario
{
	/**
	 * Verifica se um codigo de agencia e valido 
	 */
	@Override
	public boolean verificaAgencia(String codigo)
	{
		char[] digitos = capturaDigitos(codigo, 4, 1);
		
		if (digitos == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 4; i++)
			soma += (digitos[i] - '0') * (5 - i);
			
		int digito = 11 - soma % 11;
		char c = (digito == 10) ? 'X' : (char)('0' + digito);		
		return digitos[4] == c;
	}

	/**
	 * Verifica se um codigo de conta corrente e valido 
	 */
	@Override
	public boolean verificaContaCorrente(String codigoAgencia, String codigoConta)
	{
		char[] digitos = capturaDigitos(codigoConta, 8, 1);
		
		if (digitos == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 8; i++)
			soma += (digitos[i] - '0') * (9 - i);
			
		int digito = 11 - soma % 11;
		char c = (digito == 10) ? 'X' : (char)('0' + digito);		
		return digitos[8] == c;
	}
}