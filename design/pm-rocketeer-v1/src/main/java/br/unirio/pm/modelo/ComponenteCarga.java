package br.unirio.pm.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um componente para transporte de carga
 * 
 * @author Marcio
 */
public class ComponenteCarga extends Componente
{
	private @Getter @Setter double massaCarga;
	
	/**
	 * Inicializa o componente de carga
	 */
	public ComponenteCarga(Componente componenteAcima)
	{
		super("console-carga", componenteAcima);
	}
	
	/**
	 * Retorna a massa interna do componente
	 */
	@Override
	public double getMassaInterna()
	{
		return massaCarga;
	}
}