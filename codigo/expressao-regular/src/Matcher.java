/**
 * Classe que verifica se um texto é compatível com uma expressão regular
 * 
 * @author Marcio
 */
public class Matcher 
{
	/**
	 * Procura pela expressão regular em qualquer parte do texto
	 */
    public boolean match(String regex, String text)
    {
    	int regexLength = regex.length();
    	int textLength = text.length();

    	/* Se a regex começa com ^, o texto deve ser compatível desde o início */
        if (regexLength > 0)
        	if (regex.charAt(0) == '^')
        		return matchPosition(regex, 1, regexLength, text, 0, textLength);
        
    	/* Testa se a primeira posição do texto é compatível */
        if (matchPosition(regex, 0, regexLength, text, 0, textLength))
            return true;
        
    	/* Testa se as demais posições do texto são compatíveis */
        for (int i = 1; i < textLength; i++) 
            if (matchPosition(regex, 0, regexLength, text, i, textLength))
                return true;
        
        return false;
    }

    /**
     * Procura pela expressão regular no início do texto
     */
    private boolean matchPosition(String regex, int regexIndex, int regexLength, String text, int textIndex, int textLength)
    {
    	/* Se a regex acabou, o texto é compatível */
    	if (regexLength == regexIndex)
            return true;
        
    	/* Tratamento de * na regex */
        if (regexLength > regexIndex+1 && regex.charAt(regexIndex+1) == '*')
            return matchAsterisc(regex.charAt(regexIndex), regex, regexIndex + 2, regexLength, text, textIndex, textLength);
        
    	/* Se a regex tem um $ na sua última posição, o texto deve acabar */
    	if (regex.charAt(regexIndex) == '$' && regexLength == regexIndex+1)
            return textLength == textIndex;
    	
    	/* Pega o próximo caractere da regex */
    	char regexChar = regex.charAt(regexIndex);
        
    	/* Se ainda há texto, verifica se o caractere é compatível e passa para o próximo */
        if (textLength > textIndex && (regexChar == '.' || regexChar == text.charAt(textIndex)))
            return matchPosition(regex, regexIndex + 1, regexLength, text, textIndex+1, textLength);
        
        return false;
    }

    /**
     * Procura por uma expressão do tipo c*regexp no início do texto
     */
    private boolean matchAsterisc(int regexChar, String regex, int regexIndex, int regexLength, String text, int textIndex, int textLength)
    {
    	/* Verifica se a regex depois do * é compatível com o texto */
        if (matchPosition(regex, regexIndex, regexLength, text, textIndex, textLength))
            return true;

    	/* Enquanto o caractere estiver se repetindo, verifica se o texto seguinte é compatível com a regex */
        while (textLength > textIndex && (regexChar == '.' || regexChar == text.charAt(textIndex)))
           	if (matchPosition(regex, regexIndex, regexLength, text, ++textIndex, textLength))
                return true;
        
        return false;
    }
}