package br.unirio.pm.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um componente que contém motores
 * 
 * @author Marcio
 */
public class ComponenteMotor extends Componente
{
	private @Getter @Setter double massaMotor;
	
	/**
	 * Inicializa o console
	 */
	public ComponenteMotor(Componente componenteAcima)
	{
		super("console-motor", componenteAcima);
	}
	
	/**
	 * Retorna a massa interna do componente
	 */
	@Override
	public double getMassaInterna()
	{
		return massaMotor;
	}
}