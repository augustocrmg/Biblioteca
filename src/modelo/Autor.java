package modelo;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe abstrata para de caracterizacao de Genero literario.
 */
public abstract class Autor {
	protected String autorAdicionado;

	/**
	 * Metodo de contrutor da classe Autor
	 * 
	 * @param autorAdicionado
	 */
	protected Autor(String autorAdicionado) {
		this.autorAdicionado = autorAdicionado;
	}

	/**
	 * Sobrecarga do construtor de Autor em caso de propiedade iguais a null
	 */
	protected Autor() {
		this.autorAdicionado = null;
	}

	public String getAutorAdicionado() {
		return autorAdicionado;
	}

	public void setAutorAdicionado(String autorAdicionado) {
		this.autorAdicionado = autorAdicionado;
	}

}
