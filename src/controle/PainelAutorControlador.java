package controle;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

import modelo.Dados;
import modelo.Livro;
import vista.PainelAutores;
import vista.PainelGenero;
import vista.PainelLivros;
import vista.PainelMenu;
/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada na funcao de controlar as acoes executadas no
 * PainelAutores.
 * 
 * @see PainelAutores
 * */
public class PainelAutorControlador {
	private PainelAutores menuAutor;

	/**
	 * Contrutor para inicializar o objeto PainelAutorControlador.
	 * 
	 * @param menuAutor recebe uma variavel do tipo PainelAutores como parametro do 
	 * construtor, pois essa classe trabalha com o painel de Autores
	 * @see PainelAutores
	 * */
	public PainelAutorControlador(PainelAutores menuAutor) {
		this.menuAutor = menuAutor;
	}

	/**
	 * Metodo que gera um modelo de lista para ser exibida no painel principal.
	 * 
	 * No metodo sao geradas duas listas, uma provisoria do tipo List , e a final
	 * do tipo DefaultListModel sendo esse o tipo necessario para exibicao no painel.
	 * 
	 * Na provisoria eu adiciono os valores que serao exibidos, e removo os duplicados que 
	 * existiam previamente na primeira lista.
	 * Logo apos eu adiciono os elementos na lista final e passo como retorno.
	 * 
	 * @return modeloLista retorna a Lista a ser exibida, contendo todos os valores da minha lista contida
	 * em dados 
	 * @see Dados
	 */
	public DefaultListModel<String> gerarModeloLista() {
		var modeloLista = new DefaultListModel<String>();
		List<String> listaProvisoria = new ArrayList<>();

		for (int i = 0; i < Dados.obra.size(); i++) {
			String paraAdicionar = Dados.obra.get(i).getAutorAdicionado().toLowerCase();
			listaProvisoria.add(Capitalizar.capitalizar(paraAdicionar));
		}
		
		listaProvisoria = listaProvisoria.stream().distinct().collect(Collectors.toList());

		for (int c = 0; c < listaProvisoria.size(); c++) {
			modeloLista.addElement(listaProvisoria.get(c));
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
	 * @return autorBuscado Lista para ser exibida contendo todos os valores que contenham a string buscada.
	 * @see Dados
	 */
	public DefaultListModel<String> listaAutoresBuscados(String valorBuscado) {
		
		var autorBuscado = new DefaultListModel<String>();
		List<String> listaProvisoria = new ArrayList<>();

		for (int i = 0; i < Dados.obra.size(); i++) {
			
			listaProvisoria.add(Dados.obra.get(i).getAutorAdicionado());
		}
		
		listaProvisoria = listaProvisoria.stream().distinct().collect(Collectors.toList());

		for (int c = 0; c < listaProvisoria.size(); c++) {
			
			if (VerificadorString.contemSemCapitalizar(listaProvisoria.get(c), valorBuscado)) {
				autorBuscado.addElement(listaProvisoria.get(c));
			}
		}

		return autorBuscado;
	}

	/**
	 * Metodo criado para imprimir as informacoes no painel interativo contida ao lado do programa.
	 * 
	 * Eu passo como parametro o campo que esta selecionado na minha lista principal e ele cria uma 
	 * String formatada com os valores condizentes com o campo selecionado e exibe.
	 * 
	 * @param e Parametro que passa um evento de mudanca em uma selecao, nesse caso , a mudanca de um valor selecionado
	 * no painel principal (de Autores)
	 */
	public void informacoesLista(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			
			@SuppressWarnings("unchecked")
			JList<String> lista = (JList<String>) e.getSource();
			menuAutor.getPainelInterativoMovel().setText("");
			var nomeAutor = lista.getSelectedValue();
			menuAutor.getPainelInterativoMovel().append(retornaAutor(nomeAutor));
		}
	}

	/**
	 * Metodo para designar as acoes de cada um dos botoes
	 * do menu de autor.
	 * O metodo controla os botoes da parte referente aos paineis(recarregar e buscar),
	 * alem disso ele tambem controla o menu lateral que tem botoes que dao acesso a 
	 * as telas de "Menu","Livros","Autores","Generos Literarios".
	 * 
	 * @param x recebe como parametro um evento semantico que define a acao ocorrida gerada por um componente.
	 * @see PainelLivros
	 * @see PainelAutores
	 * @see PainelGenero
	 * @see PainelMenu
	 * */
	public void acaoPerformadaAutor(ActionEvent x) {
		if (x.getSource() == menuAutor.getBotaoBuscar()) {

			if (!menuAutor.getCampoBusca().getText().isBlank()) {
				
				String autorProcurado = menuAutor.getCampoBusca().getText();
				menuAutor.getListaAutores().setModel(listaAutoresBuscados(autorProcurado));
			}
		}else if(x.getSource() == menuAutor.getBotaoRecarregar()) {
			
			menuAutor.getListaAutores().setModel(gerarModeloLista());
		} else if (x.getSource() == menuAutor.getBotaoIconeMenuPrincipal()) {
			
			var painelMenu = new PainelMenu();
			painelMenu.setVisible(true);
			menuAutor.setVisible(false);
		} else if (x.getSource() == menuAutor.getBotaoIconeLivro()) {
			
			var painelLivro = new PainelLivros();
			painelLivro.setVisible(true);
			menuAutor.setVisible(false);
		} else if (x.getSource() == menuAutor.getBotaoIconeAutor()) {
			
			var painelAutor = new PainelAutores();
			painelAutor.setVisible(true);
			menuAutor.setVisible(false);
		} else if (x.getSource() == menuAutor.getBotaoIconeGenero()) {
			
			var painelGenero = new PainelGenero();
			painelGenero.setVisible(true);
			menuAutor.setVisible(false);
		}
	}
	
	/**
	 * Metodo criado para gerar a String exibida no painel lateral(auxiliar) quando
	 * solicitado.
	 * 
	 * @param nomeAutor String contendo o nome do autor que foi selecionado com o mouse
	 * na lista principal.
	 * @return retorna uma String formatada usando StringBuilder contendo nome e obras do 
	 * autor selecionado no painel principal.
	 * */
	private String retornaAutor(String nomeAutor) {
		StringBuilder cabecalho = new StringBuilder();
		StringBuilder obrasAutor = new StringBuilder();
		cabecalho.append("Obras :\n");

		for (Livro autorProcurado : Dados.getObra()) {
			if (autorProcurado.getAutorAdicionado().equalsIgnoreCase(nomeAutor)) {
				obrasAutor.append(" - " + autorProcurado.getLivroAdicionado() + "\n");
			}
		}
		return cabecalho.append(obrasAutor.toString()).toString();
	}

}
