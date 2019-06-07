import static org.junit.Assert.*;

import org.junit.Test;

public class TestRegex 
{
	@Test
	public void testSimpleMatch() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("abc", "abc"));
		assertTrue(r.match("", ""));
		assertTrue(r.match("x", "x"));
		assertTrue(r.match("teste minha rotina", "teste minha rotina"));
		assertTrue(r.match("teste minha rotina", "## teste minha rotina ##"));
		assertTrue(r.match("teste minha rotina", "teste minha rotina ##"));
		assertTrue(r.match("teste minha rotina", "## teste minha rotina"));
	}

	@Test
	public void testOnePoint() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("a.c", "abc"));
		assertTrue(r.match("a.c", "a.c"));
		assertTrue(r.match(".", "a"));
		assertTrue(r.match(".", "ab"));
	}

	@Test
	public void testTwoPoints() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("a..", "abc"));
		assertTrue(r.match("a.c.", "a.cx"));
		assertFalse(r.match("a.c.", "a.c"));
		assertFalse(r.match(".", ""));
	}

	@Test
	public void testAsterisc() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("a*", "aaaaaa"));
		assertTrue(r.match("a*b.", "aaaabc"));
		assertTrue(r.match("a*b", "xxxaaaabc"));
		assertTrue(r.match("a*b", "xxxb"));
	}

	@Test
	public void testTextStart() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("^a*", "aaaaaa"));
		assertTrue(r.match("^a*", "aaaaaabb"));
		assertTrue(r.match("^a*", "bb"));
		assertTrue(r.match("^a*", ""));
	}

	@Test
	public void testTextFinish() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("a*$", "aaaaaa"));
		assertTrue(r.match("a*$", "bbaaaaaa"));
		assertFalse(r.match("a*$", "bbaaaaaacc"));
		assertTrue(r.match("a*$", ""));
	}

	@Test
	public void testTextStartFinish() 
	{
		Matcher r = new Matcher(); 
		assertTrue(r.match("^a*$", "aaaaaa"));
		assertTrue(r.match("^b*a*c*$", "bbaacc"));
		assertTrue(r.match("^a*$", ""));
	}
}