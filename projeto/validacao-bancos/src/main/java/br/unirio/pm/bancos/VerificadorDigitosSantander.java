
package br.unirio.pm.bancos;


/**
 * Classe que verifica a validade de digitos do Santander
 * 
 * @author marcio.barros
 */
class VerificadorDigitosSantander extends VerificadorDigitosBancario
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
		int[] pesoDigitos = {9, 7, 3, 1, 9, 7, 1, 3, 1, 9, 7, 3};
		
		char[] digitosAgencia = capturaDigitos(codigoAgencia, 4, 0);
		
		if (digitosAgencia == null)
			return false;

		char[] digitosConta = capturaDigitos(codigoConta, 9, 0);
		
		if (digitosConta == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 4; i++)
			soma += (digitosAgencia[i] - '0') * pesoDigitos[i] % 10;
		
		for (int i = 0; i < 8; i++)
			soma += (digitosConta[i] - '0') * pesoDigitos[i + 4] % 10;

		int digito = soma % 10;
		
		if (digito != 0)
			digito = 10 - digito;
		
		char ch = (char)('0' + digito);
		return digitosConta[8] == ch;
	}
}