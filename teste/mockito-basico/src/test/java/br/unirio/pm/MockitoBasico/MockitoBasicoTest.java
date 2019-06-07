package br.unirio.pm.MockitoBasico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("unchecked")
public class MockitoBasicoTest
{
	/**
	 * Verifica se determinados métodos foram executados
	 */
	@Test
 	public void testVerifyMethodCall()
    {
 		List<String> mockedList = mock(List.class);

     	mockedList.add("one");
    	mockedList.clear();

    	verify(mockedList).add("one");
    	verify(mockedList).clear();
    }

	/**
	 * Indicação de retorno de método - sem condição associada
	 */
	@Test
	public void testConditionalWhenReturn() 
	{
		List<String> mockedList = mock(List.class);
		when(mockedList.size()).thenReturn(43);
		assertEquals(mockedList.size(), 43);
	}

	/**
	 * Indicação de retorno de método - com condição associada
	 */
	@Test
   	public void testUnconditionalWhenReturn()
   	{
   		LinkedList<String> mockedList = mock(LinkedList.class);
   		when(mockedList.get(0)).thenReturn("first");

   		assertEquals(mockedList.get(0), "first");
   		assertNull(mockedList.get(999));   		
   	}

	/**
	 * Indicação de mais de um valor de retorno
	 */
	@Test
	public void testMoreThanOneReturnValue()  
	{
		Iterator<String> mockIterator = mock(Iterator.class);
		when(mockIterator.next()).thenReturn("Mockito").thenReturn("rocks");
		String result = mockIterator.next() + " " + mockIterator.next();
		assertEquals("Mockito rocks", result);
	}

	/**
	 * Indicação de mais de um valor de retorno com diferentes condições
	 */
	@Test
	public void testReturnValueDependentOnMethodParameter() 
	{
		Comparable<String> c = mock(Comparable.class);
		when(c.compareTo("Mockito")).thenReturn(1);
		when(c.compareTo("Eclipse")).thenReturn(2);
		assertEquals(1, c.compareTo("Mockito"));
	}

	/**
	 * Indicação de valor de retorno independente de valor de parâmetro
	 */
	@Test
	public void testReturnValueIAnyGivenParameter() 
	{
		Comparable<Integer> c = mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1, c.compareTo(9));
	}

	/**
	 * Indicação de valor de retorno dependente de tipo de parâmetro
	 */
	@Test
	public void testReturnValueForGivenParameterType() 
	{
		Comparable<String> c = mock(Comparable.class);
		when(c.compareTo(isA(String.class))).thenReturn(0);
		assertEquals(0, c.compareTo("ABC"));
	}

	/**
	 * Verificação de ocorrência de exceção
	 */
	@Test(expected = IOException.class)
	public void testForIOException() throws IOException 
	{
		OutputStream mockStream = mock(OutputStream.class);
		doThrow(new IOException()).when(mockStream).close();

		OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);
		streamWriter.close();
	}
	
	/**
	 * Verifica o número de chamadas de um método sem parâmetros
	 */
	@Test
	public void testVerifyNumberOfCallsNoParameters()  
	{
		List<String> test = mock(List.class);
		test.size();
		test.size();
		
		verify(test, times(2)).size();
		verify(test, atMost(3)).size();
	}	
	
	/**
	 * Verifica o número de chamadas de um método com parâmetros
	 */
	@Test
	public void testVerifyNumberOfCallsWithParameters()  
	{
		List<String> test = mock(List.class);

		verify(test, never()).add("never called");

		test.add("called at least once");
		verify(test, atLeastOnce()).add("called at least once");

		test.add("called at least twice");
		test.add("called at least twice");
		verify(test, atLeast(2)).add("called at least twice");

		test.add("");
		test.add("");
		verify(test, times(5)).add(anyString());
	}	
}