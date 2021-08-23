package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controle.MenuControlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * Classe que implementa o painel Menu e seus metodos referentes aos botoes
 * de acesso aos menus de "Autor","Livro" e "Genero"
 * 
 * Herda a classe Jframe e implementa a interface ActionListener para criar e deixar o
 * painel e suas usabilidades funcionais
 * 
 * @see JFrame
 * @see ActionListener
 * */
public class PainelMenu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private MenuControlador controlador;
	private JPanel contentPane;
	private JButton botaoLivros;
	private JButton botaoAutor;
	private JButton botaoGeneroLiterario;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Construtor de painel que gera a tela de Livros e tambem contem a definicao de suas
	 * caracteristicas graficas 
	 * 
	 * Os metodos atrelados aos botoes e outras funcoes do painel estao contidas no backend
	 * 
	 * @see MenuControlador
	 * */
	public PainelMenu() {
		//Seleciono o icone da minha janela do programa.
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/bancoImagens/livro_redondo.png")));
		
		//Instancio a classe responsavel pelo backend do programa.
		controlador = new MenuControlador(this);

		//Defino aqui as caracteristicas da janela e os paineis que ela contem no fundo.
		setBackground(new Color(153, 153, 153));
		setForeground(new Color(153, 153, 153));
		setTitle("Biblioteca Virtual");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 587);
		setLocationRelativeTo(null);
		validate();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		//Painel de fundo contendo todos os outros elementos da janela.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 266, 570);
		contentPane.add(panel);

		//Defino aqui o botao Livros , que se conecta com o backend e chama a janela Livros.
		botaoLivros = new JButton("Livros");
		botaoLivros.setBounds(0, 170, 266, 87);
		botaoLivros.setFont(new Font("Tahoma", Font.BOLD, 20));
		botaoLivros.setHorizontalAlignment(SwingConstants.LEADING);
		botaoLivros.setForeground(new Color(255, 102, 0));
		botaoLivros.setOpaque(true);
		botaoLivros.setBorderPainted(false);
		panel.setLayout(null);
		botaoLivros.setBackground(new Color(51, 51, 51));
		panel.add(botaoLivros);
		botaoLivros.addActionListener(this);

		//Defino aqui o botao Livros , que se conecta com o backend e chama a janela Autores.
		botaoAutor = new JButton("Autor");
		botaoAutor.setFont(new Font("Tahoma", Font.BOLD, 20));
		botaoAutor.setHorizontalAlignment(SwingConstants.LEADING);
		botaoAutor.setForeground(new Color(255, 153, 0));
		botaoAutor.setOpaque(true);
		botaoAutor.setBorderPainted(false);
		botaoAutor.setBackground(new Color(51, 51, 51));
		botaoAutor.setBounds(0, 262, 266, 87);
		panel.add(botaoAutor);
		botaoAutor.addActionListener(this);

		//Defino aqui o botao Livros , que se conecta com o backend e chama a janela Genero Literario.
		botaoGeneroLiterario = new JButton("Genero literario");
		botaoGeneroLiterario.setBackground(new Color(51, 51, 51));
		botaoGeneroLiterario.setBounds(0, 354, 266, 87);
		botaoGeneroLiterario.setFont(new Font("Tahoma", Font.BOLD, 20));
		botaoGeneroLiterario.setHorizontalAlignment(SwingConstants.LEADING);
		botaoGeneroLiterario.setForeground(new Color(255, 204, 0));
		botaoGeneroLiterario.setOpaque(true);
		botaoGeneroLiterario.setBorderPainted(false);
		panel.add(botaoGeneroLiterario);

		//Define o icone do livro presente logo no comeco do menu.
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(PainelMenu.class.getResource("/bancoImagens/livro_redondo (Personalizado).png")));
		lblNewLabel.setBounds(51, 11, 179, 167);
		panel.add(lblNewLabel);

		//Exibe no canto inferior esquerdo do meu programa a sua versao.
		lblNewLabel_2 = new JLabel("V 5.0.0");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(0, 531, 47, 14);
		panel.add(lblNewLabel_2);

		//Define a a imagem de fundo presente no programa.
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(PainelMenu.class.getResource("/bancoImagens/bibliotecaEscada (Personalizado).jpg")));
		lblNewLabel_1.setBounds(265, -45, 851, 645);
		contentPane.add(lblNewLabel_1);
		setUndecorated(false);
		setLocationRelativeTo(null);
		botaoGeneroLiterario.addActionListener(this);

		controlador.verificaBotoes();
	}

	public JButton getBotaoLivros() {
		return botaoLivros;
	}

	public JButton getBotaoAutor() {
		return botaoAutor;
	}

	public JButton getBotaoGeneroLiterario() {
		return botaoGeneroLiterario;
	}

	/**
	 * Metodo que serve para acionar as acoes executadas referentes
	 * aos botoes e executalas, essas acoes estao definidas no back-
	 * end, que é acinado quando esse metodo e utilizado.
	 * 
	 * @param e E um ActionEvent, essa variavel indica quando ocorre um evento e usa a respectiva
	 * funcionalidade atrelada aquele evento, que esta definida no backend
	 * @see MenuControlador
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.acaoPerformada(e);
	}
}
