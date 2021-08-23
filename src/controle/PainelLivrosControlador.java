package controle;

import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

import modelo.Dados;
import modelo.Livro;
import vista.PainelAutores;
import vista.PainelGenero;
import vista.PainelLivros;
import vista.PainelMenu;
import vista.PopupAdicionarLivro;

/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada na funcao de controlar as acoes executadas no
 * PainelLivross.
 * 
 * @see PainelLivros
 * */
public class PainelLivrosControlador {
	private PainelLivros retornoPainel;

	/**
	 * Contrutor para inicializar o objeto PainelLivrosControlador.
	 * 
	 * @param menuAutores recebe uma variavel do tipo PainelLivros como parametro do 
	 * construtor, pois essa classe trabalha com o painel de Livros
	 * @see PainelLivros	
	 * */
	public PainelLivrosControlador(PainelLivros menuAutores) {
		this.retornoPainel = menuAutores;
	}

	/**
	 * Metodo que gera um modelo de lista para ser exibida no painel principal.
	 * 
	 * No metodo sao geradas duas listas, uma provisoria do tipo List , e a final
	 * do tipo DefaultListModel que e o tipo necessario para exibicao no painel
	 * 
	 * Na provisoria eu adiciono os valores que serao exibidos, e removo os duplicados.
	 * Logo apos eu adiciono os elementos na lista final e a retorno.
	 * 
	 * @return modeloLista retorna a Lista a ser exibida, contendo todos os valores da minha lista contida
	 * em dados 
	 * @see Dados
	 */
	public DefaultListModel<String> gerarModeloLista() {
		var modeloLista = new DefaultListModel<String>();
		retornoPainel.getPainelInterativoMovel().setText(null);

		for (int i = 0; i < Dados.obra.size(); i++) {
			String adicionado = Capitalizar.capitalizar(Dados.obra.get(i).getLivroAdicionado());
			modeloLista.addElement(adicionado);
		}
		return modeloLista;
	}

	/**
	 * Metodo que gera um modelo de lista para ser exibida no painel principal, no 
	 * entanto retorna apenas os valores que atendem a busca pela string passada
	 * como parametro.
	 * 
	 * No metodo sao geradas duas listas, uma provisoria do tipo List , e a final
	 * do tipo DefaultListModel que e o tipo necessario para exibicao no painel
	 * 
	 * Na provisoria eu adiciono os valores que serao exibidos, e removo os duplicados.
	 * Logo apos eu adiciono os elementos na lista final que atendem o parametro 
	 * da busca e a retorno.
	 * 
	 * @param valorBuscado String passada para ser buscada dentro da lista.
	 * @return livrosBuscados Lista para ser exibida contendo todos os valores que contenham a string buscada.
	 * @see Dados
	 */
	public static DefaultListModel<String> listaLivrosBuscados(String valorBuscado) {
		var livrosBuscados = new DefaultListModel<String>();

		for (int i = 0; i < Dados.obra.size(); i++) {

			if (VerificadorString.contemSemCapitalizar(Dados.getObra().get(i).getLivroAdicionado(), valorBuscado)) {
				String adicionado = Capitalizar.capitalizar(Dados.obra.get(i).getLivroAdicionado());
				livrosBuscados.addElement(adicionado);
			}
		}
		return livrosBuscados;
	}

