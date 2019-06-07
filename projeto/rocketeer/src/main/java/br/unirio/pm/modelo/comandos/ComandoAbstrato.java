package br.unirio.pm.modelo.comandos;

import br.unirio.pm.modelo.Componente;
import lombok.Getter;

/**
 * Classe que representa um comando abstrato
 * 
 * @author Marcio
 */
public abstract class ComandoAbstrato
{
	private @Getter String tipo;
	
	private @Getter String nomeComponente;
	
	/**
	 * Inicializa o comando abstrato
	 */
	public ComandoAbstrato(String tipo, String nomeComponente)
	{
		this.tipo = tipo;
		this.nomeComponente = nomeComponente;
	}
	
	/**
	 * Executa o comando sobre um componente
	 */
	public abstract void executa(Componente componente);
}