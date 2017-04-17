/**
 * Classe que calcula o maior número presente em uma lista de inteiros
 * 
 * @author PM
 */
public class MaiorNumero 
{
	public int pegaMaior (int[] lista) throws Exception
	{
		if (lista.length == 0)
			throw new Exception ();
		
		int maximo = lista[0];

		for (int i = 1; i < lista.length; i++)
			if (lista[i] > maximo)
				maximo = lista[i];

		return (maximo);
	}
}