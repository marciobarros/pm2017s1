package br.unirio.pm.modelo;

import lombok.Getter;
import lombok.Setter;

// TODO fazer casos de teste para testar os cálculos

/**
 * Classe que representa um foguete
 * 
 * @author Marcio
 */
public class Foguete extends Componente
{
	private @Getter ComponenteControle consoleControle;

	private @Getter @Setter ComponenteParaquedas paraquedas;
	
	/**
	 * Inicializa o foguete
	 */
	public Foguete()
	{
		super("foguete", null);
		this.consoleControle = new ComponenteControle(this);
		this.setComponenteAbaixo(consoleControle);
	}

	/**
	 * Retorna a massa total do foguete
	 */
//	public double getMassa()
//	{
//		double massa = consoleControle.getMassa();
//		
//		if (paraquedas != null)
//			massa += paraquedas.getMassa();
//		
//		return massa;
//	}

	/**
	 * Retorna a área total do foguete
	 */
//	public double getArea()
//	{
//		double area = consoleControle.getArea();
//		
//		if (paraquedas != null)
//			area = Math.max(area, paraquedas.getArea());
//
//		return area;
//	}

	@Override
	protected double getMassaInterna() 
	{
		return 0;
	}
}