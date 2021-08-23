package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controle.PopupAdicionarLivroControlador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
/**
 * Classe que implementa o painel de adição de livros 
 * 
 * Herda a classe Jframe e implementa as interface ActionListener
 * para criar e deixar o painel e suas usabilidades funcionais
 * 
 * @see JFrame
 * @see ActionListener
 * */
public class PopupAdicionarLivro extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private PopupAdicionarLivroControlador controlador;
	private final JPanel contentPanel = new JPanel();
	private JTextField campoTituloLivro;
	private JTextField campoAutorLivro;
	private JTextField campoGeneroLivro;
	private JButton botaoAdicionar;
	private JButton botaoCancelar;
	private JLabel etiquetaTituloLivro;
	private JLabel etiquetaNomeAutor;
	private JLabel etiquetaGeneroLiterario;
	private JLabel lblNewLabel_1;
	
	/**
	 * Construtor de painel que gera a tela de adicao de livros e tambem contem a definicao de suas
	 * caracteristicas graficas 
	 * 
	 * Os metodos atrelados aos botoes e outras funcoes do painel estao contidas no backend
	 * 
	 * @see PopupAdicionarLivroControlador
	 * */
	public PopupAdicionarLivro() {
		//Seleciono o icone da minha janela do programa.
		setIconImage(Toolkit.getDefaultToolkit().getImage(PopupAdicionarLivro.class.getResource("/bancoImagens/livro_redondo.png")));
		
		//Instancio a classe responsavel pelo backend do programa.
		controlador = new PopupAdicionarLivroControlador(this);
		
		//Defino aqui as caracteristicas da janela e os paineis que ela contem no fundo.
		setBackground(new Color(102, 102, 102));
		setTitle("Biblioteca Virtual");
		setBounds(100, 100, 606, 433);
		setLocationRelativeTo(null);
		validate();
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 102, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setResizable(false);
		contentPanel.setLayout(null);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o botao Adicionar.
		botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.setBackground(new Color(204, 204, 204));
		botaoAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoAdicionar.setBounds(474, 358, 107, 23);
		botaoAdicionar.setBorderPainted(false);
		contentPanel.add(botaoAdicionar);
		botaoAdicionar.addActionListener(this);

		//Defino aqui as caracteristicas, atributos e ligo com o backend o botao Cancelar.
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBackground(new Color(204, 204, 204));
		botaoCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoCancelar.setBounds(340, 358, 107, 23);
		botaoCancelar.setBorderPainted(false);
		contentPanel.add(botaoCancelar);
		botaoCancelar.addActionListener(this);

		//Etiqueta que sinaliza que o campo a frente e o de adicao do nome do livro
		etiquetaTituloLivro = new JLabel("Titulo do Livro : ");
		etiquetaTituloLivro.setForeground(new Color(255, 204, 51));
		etiquetaTituloLivro.setBounds(58, 85, 161, 42);
		etiquetaTituloLivro.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(etiquetaTituloLivro);

		//Etiqueta que sinaliza que o campo a frente e o de adicao do nome do autor
		etiquetaNomeAutor = new JLabel("Nome do Autor : ");
		etiquetaNomeAutor.setForeground(new Color(255, 204, 51));
		etiquetaNomeAutor.setBounds(58, 148, 161, 42);
		etiquetaNomeAutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(etiquetaNomeAutor);

		//Etiqueta que sinaliza que o campo a frente e o de adicao do genero literario
		etiquetaGeneroLiterario = new JLabel("Genero Literario : ");
		etiquetaGeneroLiterario.setForeground(new Color(255, 204, 51));
		etiquetaGeneroLiterario.setBounds(58, 219, 161, 42);
		etiquetaGeneroLiterario.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(etiquetaGeneroLiterario);

		//Campo disponibilizado para a insercao do nome do livro
		campoTituloLivro = new JTextField();
		campoTituloLivro.setToolTipText("");
		campoTituloLivro.setBackground(new Color(255, 255, 255));
		campoTituloLivro.setBounds(229, 96, 186, 20);
		contentPanel.add(campoTituloLivro);
		campoTituloLivro.setColumns(10);
		
		//Campo disponibilizado para a insercao do nome do autor
		campoAutorLivro = new JTextField();
		campoAutorLivro.setBackground(new Color(255, 255, 255));
		campoAutorLivro.setBounds(229, 161, 186, 20);
		contentPanel.add(campoAutorLivro);
		campoAutorLivro.setColumns(10);

		//Campo disponibilizado para a insercao do nome do genero
		campoGeneroLivro = new JTextField();
		campoGeneroLivro.setBackground(new Color(255, 255, 255));
		campoGeneroLivro.setBounds(229, 232, 186, 20);
		contentPanel.add(campoGeneroLivro);
		campoGeneroLivro.setColumns(10);
		
		//Etiqueta exibida na parte superior da janela, evidenciando que e a janela
		//de cadastro
		JLabel lblNewLabel = new JLabel("Cadastrar livro");
		lblNewLabel.setBounds(229, 11, 255, 57);
		lblNewLabel.setForeground(new Color(255, 204, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPanel.add(lblNewLabel);
		
		
		//Define a imagem da biblioteca ao fundo do trabalho
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PopupAdicionarLivro.class.getResource("/bancoImagens/fundoAdicao.png")));
		lblNewLabel_1.setBounds(0, 0, 602, 406);
		contentPanel.add(lblNewLabel_1);
	}

	public JLabel getEtiquetaTituloLivro() {
		return etiquetaTituloLivro;
	}

	public JLabel getEtiquetaNomeAutor() {
		return etiquetaNomeAutor;
	}

	public JLabel getEtiquetaGeneroLiterario() {
		return etiquetaGeneroLiterario;
	}

	public JTextField getCampoTituloLivro() {
		return campoTituloLivro;
	}

	public JTextField getCampoAutorLivro() {
		return campoAutorLivro;
	}

	public JTextField getCampoGeneroLivro() {
		return campoGeneroLivro;
	}

	public JButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public JButton getBotaoCancelar() {
		return botaoCancelar;
	}
	
	/**
	 * Metodo que serve para acionar as acoes executadas referentes
	 * aos botoes e executalas, essas acoes estao definidas no back-
	 * end, que é acinado quando esse metodo e utilizado.
	 * 
	 * @param e E um ActionEvent, essa variavel indica quando ocorre um evento e usa a respectiva
	 * funcionalidade atrelada aquele evento, que esta definida no backend
	 * @see PopupAdicionarLivroControlador
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.acaoPerformada(e);
	}
}
