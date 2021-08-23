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
 * PainelGenero.
 * 
 * @see PainelGenero
 * */
public class PainelGeneroControlador {
	private PainelGenero menuGenero;

	/**
	 * Contrutor para inicializar o objeto PainelGeneroControlador.
	 * 
	 * @param menuGenero recebe uma variavel do tipo PainelGenero como parametro do 
	 * construtor, pois essa classe trabalha com o painel de Generos
	 * @see PainelGenero
	 * */
	public PainelGeneroControlador(PainelGenero menuGenero) {
		this.menuGenero = menuGenero;
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
			String paraAdicionar = Dados.obra.get(i).getGeneroAdicionado().toLowerCase();
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
	 * @return generoBuscado Lista para ser exibida contendo todos os valores que contenham a string buscada.
	 * @see Dados
	 */
	public DefaultListModel<String> listaGenerosBuscados(String valorBuscado) {
		var generoBuscado = new DefaultListModel<String>();
		List<String> listaProvisoria = new ArrayList<>();

		for (int i = 0; i < Dados.obra.size(); i++) {
			String paraAdicionar = Dados.obra.get(i).getGeneroAdicionado().toLowerCase();
			listaProvisoria.add(Capitalizar.capitalizar(paraAdicionar));
		}
		listaProvisoria = listaProvisoria.stream().distinct().collect(Collectors.toList());

		for (int c = 0; c < listaProvisoria.size(); c++) {
			if (VerificadorString.contemSemCapitalizar(listaProvisoria.get(c), valorBuscado)) {
				generoBuscado.addElement(listaProvisoria.get(c));
			}
		}

		return generoBuscado;
	}

	/**
	 * Metodo criado para imprimir as informacoes no painel interativo contida ao lado do programa.
	 * 
	 * Eu passo como parametro o campo que esta selecionado na minha lista principal e ele cria uma 
	 * String formatada com os valores condizentes com o campo selecionado e exibe.
	 * 
	 * @param e Parametro que passa um evento de mudanca em uma selecao, nesse caso , a mudanca de um valor selecionado
	 * no painel principal (de Generos)
	 */
	public void informacoesLista(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			
			@SuppressWarnings("unchecked")
			JList<String> lista = (JList<String>) e.getSource();
			menuGenero.getPainelInterativoMovel().setText("");
			var nomeGenero = lista.getSelectedValue();
			menuGenero.getPainelInterativoMovel().append(retornaGenero(nomeGenero));
		}
	}
	
	/** 
	 * Metodo para designar as acoes de cada um dos botoes
	 * do menu de genero.
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
	public void acaoPerformadaGenero(ActionEvent x) {
		if (x.getSource() == menuGenero.getBotaoBuscar()) {

			if (!menuGenero.getCampoBusca().getText().isBlank()) {

				String generoProcurado = menuGenero.getCampoBusca().getText();
				menuGenero.getListaGenero().setModel(listaGenerosBuscados(generoProcurado));
			}

		}else if(x.getSource() == menuGenero.getBotaoRecarregar()){
			
			menuGenero.getListaGenero().setModel(gerarModeloLista());
		} else if (x.getSource() == menuGenero.getBotaoIconeMenuPrincipal()) {
			
			var painelMenu = new PainelMenu();
			painelMenu.setVisible(true);
			menuGenero.setVisible(false);
		} else if (x.getSource() == menuGenero.getBotaoIconeLivro()) {
			
			var painelLivro = new PainelLivros();
			painelLivro.setVisible(true);
			menuGenero.setVisible(false);
		} else if (x.getSource() == menuGenero.getBotaoIconeAutor()) {
			
			var painelAutor = new PainelAutores();
			painelAutor.setVisible(true);
			menuGenero.setVisible(false);
		} else if (x.getSource() == menuGenero.getBotaoIconeGenero()) {
			
			var painelGenero = new PainelGenero();
			painelGenero.setVisible(true);
			menuGenero.setVisible(false);
		}
	}

	/**
	 * Metodo criado para gerar a String exibida no painel lateral(auxiliar) quando
	 * solicitado.
	 * 
	 * @param nomeGenero String contendo o nome do genero que foi selecionado com o mouse
	 * na lista principal.
	 * @return retorna uma String formatada usando StringBuilder contendo as obras do 
	 * genero selecionado no painel principal.
	 * */
	private String retornaGenero(String nomeGenero) {
		StringBuilder cabecalho = new StringBuilder();
		StringBuilder livrosGenero = new StringBuilder();
		cabecalho.append("Livros :\n");

		for (Livro autorProcurado : Dados.getObra()) {
			if (autorProcurado.getGeneroAdicionado().equalsIgnoreCase(nomeGenero)) {
				livrosGenero.append(" - " + autorProcurado.getLivroAdicionado() + "\n");
			}
		}
		return cabecalho.append(livrosGenero.toString()).toString();
	}
}
