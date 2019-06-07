package br.unirio.pm.modelo.foguete;

import java.util.HashMap;

import br.unirio.pm.modelo.comandos.ComandoAbstrato;
import lombok.Getter;
import lombok.Setter;

/**
 * Superclasse de todos os componentes de foguete
 * 
 * @author Marcio
 */
public abstract class Componente
{
	private @Getter String tipo;
	
	private @Getter @Setter String nome;
	
	private @Getter @Setter double diametro;
	
	private Componente componentePai;
	
	private HashMap<Direcao, Componente> componentesConectados;

	/**
	 * Inicializa o componente abstrato, indicando seu tipo
	 */
	protected Componente(Componente componentePai, String tipo)
	{
		this.tipo = tipo;
		this.nome = "";
		this.diametro = 0.0;
		this.componentePai = componentePai;
		this.componentesConectados = new HashMap<Direcao, Componente>();
	}

	/**
	 * Retorna a massa do componente
	 */
	public double getMassa()
	{
		double massa = getMassaInterna();
		
		for (Componente componente : componentesConectados.values())
			massa += componente.getMassa();
		
		return massa;
	}

	/**
	 * Retorna a massa interna do componente
	 */
	protected abstract double getMassaInterna();
	
	/**
	 * Retorna a área do componente
	 */
	public double getArea()
	{
		double area = calculaArea(diametro);
		
		Componente componenteLeste = componentesConectados.get(Direcao.EAST);
		
		if (componenteLeste != null)
			area += componenteLeste.getArea();
		
		Componente componenteOeste = componentesConectados.get(Direcao.WEST);
		
		if (componenteOeste != null)
			area += componenteOeste.getArea();
		
		Componente componenteAbaixo = componentesConectados.get(Direcao.DOWN);
		
		if (componenteAbaixo != null)
			area = Math.max(area, componenteAbaixo.getArea());
		
		return area;
	}
	
	/**
	 * Calcula a área de um círculo, dado seu diâmetro
	 */
	protected double calculaArea(double diametro)
	{
		double raio = diametro / 2.0;
		return Math.PI * raio * raio;
	}
	
	/**
	 * Adiciona um componente conectado ao componente
	 */
	public void adicionaComponente(Direcao direcao, Componente componente)
	{
		componentesConectados.put(direcao, componente);
	}

	/**
	 * Executa um comando sobre os componentes
	 */
	public void executaComando(ComandoAbstrato comando)
	{
		if (comando.getNomeComponente().compareTo(this.nome) == 0)
		{
			comando.executa(this);
		}
		else
		{
			for (Componente componente : componentesConectados.values())
				componente.executaComando(comando);
		}
	}

	/**
	 * Ativa o componente 
	 */
	public abstract void ativacao();

	/**
	 * Desacopla o componente do foguete
	 */
	public void desacopla()
	{
		componentePai.desacoplaComponenteAbaixo();
	}

	/**
	 * Remove o componente abaixo do componente atual
	 */
	protected void desacoplaComponenteAbaixo()
	{
		componentesConectados.put(Direcao.DOWN, null);
	}
}