package controle;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada para a padronização de qualquer que seja a string.
 */
public class Capitalizar {
	
	/** 
	 * O metodo capitaliza retorna a string 
	 * passada como parametro com o primeiro 
	 * caracter convertido para maiusculo e 
	 * os outros caracteres minusculos
	 * 
	 * @param palavraCapitalizada palavra para ser modificada
	 * @return palavraCapitalizada String com todos os caracteres alterados para minusculo ,e o primeiro para maiusculo
	 * */
	public static String capitalizar(String palavraCapitalizada) {
		
		if(palavraCapitalizada == null || palavraCapitalizada.isEmpty()) {
	        return palavraCapitalizada;
	    }
		
		palavraCapitalizada = palavraCapitalizada.toLowerCase();
		palavraCapitalizada = palavraCapitalizada.substring(0, 1).toUpperCase() + palavraCapitalizada.substring(1);
		
	    return palavraCapitalizada;
	}
}
