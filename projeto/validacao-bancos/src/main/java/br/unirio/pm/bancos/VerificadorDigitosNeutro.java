
package br.unirio.pm.bancos;


/**
 * Classe que verifica a validade de digitos bancarios sempre com sucesso 
 * 
 * @author marcio.barros
 */
class VerificadorDigitosNeutro extends VerificadorDigitosBancario
{
	/**
	 * Verifica se um codigo de agencia e valido 
	 */
	@Override
	public boolean verificaAgencia(String codigo)
	{
		return true;
	}

	/**
	 * Verifica se um codigo de conta corrente e valido 
	 */
	@Override
	public boolean verificaContaCorrente(String codigoAgencia, String codigoConta)
	{
		return true;
	}
}