import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Classe de teste para o gerador de conversor de n�meros romados
 *
 * @author PM
 */
public class TestConversorRomanos 
{
	@Test
	public void testSimple() 
	{
		ConversorRomanos2 gerador = new ConversorRomanos2();

		assertEquals("MCMXC", gerador.geraNumeroRomano(1990));
		assertEquals("MM", gerador.geraNumeroRomano(2000));
		assertEquals("MCMXCIX", gerador.geraNumeroRomano(1999));

		assertEquals("VI", gerador.geraNumeroRomano(6));
		assertEquals("XXI", gerador.geraNumeroRomano(21));
		assertEquals("LXVII", gerador.geraNumeroRomano(67));

		assertEquals("IV", gerador.geraNumeroRomano(4));
		assertEquals("IX", gerador.geraNumeroRomano(9));
		assertEquals("XL", gerador.geraNumeroRomano(40));
		assertEquals("XC", gerador.geraNumeroRomano(90));
		assertEquals("CD", gerador.geraNumeroRomano(400));
		assertEquals("CM", gerador.geraNumeroRomano(900));

		assertEquals("XIII", gerador.geraNumeroRomano(13));
		assertEquals("XIV", gerador.geraNumeroRomano(14));
		assertEquals("XXXIII", gerador.geraNumeroRomano(33));
		assertEquals("XXXIV", gerador.geraNumeroRomano(34));

		assertEquals("I", gerador.geraNumeroRomano(1));
		assertEquals("II", gerador.geraNumeroRomano(2));
		assertEquals("X", gerador.geraNumeroRomano(10));
		assertEquals("C", gerador.geraNumeroRomano(100));
		assertEquals("M", gerador.geraNumeroRomano(1000));

		assertEquals("XIX", gerador.geraNumeroRomano(19));
		assertEquals("LIV", gerador.geraNumeroRomano(54));
		assertEquals("CXXIX", gerador.geraNumeroRomano(129));
	}

	@Test
	public void testNegative() 
	{
		ConversorRomanos2 gerador = new ConversorRomanos2();
		assertEquals("", gerador.geraNumeroRomano(-1));
	}

	@Test
	public void testZero() throws Exception 
	{
		ConversorRomanos2 gerador = new ConversorRomanos2();
		assertEquals("", gerador.geraNumeroRomano(0));
	}
}