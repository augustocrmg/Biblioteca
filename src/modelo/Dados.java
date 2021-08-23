package modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada no intuito de padronizar o local onde seriam armazenadas as informacoes
 * e facilitar o acesso e a modificao das informacoes em si.
 * */
public class Dados {
	
	/**
	 * Lista onde eu armazeno todos os dados do programa.
	 * 
	 * Nessa lista sao armazenados objetos Livro, e ela
	 * e acessavel de todo o meu trabalho podendo assim
	 * modifica-la de acordo com a necessidade e simpli-
	 * ficando o trabalho devido ao fato de toda a infor-
	 * macao ficar em um lugar.
	 * */
	public static List<Livro> obra = new ArrayList<>();

	/**
	 * Metodo usado como verificacao da pre-existencia de um livro na lista.
	 *
	 * @param livroSolicitado solicitado para ser verificado dentro da lista
	 * @return false em caso de conter, true em caso de nao conter
	 * */
	public static boolean verificaLivros(String livroSolicitado) {
		for (Livro livroComparado : obra) {
			if (livroComparado.getLivroAdicionado().toLowerCase().equals(livroSolicitado.toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Metodo usado como verificacao da pre-existencia de um autor na lista.
	 * 
	 * @param autorSolicitado solicitado para ser verificado dentro da lista
	 * @return false em caso de conter, true em caso de nao conter
	 * */
	public static boolean verificaArtista(String autorSolicitado) {
		for (Livro autorComparado : obra) {
			if (autorComparado.getAutorAdicionado().toLowerCase().equals(autorSolicitado.toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Metodo usado como verificacao da pre-existencia de um genero na lista.
	 * 
	 * @param generoSolicitado solicitado para ser verificado dentro da lista
	 * @return false em caso de conter, true em caso de nao conter
	 * */
	public static boolean verificaGenero(String generoSolicitado) {
		for (Livro generoComparado : obra) {
			if (generoComparado.getGeneroAdicionado().toLowerCase().equals(generoSolicitado.toLowerCase())) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Livro> getObra() {
		return obra;
	}

	public static void setObra(Livro obraAdicionada) {
		obra.add(obraAdicionada);
	}
	
	/**
	 * Metodo para instanciar, criar um objeto livro com os valores passados e
	 * cadastralo na lista
	 * 
	 * @param livro String de nome do Livro para ser cadastrada no objeto que por si so e adicionado na lista
	 * @param autor String de nome do Autor para ser cadastrada no objeto que por si so e adicionado na lista
	 * @param genero String de nome do Genero para ser cadastrada no objeto que por si so e adicionado na lista
	 * 
	 * @see Livro
	 * @see GeneroLiterario
	 * @see Autor
	 * @see Dados
	 * */
	public static void setObra(String livro, String autor, String genero) {
		Livro livroAdicionado = new Livro();
		livroAdicionado.setLivroAdicionado(livro);
		if(livroAdicionado.getLivroAdicionado().isBlank()) {
			return;
		}
		
		livroAdicionado.setAutorAdicionado(autor);
		if(livroAdicionado.getAutorAdicionado().isBlank()) {
			return;
		}
		
		livroAdicionado.setGeneroAdicionado(genero);
		if(livroAdicionado.getGeneroAdicionado().isBlank()) {
			return;
		}
		
		obra.add(livroAdicionado);
	}
}
