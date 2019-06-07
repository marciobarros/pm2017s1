
package br.unirio.pm.bancos;

/**
 * Classe que verifica a validade de digitos do Citibank
 * 
 * @author marcio.barros
 */
class VerificadorDigitosCitibank extends VerificadorDigitosBancario
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
		char[] digitosConta = capturaDigitos(codigoConta, 11, 0);
		
		if (digitosConta == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 10; i++)
			soma += (digitosConta[i] - '0') * (11 - i);
		
		int digito = soma % 11;
		
		if (digito > 1)
			digito = 11 - digito;
		else
			digito = 0;
		
		char ch = (char)('0' + digito);
		return digitosConta[10] == ch;
	}
}