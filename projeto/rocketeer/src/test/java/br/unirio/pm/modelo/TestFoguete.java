package br.unirio.pm.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFoguete 
{
	@Test
	public void testComApenasUmMotor()
	{
		Foguete foguete = new Foguete(100.0, 0.0);
		
		ComponenteMotor motor1 = new ComponenteMotor(100.0, 10.0);
		foguete.conecta(motor1);
		
		assertEquals(10, foguete.getMassa(), 0.001);
		assertEquals(7853.9816, foguete.getArea(), 0.001);
	}

	@Test
	public void testDuasCargasQuatroMotores()
	{
		Foguete foguete = new Foguete(100.0, 0.0);
		
		ComponenteCarga carga1 = new ComponenteCarga(100.0, 20.0);
		foguete.conecta(carga1);
		
		ComponenteCarga carga2 = new ComponenteCarga(100.0, 30.0);
		carga1.conecta(carga2);
		
		ComponenteMotor motor1 = new ComponenteMotor(100.0, 40.0);
		carga2.conecta(motor1);
		
		ComponenteMotor motor2 = new ComponenteMotor(100.0, 80.0);
		motor1.conecta(motor2);
		
		ComponenteMotor motor3 = new ComponenteMotor(10.0, 8);
		motor2.adicionaLateral(motor3);
		
		ComponenteMotor motor4 = new ComponenteMotor(10.0, 8);
		motor2.adicionaLateral(motor4);
		
		assertEquals(186.0, foguete.getMassa(), 0.001);
		assertEquals(8011.061, foguete.getArea(), 0.001);
	}
}