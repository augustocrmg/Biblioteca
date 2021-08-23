package modelo;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe abstrata para de caracterizacao de Genero literario. Herda a classe
 * Autor.
 * 
 * @see Autor
 */
public abstract class GeneroLiterario extends Autor {
	protected String generoAdicionado;

	/**
	 * Metodo construtor de GeneroLiterario, que chama o construtor da super classe
	 * 
	 * @param generoAdicionado
	 * @param autorAdicionado
	 */
	protected GeneroLiterario(String generoAdicionado, String autorAdicionado) {
		super(autorAdicionado);
		this.generoAdicionado = generoAdicionado;
	}

	/**
	 * Sobrecarga do construtor de GeneroLiterario em caso de propiedade iguais a null
	 */
	protected GeneroLiterario() {
		super();
		this.generoAdicionado = null;
	}

	public String getGeneroAdicionado() {
		return generoAdicionado;
	}

	public void setGeneroAdicionado(String generoAdicionado) {
		this.generoAdicionado = generoAdicionado;
	}
}
