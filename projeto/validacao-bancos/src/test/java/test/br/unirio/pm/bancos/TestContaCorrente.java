package test.br.unirio.pm.bancos;

import junit.framework.TestCase;
import br.unirio.pm.bancos.FabricaVerificadoresDigitos;
import br.unirio.pm.bancos.VerificadorDigitosBancario;

public class TestContaCorrente extends TestCase
{
	public void testBancoBrasil()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_BANCOBRASIL);
		assertTrue(verificador.verificaAgencia("1254-8"));
		assertTrue(verificador.verificaAgencia("4684-1"));
		
		assertFalse(verificador.verificaAgencia("1254-2"));
		assertFalse(verificador.verificaAgencia("4684-X"));

		assertFalse(verificador.verificaAgencia("125422-2"));
		assertFalse(verificador.verificaAgencia("46X"));

		assertTrue(verificador.verificaContaCorrente("4684-1", "13798-7"));
		assertTrue(verificador.verificaContaCorrente("3106-2", "18530-2"));
		assertTrue(verificador.verificaContaCorrente("0676-9", "05473-9"));

		assertTrue(verificador.verificaAgencia("1222-X"));
	}

	public void testSantander()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_SANTANDER);
		assertTrue(verificador.verificaContaCorrente("0189", "01017417-9"));
		assertTrue(verificador.verificaContaCorrente("4328", "13004194-1"));
	}

	public void testCaixaEconomicaFederal()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_CEF);
		assertTrue(verificador.verificaContaCorrente("2004", "00100000448-6"));
		assertTrue(verificador.verificaContaCorrente("0206", "00300001966-0"));
		assertTrue(verificador.verificaContaCorrente("0134", "00300000567-7"));
	}
	
	public void testBradesco()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_BRADESCO);
		assertTrue(verificador.verificaAgencia("1425-7"));
		assertTrue(verificador.verificaContaCorrente("1425-7", "0238.069-2"));
		assertTrue(verificador.verificaContaCorrente("1425-7", "0301.357-P"));
		assertTrue(verificador.verificaContaCorrente("1425-7", "0325.620-0"));
		assertTrue(verificador.verificaContaCorrente("1425-7", "0284.025-1"));
		assertTrue(verificador.verificaContaCorrente("1444-3", "702-1"));
	}
	
	public void testItau()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_ITAU);
		assertTrue(verificador.verificaContaCorrente("3820", "10.544-7"));
		assertTrue(verificador.verificaContaCorrente("3820", "01.794-9"));
		assertTrue(verificador.verificaContaCorrente("2545", "02.366-1"));
		assertTrue(verificador.verificaContaCorrente("3069", "14.434-7"));
		assertTrue(verificador.verificaContaCorrente("0272", "09.498-8"));
	}
	
	public void testReal()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_ABNAMRO);
		assertTrue(verificador.verificaContaCorrente("1835", "5711460-9"));
	}
	
	public void testHSBC()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_HSBC);
		assertTrue(verificador.verificaContaCorrente("0007", "853.838-6"));
		assertTrue(verificador.verificaContaCorrente("1198", "119.123-7"));
		assertTrue(verificador.verificaContaCorrente("0543", "003.623-0"));
	}
	
	public void testCitibank()
	{
		VerificadorDigitosBancario verificador = FabricaVerificadoresDigitos.getInstance().get(FabricaVerificadoresDigitos.COD_CITIBANK);
		assertTrue(verificador.verificaContaCorrente("0075", "0007500465-8"));
		assertTrue(verificador.verificaContaCorrente("0003", "53069013"));
	}
}