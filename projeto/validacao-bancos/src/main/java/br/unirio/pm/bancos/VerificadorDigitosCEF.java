
package br.unirio.pm.bancos;

/**
 * Classe que verifica a validade de digitos da Caixa Economica Federal
 * 
 * @author marcio.barros
 */
class VerificadorDigitosCEF extends VerificadorDigitosBancario
{
	/**
	 * Verifica se um codigo de conta corrente e valido 
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
		int[] pesoDigitos = {8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}; 
		
		char[] digitosAgencia = capturaDigitos(codigoAgencia, 4, 0);
		
		if (digitosAgencia == null)
			return false;
		
		char[] digitosConta = capturaDigitos(codigoConta, 12, 0);
		
		if (digitosConta == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 4; i++)
			soma += (digitosAgencia[i] - '0') * pesoDigitos[i];
		
		for (int i = 0; i < 11; i++)
			soma += (digitosConta[i] - '0') * pesoDigitos[i + 4];
			
		int digito = (soma * 10) % 11;
		
		if (digito == 10)
			digito = 0;
		
		return digitosConta[11] == (char)(digito + '0');
	}
}