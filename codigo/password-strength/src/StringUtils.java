/**
 * {@code StringUtils} contains static methods which operate on a string.
 */
public class StringUtils 
{
	private final static int[] SIZE_TABLE = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

	/**
	 * calculate the size of an integer number
	 */
	public static int sizeOfInt(int x) 
	{
		for (int i = 0;; i++)
			if (x <= SIZE_TABLE[i]) 
				return i + 1;
	}

	/**
	 * Judge whether each character of the string equals
	 */
	public static boolean isCharEqual(String str) 
	{
		return str.replace(str.charAt(0), ' ').trim().length() == 0;
	}

	/**
	 * Determines if the string is a digit
	 */
	public static boolean isNumeric(String str) 
	{
		for (int i = str.length(); --i >= 0;) 
		{
			if (!Character.isDigit(str.charAt(i))) 
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Judge whether the string is whitespace, empty ("") or null.
	 */
	public static boolean equalsNull(String str) 
	{
		int strLen;
		
		if (str == null || (strLen = str.length()) == 0 || str.equalsIgnoreCase("null")) 
		{
			return true;
		}
		
		for (int i = 0; i < strLen; i++) 
		{
			if ((Character.isWhitespace(str.charAt(i)) == false)) 
			{
				return false;
			}
		}
		return true;
	}
}