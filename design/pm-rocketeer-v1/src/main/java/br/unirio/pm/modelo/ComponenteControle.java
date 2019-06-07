package br.unirio.pm.modelo;

/**
 * Classe que representa um componente de controle do foguete
 * 
 * @author Marcio
 */
public class ComponenteControle extends Componente
{
	/**
	 * Inicializa o console
	 */
	public ComponenteControle(Componente componenteAcima)
	{
		super("console-controle", componenteAcima);
	}
	
	/**
	 * Retorna a massa interna do componente
	 */
	@Override
	public double getMassaInterna()
	{
		return 0.0;
	}
}