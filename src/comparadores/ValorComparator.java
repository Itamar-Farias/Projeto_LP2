package comparadores;

import java.util.Comparator;

import itens.Item;
/**
 * 
 * @author itamar
 *
 */
public class ValorComparator implements Comparator<Item>{

	@Override
	public int compare(Item arg0, Item arg1) {
		return Double.compare(arg0.getValor(), arg1.getValor());
	}
	
}
