package br.unirio.pm.modelo.comandos;

import br.unirio.pm.modelo.foguete.Componente;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um comando abstrato
 * 
 * @author Marcio
 */
public abstract class ComandoAbstrato
{
	private @Getter String tipo;
	
	private @Getter @Setter String nomeComponente;
	
	/**
	 * Inicializa o comando abstrato
	 */
	public ComandoAbstrato(String tipo)
	{
		this.tipo = tipo;
	}
	
	/**
	 * Executa o comando sobre um componente
	 */
	public abstract void executa(Componente componente);
}