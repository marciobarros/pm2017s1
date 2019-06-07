package br.unirio.pm.modelo;

import lombok.Getter;

/**
 * Classe que representa um foguete
 * 
 * @author Marcio
 */
public class Foguete extends Componente
{
	private @Getter double massaModuloControle;
	
	private @Getter ComponenteParaquedas paraquedas;
	
	/**
	 * Inicializa o foguete
	 */
	public Foguete(double diametro, double massaModuloControle)
	{
		super("foguete", diametro);
		this.massaModuloControle = massaModuloControle;
		this.paraquedas = null;
	}

	/**
	 * Retorna a massa interna do foguete
	 */
	@Override
	protected double getMassaInterna() 
	{
		return massaModuloControle;
	}
	
	/**
	 * Adiciona um paraquedas no foguete
	 */
	public void adicionaParaquedas(ComponenteParaquedas paraquedas)
	{
		this.paraquedas = paraquedas;
		adicionaLateral(paraquedas);
	}
}