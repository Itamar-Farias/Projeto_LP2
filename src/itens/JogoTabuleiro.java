package itens;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe derivada de Item, criada para o tipo de item "jogo de tabuleiro".
 * 
 * @author itamar
 *
 */
public class JogoTabuleiro extends Item {

	private List<String> pecasPerdidas;

	/**
	 * Construtor da classe.
	 * 
	 * @param nome
	 *            - String com o nome do jogo.
	 * @param valor
	 *            - double com o valor do jogo.
	 * @throws Exception
	 */
	public JogoTabuleiro(String nome, double valor) throws Exception {
		super(nome, valor);
		this.pecasPerdidas = new ArrayList<>();
	}

	/**
	 * Metodo para adicionar peca perdida.
	 * 
	 * @param nomePeca
	 *            - retornara o ArrayList com as pecas adicionadas.
	 */
	public void adicionarPecaPerdida(String nomePeca) {
		this.pecasPerdidas.add(nomePeca);

	}

	/**
	 * Metodo toString da classe.
	 */
	@Override
	public String toString() {
		if (this.pecasPerdidas.size() > 0) {
			return "JOGO DE TABULEIRO: " + super.toString() + "COM PECAS PERDIDAS";
		} else {
			return "JOGO DE TABULEIRO: " + super.toString() + "COMPLETO";
		}
	}

}
