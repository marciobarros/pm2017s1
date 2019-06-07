package br.unirio.pm.bancos;

/**
 * Classe que verifica a validade de digitos do HSBC
 * 
 * @author marcio.barros
 */
class VerificadorDigitosHSBC extends VerificadorDigitosBancario
{
	/**
	 * Verifica se um codigo de agencia e valido
	 */
	@Override
	public boolean verificaAgencia(String codigo)
	{
		char[] digitos = capturaDigitos(codigo, 4, 0);
		return (digitos != null);
	}

	/**
	 * Verifica se um codigo de conta corrente e valido 
	 */
	@Override
	public boolean verificaContaCorrente(String codigoAgencia, String codigoConta)
	{
		int[] pesoDigitos = {8, 9, 2, 3, 4, 5, 6, 7, 8, 9};
		
		char[] digitosAgencia = capturaDigitos(codigoAgencia, 4, 0);
		
		if (digitosAgencia == null)
			return false;

		char[] digitosConta = capturaDigitos(codigoConta, 7, 0);
		
		if (digitosConta == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 4; i++)
			soma += (digitosAgencia[i] - '0') * pesoDigitos[i];
		
		for (int i = 0; i < 6; i++)
			soma += (digitosConta[i] - '0') * pesoDigitos[i + 4];

		int digito = soma % 11;
		
		if (digito == 10)
			digito = 0;
		
		char ch = (char)('0' + digito);
		return digitosConta[6] == ch;
	}
}