	/**
	 * Metodo criado para imprimir as informacoes no painel interativo contida ao lado do programa.
	 * 
	 * Eu passo como parametro o campo que esta selecionado na minha lista principal e ele cria uma 
	 * String formatada com os valores condizentes com o campo selecionado e exibe.
	 * 
	 * @param e Parametro que passa um evento de mudanca em uma selecao, nesse caso , a mudanca de um valor selecionado
	 * no painel principal (de Livros)
	 */
	public void informacoesLista(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			
			@SuppressWarnings("unchecked")
			JList<String> lista = (JList<String>) e.getSource();
			retornoPainel.getPainelInterativoMovel().setText(null);
			var nomeLivro = lista.getSelectedValue();
			retornoPainel.getPainelInterativoMovel().append(retornaLivro(nomeLivro));
		}
	}

	/**
	 * Metodo criado para excluir da lista princial a string que esta sendo passada.
	 * 
	 * Metodo criado em apoio ao botao excluir que exclui um valor selecionado no painel
	 * principal do menu.
	 * 
	 * @param excluido String para ser buscada na minha lista e ser excluida.
	 * */
	public void exclusaoValor(String excluido) {
		for (Livro valorProcurado : Dados.getObra()) {
			if (valorProcurado.getLivroAdicionado().toLowerCase().equals(excluido.toLowerCase())) {
				Dados.getObra().remove(valorProcurado);
				return;
			}
		}
	}

	/**
	 * Metodo para designar as acoes de cada um dos botoes
	 * do menu de livros.
	 * 
	 * O metodo controla os botoes da parte referente aos paineis(recarregar, buscar, excluir e adicionar),
	 * alem disso ele tambem controla o menu lateral que tem botoes que dao acesso a 
	 * as telas de "Menu","Livros","Autores","Generos Literarios".
	 * 
	 * @param x recebe como parametro um evento semantico que define a acao ocorrida gerada por um componente.
	 * @see PainelLivros
	 * @see PainelAutores
	 * @see PainelGenero
	 * @see PainelMenu
	 * @see PopupAdicionarLivro
	 * */
	public void botoesAtivados(ActionEvent x) {
		if (x.getSource() == retornoPainel.getBotaoAdicionar()) {

			var popUpAdiciona = new PopupAdicionarLivro();
			popUpAdiciona.setVisible(true);
			retornoPainel.setVisible(false);

		} else if (x.getSource() == retornoPainel.getBotaoBuscar()) {

			if (!retornoPainel.getCampoBusca().getText().isBlank()) {

				String livroProcurado = retornoPainel.getCampoBusca().getText().toLowerCase();
				retornoPainel.getListaLivros().setModel(listaLivrosBuscados(livroProcurado));
			}
		} else if (x.getSource() == retornoPainel.getBotaoExcluir()) {
			
			if (!Dados.getObra().isEmpty()) {
				
				exclusaoValor(retornoPainel.getListaLivros().getSelectedValue());
				retornoPainel.getListaLivros().setModel(gerarModeloLista());
				if(Dados.getObra().isEmpty()) {
					
					var painelMenu = new PainelMenu();
					painelMenu.setVisible(true);
					retornoPainel.setVisible(false);
				}
			}
		} else if (x.getSource() == retornoPainel.getBotaoRecarregar()) {

			retornoPainel.getListaLivros().setModel(gerarModeloLista());
		} else if (x.getSource() == retornoPainel.getBotaoIconeMenuPrincipal()) {
			
			var painelMenu = new PainelMenu();
			painelMenu.setVisible(true);
			retornoPainel.setVisible(false);
		} else if (x.getSource() == retornoPainel.getBotaoIconeLivro()) {
			
			var painelLivro = new PainelLivros();
			painelLivro.setVisible(true);
			retornoPainel.setVisible(false);
		} else if (x.getSource() == retornoPainel.getBotaoIconeAutor()) {
			
			var painelAutor = new PainelAutores();
			painelAutor.setVisible(true);
			retornoPainel.setVisible(false);
		} else if (x.getSource() == retornoPainel.getBotaoIconeGenero()) {
			
			var painelGenero = new PainelGenero();
			painelGenero.setVisible(true);
			retornoPainel.setVisible(false);
		}
	}

	/**
	 * Metodo criado para gerar a String exibida no painel lateral(auxiliar) quando
	 * solicitado.
	 * 
	 * @param nomeLivro String contendo o nome do Livro que foi selecionado com o mouse
	 * na lista principal.
	 * @return retorna uma String formatada usando StringBuilder contendo nome, autor e 
	 * genero da obra selecionada.
	 * */
	private String retornaLivro(String nomeLivro) {
		StringBuilder livroExibido = new StringBuilder();
		for (Livro livroProcurado : Dados.getObra()) {
			if (livroProcurado.getLivroAdicionado().equalsIgnoreCase(nomeLivro)) {
				livroExibido.append("Titulo : ");
				livroExibido.append(Capitalizar.capitalizar(livroProcurado.getLivroAdicionado()));
				livroExibido.append("\n\nAutor : ");
				livroExibido.append(Capitalizar.capitalizar(livroProcurado.getAutorAdicionado()));
				livroExibido.append("\n\nGenero Literario : ");
				livroExibido.append(Capitalizar.capitalizar(livroProcurado.getGeneroAdicionado()));
			}
		}
		return livroExibido.toString();
	}
}
