package br.unirio.pm.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um paraquedas
 * 
 * @author Marcio
 */
public class ComponenteParaquedas extends Componente
{
	private @Getter double coeficienteArrasto;
	
	private @Getter @Setter boolean ativado;
	
	/**
	 * Inicializa o paraquedas
	 */
	public ComponenteParaquedas(double diametro, double coeficienteArrasto)
	{
		super("paraquedas", diametro);
		this.coeficienteArrasto = coeficienteArrasto;
		this.ativado = false;
	}
	
	/**
	 * Retorna a massa interna do componente
	 */
	@Override
	public double getMassaInterna()
	{
		return 0.0;
	}
	
	/**
	 * Retorna a área do componente
	 */
	@Override
	public double getArea()
	{
		return isAtivado() ? calculaArea(getDiametro()) : 0.0;
	}
}