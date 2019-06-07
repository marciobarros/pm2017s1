package br.unirio.pm.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.unirio.pm.controle.FogueteBuilder;

public class TestBuilder 
{
	@Test
	public void testDuasCargasQuatroMotores()
	{
		Foguete foguete = new FogueteBuilder(100.0, 0.0)
			.adicionaCarga(100.0, 20.0)
			.adicionaCarga(100.0, 30.0)
			.adicionaMotor(100.0, 40.0)
			.adicionaMotor(100.0, 80.0)
			.lateral()
			.adicionaMotor(10.0, 8.0)
			.adicionaMotor(10.0, 8.0)
			.getFoguete();
		
		assertEquals(186.0, foguete.getMassa(), 0.001);
		assertEquals(8011.061, foguete.getArea(), 0.001);
	}
}