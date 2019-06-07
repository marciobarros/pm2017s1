package code;

public class Triangle
{
	public enum TriangleType { EQUILATERO, ISOSCELES, RETANGULO, ESCALENO };
	
	public TriangleType getTriangleType(int side1, int side2, int side3)
	{
		if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side2 + side1)
			return null;
		
		if (side1 == side2 && side1 == side3)
			return TriangleType.EQUILATERO;
		
		if (side1 == side2 || side1 == side3 || side2 == side3)
			return TriangleType.ISOSCELES;

		int sideQuad1 = side1 * side1;
		int sideQuad2 = side2 * side2;
		int sideQuad3 = side3 * side3;
		
		if ((sideQuad1 == sideQuad2 + sideQuad3) || (sideQuad2 == sideQuad1 + sideQuad3) || (sideQuad3 == sideQuad1 + sideQuad2))
			return TriangleType.RETANGULO;

		return TriangleType.ESCALENO;
	}
}