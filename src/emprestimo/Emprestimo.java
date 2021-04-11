package emprestimo;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import itens.Item;
import usuario.Usuario;

/**
 * Classe criada para a funcao de emprestimo dos itens.
 * 
 * @author ailton
 *
 */
public class Emprestimo {
	private Usuario donoItem, requerenteItem;
	private Item item;
	private LocalDate dataEmprestimo, dataDevolucao;
	private boolean isDevolvido;

	private final String ANDAMENTO_EMPRESTIMO = "Emprestimo em andamento";
	private int periodo;

	/**
	 * Construtor da classe.
	 * 
	 * @param nomeItem
	 *            - String com o nome do item.
	 * @param dataEmprestimo
	 *            - String com a data de emprestimo.
	 * @param devolucao
	 *            - String com a data de devolucao.
	 * @throws ParseException 
	 */
	public Emprestimo(Usuario donoItem, Usuario requerenteItem, Item item, String dataEmprestimo, int periodo) throws ParseException {
		this.donoItem = donoItem;
		this.requerenteItem = requerenteItem;
		this.item = item;
		this.dataEmprestimo = convertDate(dataEmprestimo);
		this.periodo = periodo;
		this.dataDevolucao = devolucao(dataEmprestimo, periodo);
		this.isDevolvido = false;
	}


	private LocalDate convertDate(String data) throws ParseException{
		String[] dais = data.split("/");
		return LocalDate.of(Integer.parseInt(dais[2]), Integer.parseInt(dais[1]), Integer.parseInt(dais[0]));
	}

	private LocalDate devolucao(String data, int periodo) throws ParseException {
		String[] dais = data.split("/");
		return LocalDate.of(Integer.parseInt(dais[2]), Integer.parseInt(dais[1]), Integer.parseInt(dais[0])).plusDays(periodo);
	}
	
	/**
	 * Metodo get de data.
	 * 
	 * @return - retornara uma String com a data do emprestimo.
	 */
	public String getDataEmprestimo() {
		return dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setEmprestimo(String emprestimo) throws ParseException {
		this.dataEmprestimo = convertDate(emprestimo);
	}

	/**
	 * Metodo get de devolucao.
	 * 
	 * @return - retornara uma String com a data de devolucao do item.
	 */
	public String getDataDevolucao() {
		return dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setDataDevolucao(String devolucao) throws ParseException {
		this.dataDevolucao = convertDate(devolucao);
	}

	public Usuario getDonoItem() {
		return donoItem;
	}

	public void setDonoItem(Usuario donoItem) {
		this.donoItem = donoItem;
	}

	public Usuario getRequerenteItem() {
		return requerenteItem;
	}

	public void setRequerenteItem(Usuario requerenteItem) {
		this.requerenteItem = requerenteItem;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public void setDataEmprestimo(String dataEmprestimo) throws ParseException {
		this.dataEmprestimo = convertDate(dataEmprestimo);
	}
	
	public void setIsDevolvido(){
		this.isDevolvido = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((donoItem == null) ? 0 : donoItem.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((requerenteItem == null) ? 0 : requerenteItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (donoItem == null) {
			if (other.donoItem != null)
				return false;
		} else if (!donoItem.equals(other.donoItem))
			return false;
		if (item.getNome() == null) {
			if (other.item.getNome() != null)
				return false;
		} else if (!item.getNome().equals(other.item.getNome()))
			return false;
		if (requerenteItem == null) {
			if (other.requerenteItem != null)
				return false;
		} else if (!requerenteItem.equals(other.requerenteItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String devolucao = ANDAMENTO_EMPRESTIMO;
		if (isDevolvido)
			devolucao = getDataDevolucao();
		
		return "EMPRESTIMO - De: " + donoItem.getNome() + ", Para: " + requerenteItem.getNome() + ", " + item.getNome() + ", " + getDataEmprestimo() + ", "
				+ periodo + " dias, ENTREGA: " + devolucao + "|";
	}

}
