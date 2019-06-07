package br.unirio.pm.modelo.foguete;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um foguete
 * 
 * @author Marcio
 */
public class Foguete
{
	private @Getter ComponenteControle consoleControle;

	private @Getter @Setter ComponenteParaquedas paraquedas;
	
	/**
	 * Inicializa o foguete
	 */
	public Foguete()
	{
		this.consoleControle = new ComponenteControle(null);
	}

	/**
	 * Retorna a massa total do foguete
	 */
	public double getMassa()
	{
		double massa = consoleControle.getMassa();
		
		if (paraquedas != null)
			massa += paraquedas.getMassa();
		
		return massa;
	}

	/**
	 * Retorna a área total do foguete
	 */
	public double getArea()
	{
		double area = consoleControle.getArea();
		
		if (paraquedas != null)
			area = Math.max(area, paraquedas.getArea());

		return area;
	}
}