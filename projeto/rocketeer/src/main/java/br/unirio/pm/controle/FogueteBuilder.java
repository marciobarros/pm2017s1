package br.unirio.pm.controle;

import java.util.Stack;

import br.unirio.pm.modelo.Componente;
import br.unirio.pm.modelo.ComponenteCarga;
import br.unirio.pm.modelo.ComponenteMotor;
import br.unirio.pm.modelo.ComponenteParaquedas;
import br.unirio.pm.modelo.Foguete;
import lombok.Getter;

/**
 * Classe responsável por construir foguetes
 * 
 * @author Marcio Barros
 */
public class FogueteBuilder 
{
	private @Getter Foguete foguete;
	private Componente ultimoComponentePilhaCentral;
	private Stack<Componente> movimentosLaterais;
	
	/**
	 * Inicializa a classe responsável por criar os foguetes
	 */
	public FogueteBuilder(double diametro, double massaModuloControle)
	{
		this.foguete = new Foguete(diametro, massaModuloControle);
		this.ultimoComponentePilhaCentral = foguete;
		this.movimentosLaterais = new Stack<Componente>();
	}

	/**
	 * Adiciona um componente de carga no foguete
	 */
	public FogueteBuilder adicionaCarga(double diametro, double massaCarga)
	{
		ComponenteCarga carga = new ComponenteCarga(diametro, massaCarga);
		
		if (movimentosLaterais.empty())
		{
			ultimoComponentePilhaCentral.conecta(carga);
			ultimoComponentePilhaCentral = carga;
		}
		else
		{
			movimentosLaterais.peek().adicionaLateral(carga);
		}
		
		return this;
	}

	/**
	 * Adiciona um componente de motor no foguete
	 */
	public FogueteBuilder adicionaMotor(double diametro, double massaMotor)
	{
		ComponenteMotor motor = new ComponenteMotor(diametro, massaMotor);

		if (movimentosLaterais.empty())
		{
			ultimoComponentePilhaCentral.conecta(motor);
			ultimoComponentePilhaCentral = motor;
		}
		else
		{
			movimentosLaterais.peek().adicionaLateral(motor);
		}

		return this;
	}
	
	/**
	 * Adiciona um paraquedas no foguete
	 */
	public FogueteBuilder adicionaParaquedas(double diametro, double coeficienteArrasto)
	{
		ComponenteParaquedas paraquedas = new ComponenteParaquedas(diametro, coeficienteArrasto);
		foguete.adicionaParaquedas(paraquedas);
		return this;
	}

	/**
	 * Movimento lateral para inserção de componentes
	 */
	public FogueteBuilder lateral() 
	{
		movimentosLaterais.push(ultimoComponentePilhaCentral);
		return this;
	}

	/**
	 * Retorno do movimento lateral para inserção de componentes
	 */
	public FogueteBuilder volta() 
	{
		movimentosLaterais.pop();
		return this;
	}
}