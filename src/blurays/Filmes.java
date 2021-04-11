package blurays;

/**
 * Classe derivada de Bluray, criada para o tipo "filmes".
 * 
 * @author itamar
 *
 */
public class Filmes extends Bluray {

	private String genero;
	private int anoLancamento;

	/**
	 * Construtor da classe.
	 * 
	 * @param duracao
	 *            - int com a duracao do filme.
	 * @param classificacao
	 *            - String com a classificacao do filme.
	 * @param nome
	 *            - String com o nome do filme.
	 * @param valor
	 *            - double com o valor do item.
	 * @param genero
	 *            - String com o genero do filme.
	 * @param anoLancamento
	 *            - int com o ano de lancamento do filme.
	 * @throws Exception
	 */
	public Filmes(int duracao, String classificacao, String nome, double valor, String genero, int anoLancamento)
			throws Exception {
		super(duracao, classificacao, nome, valor);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	/**
	 * M�todo toString da classe.
	 */
	@Override
	public String toString() {
		return "FILME: " + super.toString() + this.genero + ", " + this.anoLancamento;
	}
}
