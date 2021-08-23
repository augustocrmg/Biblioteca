package TestesJunit5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import modelo.*;
import vista.PainelAutores;
import vista.PainelGenero;
import vista.PainelLivros;
import vista.PopupAdicionarLivro;
import org.junit.jupiter.api.Test;
public class TesteFuncoes {

	/*
	 * Testa o cadastro de um novo livro diretamente na lista
	 * com informacoes nulas de diversas maneiras.
	 * */
	@Test
	void testCadastroNulo() {
		/*
		 * Como eu cadastrei as validacoes no backend do popup de adicao
		 * eu precisei instanciar o popup e setar as informacoes para realizar
		 * o teste
		 * 
		 * Aqui eu faco a tentativa de adicao de valores nulos, porem a minha valida-
		 * cao nao permite
		 * */
		Dados.obra.clear();
		
		var interfaceTeste = new PopupAdicionarLivro();
		
		interfaceTeste.getCampoTituloLivro().setText("         ");
		interfaceTeste.getCampoAutorLivro().setText("           ");
		interfaceTeste.getCampoGeneroLivro().setText("        ");
		
		interfaceTeste.getBotaoAdicionar().doClick();
		
		assertTrue(Dados.obra.isEmpty());
	}

	@Test
	void testCadastroNaoNulo() {
		/*
		 * Aqui eu dou um exemplo de uma adicao padrao de um
		 * */
		Dados.obra.clear();
		
		var interfaceTeste = new PopupAdicionarLivro();
		
		interfaceTeste.getCampoTituloLivro().setText("Dom Quixote");
		interfaceTeste.getCampoAutorLivro().setText("Miguel de Cervantes");
		interfaceTeste.getCampoGeneroLivro().setText("Romance");
		
		interfaceTeste.getBotaoAdicionar().doClick();
		
		assertFalse(Dados.obra.isEmpty());
	}
	
	@Test
	void pesquisaDeLivros() {
		/*
		 * Aqui eu testo a busca de informacoes dentro da minha lista
		 * 
		 * Na lista e possivel buscar por partes de uma palavra e nao somente 
		 * pela palavra inteira
		 * 
		 * Busco pela palavra dom, que tem especificamente dois livros com esse exato nome
		 * */
		Dados.obra.clear();
		adicaoParaTeste();
		
		var interfaceTeste = new PainelLivros();
		
		interfaceTeste.getCampoBusca().setText("DOM");
		interfaceTeste.getBotaoBuscar().doClick();
		
		assertEquals(interfaceTeste.getListaLivros().getModel().getSize(), 2);
	}
	
	@Test
	void pesquisaDeAutores() {
		/*
		 * Aqui eu testo a busca por um autor em especifico, com seu nome alternado em letras
		 * maiusculas e minusculas, ao fazer isso eu testo as validacoes tambem
		 * */
		Dados.obra.clear();
		adicaoParaTeste();
		
		var interfaceTeste = new PainelAutores();
		
		interfaceTeste.getCampoBusca().setText("OrWeLL");
		interfaceTeste.getBotaoBuscar().doClick();
		
		assertEquals(interfaceTeste.getListaAutores().getModel().getSize(), 1);
	}
	
	@Test
	void pesquisaDeGenero() {
		/*
		 * Aqui eu testo a busca por um genero cadastrado
		 * */
		Dados.obra.clear();
		adicaoParaTeste();
		
		var interfaceTeste = new PainelGenero();
		
		interfaceTeste.getCampoBusca().setText("Romance");
		interfaceTeste.getBotaoBuscar().doClick();
		
		assertEquals(interfaceTeste.getListaGenero().getModel().getSize(), 1);
	}
	
	public void adicaoParaTeste() {
		/*
		 * Adiciono varias informacoes para teste, caso necessario
		 * */
		Dados.setObra("Dom Quixote","Miguel de Cervantes","Romance");
		Dados.setObra("Dom Casmurro","Machado de Assis","Realismo");
		Dados.setObra("Biografia Steve Jobs","Walter Isaacson","Biografia");
		Dados.setObra("O senhor dos aneis","J. R. R. Tolkien","Romance");
		Dados.setObra("1984","George Orwell","Ficcao Politica");
	}
}
