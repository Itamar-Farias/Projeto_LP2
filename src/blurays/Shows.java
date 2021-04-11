package blurays;

/**
 * Classe derivada de Bluray, criada para o tipo "shows".
 * 
 * @author itamar
 *
 */
public class Shows extends Bluray {

	private int numeroFaixas;
	private String artista;

	/**
	 * Construtor da classe.
	 * 
	 * @param nome
	 *            - String com o nome do show.
	 * @param valor
	 *            - int com o valor do item.
	 * @param duracao
	 *            - int com a duracao do show.
	 * @param numeroFaixas
	 *            - int com o numero de faixas.
	 * @param artista
	 *            - String com o nome do artista.
	 * @param classificacao
	 *            - String com a classificacao do show.
	 * @throws Exception
	 */
	public Shows(String nome, double valor, int duracao, int numeroFaixas, String artista, String classificacao)
			throws Exception {
		super(duracao, classificacao, nome, valor);
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
	}

	/**
	 * Metodo get do numero de faixas.
	 * 
	 * @return - retornara um int com o numero de faixas.
	 */
	public int getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(int numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}

	/**
	 * Metodo get de artista.
	 * 
	 * @return - retornara uma String com o nome do artista.
	 */
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Metodo toString da classe.
	 */
	@Override
	public String toString() {
		return "SHOW: " + super.toString() + this.artista + ", " + this.numeroFaixas + " faixas";
	}

}
