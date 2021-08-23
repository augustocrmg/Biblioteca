package controle;

import vista.PainelMenu;

/**
 * @author Augusto Dur�es Camargo
 * @version 5.0
 * 
 *          Classe Master do codigo, inicializa o codigo instanciando e chamando
 *          o painel de Menu
 * 
 * @see PainelMenu
 * @see MenuControlador
 */
public class Master {
	/**
	 * Metodo principal do codigo que instancia e chama a interface Menu, sendo esse
	 * o Menu do programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new PainelMenu().setVisible(true);
	}
}
