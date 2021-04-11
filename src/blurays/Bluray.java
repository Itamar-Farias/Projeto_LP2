package blurays;

import itens.Item;

/**
 * Classe derivada de Item, criada para o tipo de item "bluray".
 * 
 * @author itamar
 *
 */
public abstract class Bluray extends Item {

	private int duracao;
	private String classificacao;

	/**
	 * Construtor da classe.
	 * 
	 * @param duracao
	 *            - int com a duracao do bluray.
	 * @param classificacao
	 *            - String com a classificacao do bluray.
	 * @param nome
	 *            - String com o nome do bluray.
	 * @param valor
	 *            - double com o valor do bluray.
	 * @throws Exception
	 */
	public Bluray(int duracao, String classificacao, String nome, double valor) throws Exception {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao;
	}

	/**
	 * Metodo get de duracao.
	 * 
	 * @return retornara um int com o valor da duracao do bluray.
	 */
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	/**
	 * Metodo get de classificacao.
	 * 
	 * @return retornara uma String com a classificacao do bluray.
	 */
	public String getClassificao() {
		return classificacao;
	}

	public void setClassificao(String classificacao) {
		this.classificacao = classificacao;
	}

	/**
	 * Metodo toString da classe.
	 */
	@Override
	public String toString() {
		return super.toString() + this.duracao + " min, " + this.classificacao + ", ";
	}

}
