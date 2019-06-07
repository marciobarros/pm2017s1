package br.unirio.pm.modelo.foguete;

import lombok.Getter;

/**
 * Enumeração das direções de conexão de componentes de foguetes
 * 
 * @author Marcio
 */
public enum Direcao 
{
	DOWN("abaixo"),
	EAST("leste"),
	WEST("oeste");
	
	private @Getter String codigo;
	
	/**
	 * Inicializa a direção da conexão
	 */
	private Direcao(String codigo)
	{
		this.codigo = codigo;
	}
	
	/**
	 * Retorna uma direção de conexão
	 */
	public static Direcao get(String codigo)
	{
		for (Direcao direcao : values())
			if (direcao.getCodigo().compareTo(codigo) == 0)
				return direcao;
		
		return null;
	}
}