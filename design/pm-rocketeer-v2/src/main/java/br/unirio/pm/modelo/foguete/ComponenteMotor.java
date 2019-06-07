package br.unirio.pm.modelo.foguete;

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
	public ComponenteMotor(Componente componentePai)
	{
		super(componentePai, "console-motor");
	}
	
	/**
	 * Retorna a massa interna do componente
	 */
	@Override
	public double getMassaInterna()
	{
		return massaMotor;
	}

	/**
	 * Ativa o componente 
	 */
	public void ativacao()
	{
		// Liga os motores do componente 
	}
}