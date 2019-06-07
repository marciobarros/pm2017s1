package br.unirio.pm.modelo.foguete;

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
	public ComponenteControle(Componente componentePai)
	{
		super(componentePai, "console-controle");
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
	 * Ativa o componente 
	 */
	public void ativacao()
	{
		// Não há nada para fazer aqui!
	}
}