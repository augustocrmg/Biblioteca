package controle;

import java.awt.event.ActionEvent;

import modelo.Dados;
import vista.PainelAutores;
import vista.PainelGenero;
import vista.PainelLivros;
import vista.PainelMenu;
/**
 * @author Augusto Durães Camargo
 * @version 5.0
 * 
 * Classe criada na funcao de controlar as acoes executadas no
 * PainelMenu.
 * 
 * @see PainelMenu
 * */
public class MenuControlador {
	private PainelMenu menu;
	
	/**
	 * Contrutor para inicializar o objeto MenuControlador.
	 * 
	 * @param menu recebe uma variavel do tipo PainelMenu como parametro do 
	 * construtor, pois essa classe trabalha com o painel do Menu
	 * @see PainelMenu
	 * */
	public MenuControlador(PainelMenu menu) {
		this.menu = menu;
	}
	
	/**
	 * Metodo para habilitar e ou desabilitar os botoes 
	 * que nao sao necessarios no painel menu em caso de
	 * a lista obra estar vazia pois nao haveriam informacoes 
	 * para serem exibidas.
	 * 
	 * @see PainelMenu
	 * @see Dados
	 * */
	public void verificaBotoes() {
		if (Dados.getObra().isEmpty()) {
			menu.getBotaoAutor().setEnabled(false);
			menu.getBotaoGeneroLiterario().setEnabled(false);
		}
	}
	
	/**
	 * Metodo para designar as acoes de cada um dos botoes
	 * do menu principal.
	 * Sendo os botoes do menu "Livros", "Autor" e "Genero Literario".
	 * Quando um dos botoes e ativado , ele chama o painel correspondente e fecha o painel do Menu.
	 * 
	 * @param e recebe como parametro um evento semantico que define a acao ocorrida gerada por um componente .
	 * */
	public void acaoPerformada(ActionEvent e) {
		if (e.getSource() == menu.getBotaoLivros()) {
			var painelLivro = new PainelLivros();
			painelLivro.setVisible(true);
			menu.setVisible(false);

		} else if (e.getSource() == menu.getBotaoAutor()) {
			var painelAutor = new PainelAutores();
			painelAutor.setVisible(true);
			menu.setVisible(false);

		} else if (e.getSource() == menu.getBotaoGeneroLiterario()) {
			var painelGenero = new PainelGenero();
			painelGenero.setVisible(true);
			menu.setVisible(false);
		}
	}
}
