/**
 * Classe que verifica se um texto � compat�vel com uma express�o regular
 * 
 * @author Marcio
 */
public class Matcher 
{
	/**
	 * Procura pela express�o regular em qualquer parte do texto
	 */
    public boolean match(String regex, String text)
    {
    	int regexLength = regex.length();
    	int textLength = text.length();

    	/* Se a regex come�a com ^, o texto deve ser compat�vel desde o in�cio */
        if (regexLength > 0)
        	if (regex.charAt(0) == '^')
        		return matchPosition(regex, 1, regexLength, text, 0, textLength);
        
    	/* Testa se a primeira posi��o do texto � compat�vel */
        if (matchPosition(regex, 0, regexLength, text, 0, textLength))
            return true;
        
    	/* Testa se as demais posi��es do texto s�o compat�veis */
        for (int i = 1; i < textLength; i++) 
            if (matchPosition(regex, 0, regexLength, text, i, textLength))
                return true;
        
        return false;
    }

    /**
     * Procura pela express�o regular no in�cio do texto
     */
    private boolean matchPosition(String regex, int regexIndex, int regexLength, String text, int textIndex, int textLength)
    {
    	/* Se a regex acabou, o texto � compat�vel */
    	if (regexLength == regexIndex)
            return true;
        
    	/* Tratamento de * na regex */
        if (regexLength > regexIndex+1 && regex.charAt(regexIndex+1) == '*')
            return matchAsterisc(regex.charAt(regexIndex), regex, regexIndex + 2, regexLength, text, textIndex, textLength);
        
    	/* Se a regex tem um $ na sua �ltima posi��o, o texto deve acabar */
    	if (regex.charAt(regexIndex) == '$' && regexLength == regexIndex+1)
            return textLength == textIndex;
    	
    	/* Pega o pr�ximo caractere da regex */
    	char regexChar = regex.charAt(regexIndex);
        
    	/* Se ainda h� texto, verifica se o caractere � compat�vel e passa para o pr�ximo */
        if (textLength > textIndex && (regexChar == '.' || regexChar == text.charAt(textIndex)))
            return matchPosition(regex, regexIndex + 1, regexLength, text, textIndex+1, textLength);
        
        return false;
    }

    /**
     * Procura por uma express�o do tipo c*regexp no in�cio do texto
     */
    private boolean matchAsterisc(int regexChar, String regex, int regexIndex, int regexLength, String text, int textIndex, int textLength)
    {
    	/* Verifica se a regex depois do * � compat�vel com o texto */
        if (matchPosition(regex, regexIndex, regexLength, text, textIndex, textLength))
            return true;

    	/* Enquanto o caractere estiver se repetindo, verifica se o texto seguinte � compat�vel com a regex */
        while (textLength > textIndex && (regexChar == '.' || regexChar == text.charAt(textIndex)))
           	if (matchPosition(regex, regexIndex, regexLength, text, ++textIndex, textLength))
                return true;
        
        return false;
    }
}