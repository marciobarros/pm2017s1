package br.unirio.pm.modelo.comandos;

import br.unirio.pm.modelo.foguete.Componente;

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
	public ComandoAtivacao()
	{
		super("cmd-ativacao");
	}
	
	/**
	 * Executa o comando sobre um componente
	 */
	public void executa(Componente componente)
	{
		componente.ativacao();
	}
}