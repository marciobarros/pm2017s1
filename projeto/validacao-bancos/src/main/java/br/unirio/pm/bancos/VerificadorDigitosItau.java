package br.unirio.pm.bancos;

/**
 * Classe que verifica a validade de digitos do Itau
 * 
 * @author marcio.barros
 */
class VerificadorDigitosItau extends VerificadorDigitosBancario
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
		int[] pesoDigitos = {2, 1, 2, 1, 2, 1, 2, 1, 2};
		
		char[] digitosAgencia = capturaDigitos(codigoAgencia, 4, 0);
		
		if (digitosAgencia == null)
			return false;

		char[] digitosConta = capturaDigitos(codigoConta, 6, 0);
		
		if (digitosConta == null)
			return false;
		
		int soma = 0;
		
		for (int i = 0; i < 4; i++)
		{
			int valor = (digitosAgencia[i] - '0') * pesoDigitos[i];
			
			if (valor >= 10)
				valor = (valor % 10) + 1;
			
			soma += valor;
		}
		
		for (int i = 0; i < 5; i++)
		{
			int valor = (digitosConta[i] - '0') * pesoDigitos[i + 4];
			
			if (valor >= 10)
				valor = (valor % 10) + 1;
			
			soma += valor;
		}

		int digito = soma % 10;
		
		if (digito != 0)
			digito = 10 - digito;
		
		char ch = (char)('0' + digito);
		return digitosConta[5] == ch;
	}
}