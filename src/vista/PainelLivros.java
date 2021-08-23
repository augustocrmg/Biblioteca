package vista;

import controle.PainelLivrosControlador;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

/**
 * Classe que implementa o painel de Livros e seus metodos referentes aos botoes
 * de busca, e de acesso a menus de "Autor", "Livro", "Genero", "Menu"
 * 
 * Herda a classe Jframe e implementa as interfaces ListSelectionListener e ActionListener,
 * para criar e deixar o painel e suas usabilidades funcionais
 * 
 * @see JFrame
 * @see ListSelectionListener
 * @see ActionListener
 * */
public class PainelLivros extends JFrame implements ListSelectionListener, ActionListener {
	private static final long serialVersionUID = 1L;
	
	PainelLivrosControlador menuPainelLivros;
	private JPanel contentPane;
	private JPanel panelIcones;
	private JScrollPane painelInterativo;
	private JTextArea painelInterativoMovel;
	private JTextField campoBusca;
	private JList<String> listaLivros;
	private JLabel tituloPagina;
	private JButton botaoRecarregar;
	private JButton botaoIconeLivro;	
	private JButton botaoIconeAutor;
	private JButton botaoIconeGenero;
	private JButton botaoIconeMenuPrincipal;
	private JButton botaoBuscar;
	private JButton botaoExcluir;
	private JButton botaoAdicionar;
	
