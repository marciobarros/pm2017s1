package br.unirio.pm.modelo.comandos;

import br.unirio.pm.modelo.Componente;

/**
 * Classe que representa um comando de ativação de componente
 * 
 * @author Marcio
 */
public abstract class ComandoAtivacao extends ComandoAbstrato
{
	/**
	 * Inicializa o comando
	 */
	public ComandoAtivacao(String nomeComponente)
	{
		super("cmd-ativacao", nomeComponente);
	}
	
	/**
	 * Executa o comando sobre um componente
	 */
	public void executa(Componente componente)
	{
		componente.ativa();
	}
}