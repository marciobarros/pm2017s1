/**
 * Classe que converte um n�mero para sua representa��o em romanos
 *
 * @author PM
 */
public class ConversorRomanos1
{
	public String geraNumeroRomano (int numero)
	{
		String result = "";
		
		if (numero <= 0)
			return (result);
			
		while (numero >= 1000)
		{
			result += "M";
			numero = numero - 1000;
		}

		if (numero >= 900)
		{
			result += "CM";
			numero = numero - 900;
		}

		if (numero >= 500)
		{
			result += "D";
			numero = numero - 500;
		}

		if (numero >= 400)
		{
			result += "CD";
			numero = numero - 400;
		}

		while (numero >= 100)
		{
			result += "C";
			numero = numero - 100;
		}

		if (numero >= 90)
		{
			result += "XC";
			numero = numero - 90;
		}

		if (numero >= 50)
		{
			result += "L";
			numero = numero - 50;
		}

		if (numero >= 40)
		{
			result += "XL";
			numero = numero - 40;
		}

		while (numero >= 10)
		{
			result += "X";
			numero = numero - 10;
		}

		if (numero >= 9)
		{
			result += "IX";
			numero = numero - 9;
		}

		if (numero >= 5)
		{
			result += "V";
			numero = numero - 5;
		}

		if (numero >= 4)
		{
			result += "IV";
			numero = numero - 4;
		}

		while (numero >= 1)
		{
			result += "I";
			numero = numero - 1;
		}

		return result;
	}
}