package comparadores;

import java.util.Comparator;

import emprestimo.Emprestimo;

public class ComparatorEmprestimo implements Comparator<Emprestimo>{

	@Override
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getRequerenteItem().getNome().compareTo(o2.getRequerenteItem().getNome());
	}

}
