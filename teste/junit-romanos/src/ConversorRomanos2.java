/**
 * Classe que converte um n�mero para sua representa��o em romanos
 *
 * @author PM
 */
public class ConversorRomanos2
{
	public String geraNumeroRomano (int numero)
	{
		int limites[] = new int[] {1000, 500, 100, 50, 10, 5, 1};
		char letras[] = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		
		String result = "";
		
		for (int i = 0; i < limites.length; i++)
		{
			while (numero >= limites[i])
			{
				result += letras[i];
				numero -= limites[i];
			}

			int anterior = (i % 2 == 0) ? i+2 : i+1;
			
			if (anterior < limites.length  &&  numero >= limites[i] - limites[anterior])
			{
				result += letras[anterior];
				result += letras[i];
				numero -= (limites[i] - limites[anterior]);
			}
		}

		return result;
	}
}