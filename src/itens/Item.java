
package itens;

/**
 * Classe criada para os Itens.
 * 
 * @author itamar
 *
 */
public abstract class Item implements Comparable<Item> {

	private String nome;
	private double valor;
	private boolean emprestado;

	/**
	 * Construtor da classe.
	 * 
	 * @param nome
	 *            - String com o nome do item.
	 * @param valor
	 *            - double com o valor do item.
	 * @throws Exception
	 */
	public Item(String nome, double valor) throws Exception {

		if (valor < 0) {
			throw new Exception("Preco invalido");
		}

		this.nome = nome;
		this.valor = valor;
		this.emprestado = false;

	}

	/**
	 * Metodo get de nome.
	 * 
	 * @return - retornara uma String com o nome do item.
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo get de valor.
	 * 
	 * @return - retornara um double com o valor do item.
	 */
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Preco invalido");
		}
		this.valor = valor;
	}

	/**
	 * Metodo para saber se o item est� emprestado.
	 * 
	 * @return - retornara um boolean, false para n�o emprestado, true para
	 *         emprestado.
	 */
	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	/**
	 * Metodo toString da classe.
	 */
	@Override
	public String toString() {

		if (!emprestado) {
			return this.nome + ", R$ " + this.valor + ", Nao emprestado, ";
		} else {
			return this.nome + ", R$ " + this.valor + ", Emprestado, ";
		}
	}

	public int compareTo(Item item) {
		return this.getNome().compareTo(item.getNome());
	}

}
