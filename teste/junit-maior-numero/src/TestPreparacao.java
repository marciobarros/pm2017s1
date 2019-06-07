import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPreparacao 
{
	@BeforeClass
	public static void oneTimeSetup() throws Exception
	{
		System.out.println("Executando Before Class ...");
	}

	@Before
	public void setup() throws Exception
	{
		System.out.println("Executando Before ...");
	}

	@Test
	public void testNumeroUm() throws Exception
	{
		System.out.println("Executando teste #1 ...");
		assertTrue(true);
	}

	@Test
	public void testNumeroDois() throws Exception
	{
		System.out.println("Executando teste #2 ...");
		assertTrue(true);
	}

	@After
	public void teardown() throws Exception
	{
		System.out.println("Executando After ...");
	}

	@AfterClass
	public static void oneTimeTeardown() throws Exception
	{
		System.out.println("Executando After Class ...");
	}
}