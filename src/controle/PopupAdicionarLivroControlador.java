package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;

import modelo.Dados;
import vista.PainelLivros;
import vista.PopupAdicionarLivro;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada na funcao de controlar as acoes executadas no
 * PopUp de adicao de obras.
 * 
 * @see PopupAdicionarLivro
 * */
public class PopupAdicionarLivroControlador {
	private PopupAdicionarLivro adicionarLivro;

	/**
	 * Contrutor para inicializar o objeto PopupAdicionarLivroControlador.
	 * 
	 * @param adicionarLivro Recebe uma variavel do tipo PopupAdicionarLivro como parametro do 
	 * construtor, pois essa classe trabalha com o painel de Livros
	 * @see PopupAdicionarLivro	
	 * */
	public PopupAdicionarLivroControlador(PopupAdicionarLivro adicionarLivro) {
		this.adicionarLivro = adicionarLivro;
	}

	/**
	 * Metodo para designar as acoes dos botoes de adicionar e cancelar
	 * do popup de adicao.
	 * 
	 * Esse metodo consegue adicionar valores na Lista obra.
	 * 
	 * @param e recebe como parametro um evento semantico que define a acao ocorrida gerada por um componente.
	 * @see PainelLivros
	 * @see PopupAdicionarLivro
	 * @see Dados
	 * */
	public void acaoPerformada(ActionEvent e) {
		if (e.getSource() == adicionarLivro.getBotaoAdicionar()) {
			/*
			 * Deixo todas as etiquetas pretas para caso tenham sido corrigidos ,os erros.
			 */
			adicionarLivro.getEtiquetaTituloLivro().setForeground(new Color(255, 204, 51));
			adicionarLivro.getEtiquetaNomeAutor().setForeground(new Color(255, 204, 51));
			adicionarLivro.getEtiquetaGeneroLiterario().setForeground(new Color(255, 204, 51));

			String livro = adicionarLivro.getCampoTituloLivro().getText();
			livro = Capitalizar.capitalizar(livro);
			String autor = adicionarLivro.getCampoAutorLivro().getText();
			autor = Capitalizar.capitalizar(autor);
			String genero = adicionarLivro.getCampoGeneroLivro().getText();
			genero = Capitalizar.capitalizar(genero);
			/*
			 * Caso os dados estejam corretos e nenhum esteja faltante, eu atualizo a minha
			 * lista e chamo o menu de volta
			 */
			if (Dados.verificaLivros(livro)) {
				if (!livro.isBlank() && !autor.isBlank() && !genero.isBlank()) {
					Dados.setObra(livro, autor, genero);

					var painelLivros = new PainelLivros();
					painelLivros.setVisible(true);
					adicionarLivro.setVisible(false);

				}
			}
			/*
			 * Caso contrario, eu pinto as informacoes faltantes ou incorretas de vermelho
			 */
			if (livro.isBlank() || !Dados.verificaLivros(livro)) {
				adicionarLivro.getEtiquetaTituloLivro().setForeground(Color.red);
			}
			if (autor.isBlank()) {
				adicionarLivro.getEtiquetaNomeAutor().setForeground(Color.red);
			}
			if (genero.isBlank()) {
				adicionarLivro.getEtiquetaGeneroLiterario().setForeground(Color.red);
			}

		} else if (e.getSource() == adicionarLivro.getBotaoCancelar()) {
			/*
			 * Desativo a janela anterior e chamo o menu de livros novamente
			 */
			adicionarLivro.setVisible(false);

			var painelLivros = new PainelLivros();
			painelLivros.setVisible(true);
			adicionarLivro.setVisible(false);
		}
	}

}
