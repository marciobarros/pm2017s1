package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Triangle;
import code.Triangle.TriangleType;

public class TestTriangle
{
	@Test
	public void testAbsurds()
	{
		assertEquals(null, get(0, 0, 0));
		assertEquals(null, get(-1, -1, -1));
		assertEquals(null, get(-1, -1, -3));
		assertEquals(null, get(-1, 3, 3));
		assertEquals(null, get(-1, 1, 3));
		assertEquals(null, get(-1, -1, 3));
	}

	@Test
	public void testEquilateral()
	{
		assertEquals(TriangleType.EQUILATERO, get(1, 1, 1));
		assertEquals(TriangleType.EQUILATERO, get(2, 2, 2));
		assertEquals(TriangleType.EQUILATERO, get(20, 20, 20));
	}

	@Test
	public void testIsosceles()
	{
		assertEquals(TriangleType.ISOSCELES, get(2, 3, 2));
		assertEquals(TriangleType.ISOSCELES, get(4, 4, 2));
		assertEquals(TriangleType.ISOSCELES, get(5, 6, 6));
	}

	@Test
	public void testRetangulo()
	{
		assertEquals(TriangleType.RETANGULO, get(3, 4, 5));
		assertEquals(TriangleType.RETANGULO, get(5, 13, 12));
		assertEquals(TriangleType.RETANGULO, get(17, 15, 8));
	}

	@Test
	public void testIrregular()
	{
		assertEquals(TriangleType.ESCALENO, get(3, 5, 7));
		assertEquals(TriangleType.ESCALENO, get(5, 8, 12));
		assertEquals(TriangleType.ESCALENO, get(17, 11, 8));
	}

	private TriangleType get(int side1, int side2, int side3)
	{
		return new Triangle().getTriangleType(side1, side2, side3);
	}
}