package br.unirio.pm.modelo;

import java.util.ArrayList;
import java.util.List;

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
	
	private @Getter @Setter Componente componenteAcima;
	
	private @Getter @Setter Componente componenteAbaixo;
	
	private List<Componente> componentesLaterais;

	/**
	 * Inicializa o componente abstrato, indicando seu tipo
	 */
	protected Componente(String tipo, double diametro)
	{
		this.tipo = tipo;
		this.nome = "";
		this.diametro = diametro;
		this.componenteAcima = null;
		this.componenteAbaixo = null;
		this.componentesLaterais = new ArrayList<Componente>();
	}

	/**
	 * Retorna a massa do componente
	 */
	public double getMassa()
	{
		double massa = getMassaInterna();
		
		for (Componente componente : componentesLaterais)
			massa += componente.getMassa();
		
		if (componenteAbaixo != null)
			massa += componenteAbaixo.getMassa();
		
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
		
		for (Componente componente : componentesLaterais)
			area += componente.getArea();
		
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
	 * Adiciona um componente lateral ao componente
	 */
	public void adicionaLateral(Componente componente) 
	{
		componentesLaterais.add(componente);
	}

	/**
	 * Conecta um componente abaixo do componente atual
	 */
	public void conecta(Componente componenteAbaixo) 
	{
		this.componenteAbaixo = componenteAbaixo;
		componenteAbaixo.setComponenteAcima(this);
	}
}