	/**
	 * Construtor de painel que gera a tela de Livros e tambem contem a definicao de suas
	 * caracteristicas graficas 
	 * 
	 * Os metodos atrelados aos botoes e outras funcoes do painel estao contidas no backend
	 * 
	 * @see PainelLivrosControlador
	 * */
	public PainelLivros() {
		//Seleciono o icone da minha janela do programa.
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/bancoImagens/livro_redondo.png")));
		
		//Instancio a classe responsavel pelo backend do programa.
		menuPainelLivros = new PainelLivrosControlador(this);

		//Defino aqui as caracteristicas da janela e os paineis que ela contem no fundo.
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 587);
		setTitle("Biblioteca Virtual");
		setLocationRelativeTo(null);
		validate();
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		//Defino aqui as caracteristicas e atributos do campo que exibe meu titulo.
		tituloPagina = new JLabel("Livros");
		tituloPagina.setBounds(81, 33, 152, 29);
		tituloPagina.setForeground(new Color(255, 102, 0));
		tituloPagina.setBackground(new Color(102, 102, 102));
		tituloPagina.setHorizontalTextPosition(SwingConstants.CENTER);
		tituloPagina.setFont(new Font("Tahoma", Font.BOLD, 30));
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tituloPagina);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o botao Buscar.
		botaoBuscar = new JButton("Buscar");
		botaoBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoBuscar.setBackground(new Color(204, 204, 204));
		botaoBuscar.setBounds(889, 44, 78, 23);
		botaoBuscar.setBorderPainted(false);
		contentPane.add(botaoBuscar);
		botaoBuscar.addActionListener(this);
		
		//Defino aqui as caracteristicas, atributos e ligo com o backend o botao Excluir.
		botaoExcluir = new JButton("Excluir\r\n");
		botaoExcluir.setBounds(114, 507, 89, 23);
		botaoExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoExcluir.setBorderPainted(false);
		botaoExcluir.setBackground(new Color(204, 204, 204));
		contentPane.add(botaoExcluir);
		botaoExcluir.addActionListener(this);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o botao Adicionar.
		botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.setBackground(new Color(204, 204, 204));
		botaoAdicionar.setForeground(new Color(0, 0, 0));
		botaoAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoAdicionar.setBounds(868, 507, 99, 23);
		botaoAdicionar.setBorderPainted(false);
		contentPane.add(botaoAdicionar);
		botaoAdicionar.addActionListener(this);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o botao Recarregar.
		botaoRecarregar = new JButton("Recarregar");
		botaoRecarregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoRecarregar.setBackground(new Color(204, 204, 204));
		botaoRecarregar.setBounds(596, 507, 105, 23);
		botaoRecarregar.setBorderPainted(false);
		contentPane.add(botaoRecarregar);
		botaoRecarregar.addActionListener(this);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o painel principal,
		//nele sao dispostas as informacoes contidas na minha lista, e e possivel interagir 
		// com ele excluindo valores e ou clicando neles para vizualizar no painel 
		//lateral(auxiliar).
		painelInterativo = new JScrollPane();
		painelInterativo.setBounds(114, 78, 587, 418);
		contentPane.add(painelInterativo);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o painel lateral,
		//que exibe as informacoes atreladas ao campo selecionado no painel principal.
		painelInterativoMovel = new JTextArea();
		painelInterativoMovel.setEditable(false);
		painelInterativoMovel.setBackground(new Color(204, 204, 204));
		painelInterativoMovel.setBounds(711, 78, 256, 418);
		contentPane.add(painelInterativoMovel);

		//Defino a lista interativa que sera exibida no painel principal.
		listaLivros = new JList<String>();
		listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLivros.setModel(menuPainelLivros.gerarModeloLista());
		listaLivros.setBackground(new Color(204, 204, 204));
		painelInterativo.setViewportView(listaLivros);
		listaLivros.setFixedCellHeight(50);
		listaLivros.setFixedCellWidth(70);
		listaLivros.addListSelectionListener(this);

		//Campo onde eu posso digitar valores para serem buscados na minha lista e exibidos 
		//painel principal.
		campoBusca = new JTextField();
		campoBusca.setBounds(711, 44, 168, 23);
		contentPane.add(campoBusca);
		campoBusca.setColumns(10);

		//Painel de acesso rapido a outras janelas(Autores, Menu , Generos)
		panelIcones = new JPanel();
		panelIcones.setBackground(new Color(51, 51, 51));
		panelIcones.setBounds(0, 0, 71, 560);
		contentPane.add(panelIcones);
		panelIcones.setLayout(null);

		//Botao para chamar a janela do menu principal(Menu que aparece inicialmente).
		botaoIconeMenuPrincipal = new JButton("");
		botaoIconeMenuPrincipal
				.setIcon(new ImageIcon(PainelLivros.class.getResource("/bancoImagens/iconeMenuPrincipalMini.png")));
		botaoIconeMenuPrincipal.setBorderPainted(false);
		botaoIconeMenuPrincipal.setBackground(new Color(51, 51, 51));
		botaoIconeMenuPrincipal.setForeground(new Color(51, 51, 51));
		botaoIconeMenuPrincipal.setBounds(-13, 0, 97, 67);
		panelIcones.add(botaoIconeMenuPrincipal);
		botaoIconeMenuPrincipal.addActionListener(this);

		//Botao para chamar o painel de livro.
		//Usa o icone me PB, pois e o painel em que se esta no momento
		botaoIconeLivro = new JButton("");
		botaoIconeLivro.setIcon(new ImageIcon(PainelLivros.class.getResource("/bancoImagens/livroPB.png")));
		botaoIconeLivro.setBorderPainted(false);
		botaoIconeLivro.setBackground(new Color(51, 51, 51));
		botaoIconeLivro.setForeground(new Color(51, 51, 51));
		botaoIconeLivro.setBounds(-13, 201, 97, 67);
		panelIcones.add(botaoIconeLivro);
		botaoIconeLivro.addActionListener(this);

		//Botao para chamar o painel de genero.
		botaoIconeGenero = new JButton("");
		botaoIconeGenero.setIcon(new ImageIcon(
				PainelLivros.class.getResource("/bancoImagens/mascaras-de-teatro-png-2 (Personalizado).png")));
		botaoIconeGenero.setBorderPainted(false);
		botaoIconeGenero.setBackground(new Color(51, 51, 51));
		botaoIconeGenero.setForeground(new Color(51, 51, 51));
		botaoIconeGenero.setBounds(-13, 339, 97, 67);
		panelIcones.add(botaoIconeGenero);
		botaoIconeGenero.addActionListener(this);

		//Botao para chamar o painel de autor.
		botaoIconeAutor = new JButton("");
		botaoIconeAutor.setIcon(
				new ImageIcon(PainelLivros.class.getResource("/bancoImagens/pngwing.com (1) (Personalizado).png")));
		botaoIconeAutor.setBorderPainted(false);
		botaoIconeAutor.setBackground(new Color(51, 51, 51));
		botaoIconeAutor.setForeground(new Color(51, 51, 51));
		botaoIconeAutor.setBounds(-13, 268, 94, 60);
		panelIcones.add(botaoIconeAutor);
		botaoIconeAutor.addActionListener(this);

	}

	public JButton getBotaoIconeLivro() {
		return botaoIconeLivro;
	}

	public JButton getBotaoIconeAutor() {
		return botaoIconeAutor;
	}

	public JButton getBotaoIconeGenero() {
		return botaoIconeGenero;
	}

	public JButton getBotaoIconeMenuPrincipal() {
		return botaoIconeMenuPrincipal;
	}

	public JButton getBotaoRecarregar() {
		return botaoRecarregar;
	}

	public JScrollPane getPainelInterativo() {
		return painelInterativo;
	} 
	
	public JTextField getCampoBusca() {
		return campoBusca;
	}

	public JList<String> getListaLivros() {
		return listaLivros;
	}

	public JButton getBotaoBuscar() {
		return botaoBuscar;
	}

	public JButton getBotaoExcluir() {
		return botaoExcluir;
	}

	public JButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public JTextArea getPainelInterativoMovel() {
		return painelInterativoMovel;
	}

	/**
	 * Metodo que serve para acionar as acoes executadas referentes
	 * aos botoes e executalas, essas acoes estao definidas no back-
	 * end, que é acinado quando esse metodo e utilizado.
	 * 
	 * @param x E um ActionEvent, essa variavel indica quando ocorre um evento e usa a respectiva
	 * funcionalidade atrelada aquele evento, que esta definida no backend
	 * @see PainelLivrosControlador
	 * */
	@Override
	public void actionPerformed(ActionEvent x) {
		menuPainelLivros.botoesAtivados(x);
	}

	/**
	 * Metodo que serve para acionar as acoes executadas referentes
	 * a lista exibida no meu menu e executalas, essas acoes estao 
	 * definidas no back-end, que é acionado quando esse metodo e utilizado.
	 * 
	 * @param e E um ListSelectionEvent, que indica quando ocorre uma mudanca na lista e ativa a respectiva funcionalidade
	 * atrelada a esse event no backend
	 * @see PainelLivrosControlador
	 * */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		menuPainelLivros.informacoesLista(e);
	}
}
