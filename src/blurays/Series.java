
package blurays;

/**
 * Classe derivada de Bluray, criada para o tipo "series".
 * 
 * @author itamar
 * 
 *
 */
public class Series extends Bluray {

	private int numeroDaTemporada;
	private String generoSerie;

	/**
	 * Construtor da classe.
	 * 
	 * @param numeroTemporada
	 *            - int com o numero da temporada.
	 * @param generoSerie
	 *            - String com o genero da serie.
	 * @param duracao
	 *            - int com a duracao da serie.
	 * @param classificacao
	 *            - String com a classificacao da serie.
	 * @param nome
	 *            - String com o nome da serie.
	 * @param valor
	 *            - double com o valor do item.
	 * @throws Exception
	 */
	public Series(int numeroTemporada, String generoSerie, int duracao, String classificacao, String nome, double valor)
			throws Exception {
		super(duracao, classificacao, nome, valor);
		this.numeroDaTemporada = numeroTemporada;
		this.generoSerie = generoSerie;
	}

	/**
	 * Metodo get do numero da temporada.
	 * 
	 * @return - retornara um int com o numero da temporada.
	 */
	public int getNumeroDaTemporada() {
		return numeroDaTemporada;
	}

	public void setNumeroDaTemporada(int numeroDaTemporada) {
		this.numeroDaTemporada = numeroDaTemporada;
	}

	/**
	 * Metodo get do genero da serie.
	 * 
	 * @return - retornara uma String com o genero da serie.
	 */
	public String getGeneroSerie() {
		return generoSerie;
	}

	public void setGeneroSerie(String generoSerie) {
		this.generoSerie = generoSerie;
	}

	/**
	 * Metodo toString da classe.
	 */
	@Override
	public String toString() {
		return "SERIE: " + super.toString() + this.generoSerie + ", Temporada " + this.numeroDaTemporada;
	}

}
