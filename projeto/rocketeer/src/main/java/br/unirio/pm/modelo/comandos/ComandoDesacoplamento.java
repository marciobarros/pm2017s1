package br.unirio.pm.modelo.comandos;

import br.unirio.pm.modelo.Componente;

/**
 * Classe que representa um comando de desacoplamento de componente
 * 
 * @author Marcio
 */
public abstract class ComandoDesacoplamento extends ComandoAbstrato
{
	/**
	 * Inicializa o comando
	 */
	public ComandoDesacoplamento(String nomeComponente)
	{
		super("cmd-desacoplamento", nomeComponente);
	}
	
	/**
	 * Executa o comando sobre um componente
	 */
	public void executa(Componente componente)
	{
		componente.desacopla();
	}
}