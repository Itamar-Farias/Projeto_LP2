package itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparadores.ValorComparator;
/**
 * 
 * @author itamar
 *
 */
public class OrdenadorDeItens {
	
	private List<Item> itens;
	
	public OrdenadorDeItens() {
		this.itens = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		this.itens.add(item);
	}
	
	public String getItensOrdenadosPorNome() {
		String retorno = "";
		Collections.sort(itens);
		
		for (Item item : itens) {
			retorno += item + "|";
		}
		
		return retorno;
	}
	
	public String getItensOrdenadosPorValor() {
		String retorno = "";
		Collections.sort(itens, new ValorComparator());
		
		for (Item item : itens) {
			retorno += item + "|";
		}
		
		return retorno;
	}
	
}
