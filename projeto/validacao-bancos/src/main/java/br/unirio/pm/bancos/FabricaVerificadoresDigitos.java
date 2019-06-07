package br.unirio.pm.bancos;

import java.util.HashMap;

/**
 * Fábrica de verificadores de dígitos
 * 
 * @author marciobarros
 */
public class FabricaVerificadoresDigitos 
{
	/**
	 * Codigos dos bancos tratados pelo sistema
	 */
	public static final int COD_BANCOBRASIL = 1;
	public static final int COD_BRADESCO = 237;
	public static final int COD_ITAU = 341;
	public static final int COD_CEF = 104;
	public static final int COD_CITIBANK = 745;
	public static final int COD_HSBC = 399;
	public static final int COD_ABNAMRO = 75;
	public static final int COD_SANTANDER = 33;
	
	/**
	 * Lista de verificadores registrados no sistema
	 */
	private HashMap<Integer, VerificadorDigitosBancario> verificadores;

	/**
	 * Instancia unica da fabrica de verificadores
	 */
	private static FabricaVerificadoresDigitos instance = null;

	/**
	 * Inicializa a fabrica de verificadores de digitos bancarios
	 */
	private FabricaVerificadoresDigitos()
	{
		this.verificadores = new HashMap<Integer, VerificadorDigitosBancario>();
		this.verificadores.put(COD_BANCOBRASIL, new VerificadorDigitosBancoBrasil());
		this.verificadores.put(COD_BRADESCO, new VerificadorDigitosBradesco());
		this.verificadores.put(COD_ITAU, new VerificadorDigitosItau());
		this.verificadores.put(COD_CEF, new VerificadorDigitosCEF());
		this.verificadores.put(COD_CITIBANK, new VerificadorDigitosCitibank());
		this.verificadores.put(COD_HSBC, new VerificadorDigitosHSBC());
		this.verificadores.put(COD_ABNAMRO, new VerificadorDigitosABNAmro());
		this.verificadores.put(COD_SANTANDER, new VerificadorDigitosSantander());
	}
	
	/**
	 * Retorna a instancia da fabrica de verificadores de digitos
	 */
	public static FabricaVerificadoresDigitos getInstance()
	{
		if (instance == null)
			instance = new FabricaVerificadoresDigitos();
		
		return instance;
	}

	/**
	 * Retorna um verificador de digitos, dado o codigo de um banco
	 */
	public VerificadorDigitosBancario get(int codigo)
	{
		VerificadorDigitosBancario verificador = verificadores.get(codigo);
		
		if (verificador == null)
			verificador = new VerificadorDigitosNeutro();
		
		return verificador;
	}
}