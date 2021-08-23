package controle;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada para a verificacaos de strings,
 * visando a nao repeticao de codigo, visto que 
 * e uma acao necessaria em varias partes do co-
 * digo.
 */
public class VerificadorString {
	
	/**
	 * O metodo contemSemCapitalizar recebe duas strings como parametro,
	 * as converte em minusculas e ja retorna o resultado de sua comparacao,
	 * sendo as possibilidades de retorno , booleanos.
	 * 
	 * @param fonte String base com que a outra String se compara 
 	 * @param comparada String comparada com a String fonte
	 * @return retorna true or false em caso de a String fonte conter a comparada.
	 * */
	public static boolean contemSemCapitalizar(String fonte, String comparada) {
			fonte = fonte.toLowerCase();
			comparada = comparada.toLowerCase();
			
		return fonte.contains(comparada);
	}
}
