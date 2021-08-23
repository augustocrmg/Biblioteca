package modelo;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe que cria um livro, com o nome do livro. Devido a heranca de
 * GeneroLiterario, que por si so herda Autor, essa classe cria um livro ja com
 * genero literario e autor.
 * 
 * @see GeneroLiterario
 */
public class Livro extends GeneroLiterario {
	private String livroAdicionado;

	/**
	 * Construtores de Livro, que por si so chamam o contrutor da super classe
	 * 
	 * @param livroAdicionado  Nome do livro
	 * @param generoAdicionado Genero do livro
	 * @param autorAdicionado  Autor do livro
	 *
	 */
	public Livro(String livroAdicionado, String generoAdicionado, String autorAdicionado) {
		super(generoAdicionado, autorAdicionado);
		this.livroAdicionado = livroAdicionado;
	}

	/**
	 * Sobrecarga do construtor, que constroi um livro com todas as propiedades igual a null, caso se queira
	 * cadastrar posteriormente
	 */
	public Livro() {
		super();
		this.livroAdicionado = null;
	}

	public String getLivroAdicionado() {
		return livroAdicionado;
	}

	public void setLivroAdicionado(String livroAdicionado) {
		this.livroAdicionado = livroAdicionado;
	}
}
