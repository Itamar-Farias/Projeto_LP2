package itens;

/**
 * Classe derivada de Item, criada para o tipo de item "jogo eletronico".
 * 
 * @author itamar
 *
 */
public class JogoEletronico extends Item {

	private String plataforma;

	/**
	 * Construtor da classe.
	 * 
	 * @param nome
	 *            - String com o nome do jogo.
	 * @param valor
	 *            - double com o valor do jogo.
	 * @param plataforma
	 *            - String com o tipo de plataforma.
	 * @throws Exception
	 */
	public JogoEletronico(String nome, double valor, String plataforma) throws Exception {
		super(nome, valor);
		this.plataforma = plataforma;
	}

	/**
	 * Metodo get de plataforma.
	 * 
	 * @return - retornara uma String com a plataforma do jogo.
	 */
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Metodo toString da classe.
	 */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + super.toString() + this.plataforma;
	}

}
