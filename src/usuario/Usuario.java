package usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import blurays.Filmes;
import blurays.Series;
import blurays.Shows;
import comparadores.ComparatorEmprestimo;
import emprestimo.Emprestimo;
import exceptions.ItemEmprestadoNoMomento;
import exceptions.ItemNaoEncontradoException;
import exceptions.UsuarioInvalidoException;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;
import itens.OrdenadorDeItens;

/**
 * Classe criada para usuario.
 * 
 * @author itamar
 *
 */
public class Usuario {

	private String nome, telefone, email;
	private Set<Item> itens;
	private ArrayList<Emprestimo> historicoEmprestimos;
	private Set<Item> itensDadosEmprestados;
	private Set<Item> itensPegosEmprestados;

	/**
	 * Construtor da classe.
	 * 
	 * @param nome
	 *            - String com o nome do usuario.
	 * @param telefone
	 *            - String com o telefone do usuario.
	 * @param email
	 *            - String com o email do usuario.
	 */
	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new HashSet<>();
		this.historicoEmprestimos = new ArrayList<>();
		this.itensDadosEmprestados = new HashSet<>();
		this.itensPegosEmprestados = new HashSet<>();
	}

	/**
	 * Metodo hashCode da classe.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Metodo equals da classe.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	/**
	 * Retorna um informção de usuário de acordo com o atributo
	 * 
	 * @param atributo
	 * @return
	 */
	public String getInfoUsuario(String atributo) {
		final String NOME = "nome";
		final String TELEFONE = "telefone";
		final String EMAIL = "email";
		String informacao = "";

		if (atributo.equalsIgnoreCase(NOME)) {
			informacao = getNome();
		} else if (atributo.equalsIgnoreCase(TELEFONE)) {
			informacao = getTelefone();
		} else if (atributo.equalsIgnoreCase(EMAIL)) {
			informacao = getEmail();
		}
		return informacao;
	}

	/**
	 * Atualiza a usuário de acordo com o atributo
	 * 
	 * @param atributo
	 * @param valor
	 */
	public void setAtualiza(String atributo, String valor) {
		final String TELEFONE = "telefone";
		final String EMAIL = "email";

		if (atributo.equalsIgnoreCase(TELEFONE)) {
			setTelefone(valor);
		} else if (atributo.equalsIgnoreCase(EMAIL)) {
			setEmail(valor);
		}

	}

	/**
	 * Retorna nome do usuário
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera nome do usuário
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna email do usuário
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera email do usuário
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna telefone do usuário
	 * 
	 * @return
	 */
	public String getTelefone() {

		return telefone;
	}

	/**
	 * Altera telefone do usuário
	 * 
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Representação textual do usuário
	 */
	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;

	}

	/**
	 * Realiza cadastro dos itens do tipo eletrônico. Adicionando-o na coleção de
	 * itens
	 * 
	 * @param nomeItem
	 * @param preco
	 * @param plataforma
	 * @throws Exception
	 */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) throws Exception {
		Item item = new JogoEletronico(nomeItem, preco, plataforma);
		itens.add(item);
	}

	/**
	 * Procura um item pelo nome no coleção de itens
	 * 
	 * @param nome
	 * @return
	 * @throws ItemNaoEncontradoException
	 */
	public Item getItem(String nome) throws ItemNaoEncontradoException {
		for (Item item : itens) {
			if (item.getNome().equals(nome)) {
				return item;
			}
		}
		throw new ItemNaoEncontradoException();
	}

	/**
	 * Retorna a informação do item de acordo com atributo
	 * 
	 * @param nomeItem
	 * @param atributo
	 * @return
	 * @throws Exception
	 */
	public String getInfoItem(String nomeItem, String atributo) throws Exception {
		Item item = getItem(nomeItem);
		if (item == null) {
			throw new ItemNaoEncontradoException();
		}

		atributo = atributo.toUpperCase();

		switch (atributo) {
		case "PRECO":
			return Double.toString(item.getValor());
		case "NOME":
			return item.getNome();
		}
		throw new Exception("Atributo invalido");
	}

	/**
	 * Cadastra jogo de tabuleiro
	 * 
	 * @param nomeItem
	 * @param preco
	 * @throws Exception
	 */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) throws Exception {
		Item item = new JogoTabuleiro(nomeItem, preco);
		itens.add(item);
	}

	/**
	 * Adiciona peça perdida
	 * 
	 * @param nomeItem
	 * @param nomePeca
	 * @throws ItemNaoEncontradoException
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) throws ItemNaoEncontradoException {
		Item item = getItem(nomeItem);
		if (item instanceof JogoTabuleiro) {
			((JogoTabuleiro) item).adicionarPecaPerdida(nomePeca);
		}

	}

	/**
	 * Cadastra filme. Adicionando-o a coleção de itens
	 * 
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param genero
	 * @param classificacao
	 * @param anoLancamento
	 * @throws Exception
	 */
	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) throws Exception {
		Item item = new Filmes(duracao, classificacao, nomeItem, preco, genero, anoLancamento);
		itens.add(item);

	}

	/**
	 * Cadastra show. Adicionando-o na coleção de itens
	 * 
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param numeroFaixas
	 * @param artista
	 * @param classificacao
	 * @throws Exception
	 */
	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) throws Exception {
		Item item = new Shows(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		itens.add(item);
	}

	/**
	 * Cadastra serie. Adicionando-o a coleção de itens
	 * 
	 * @param nomeItem
	 * @param preco
	 * @param descricao
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param temporada
	 * @throws Exception
	 */
	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) throws Exception {
		Item item = new Series(temporada, genero, duracao, classificacao, nomeItem, preco);
		itens.add(item);

	}

	/**
	 * Remove item. Retirand-o da coleção de itens
	 * 
	 * @param nomeItem
	 * @throws ItemNaoEncontradoException
	 */
	public void removerItem(String nomeItem) throws ItemNaoEncontradoException {
		Item itemARemover = null;
		for (Item item : itens) {
			if (item.getNome().equals(nomeItem)) {
				itemARemover = item;
			}
		}

		if (itemARemover == null) {
			throw new ItemNaoEncontradoException();
		}

		itens.remove(itemARemover);
	}

	/**
	 * Atualiza item de acordo com o seu nome
	 * 
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 * @throws Exception
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) throws Exception {
		Item item = getItem(nomeItem);

		atributo = atributo.toUpperCase();

		switch (atributo) {
		case "PRECO":
			item.setValor(Double.parseDouble(valor));
			break;
		case "NOME":
			item.setNome(valor);
			break;
		default:
			throw new Exception("Atributo invalido");
		}

	}

	public void adicionarBluray(String nomeBlurayTemporada, int duracao) throws ItemNaoEncontradoException {
		String bluray = pesquisarDetalhesItem(nomeBlurayTemporada);

	}

	/**
	 * Ordena itens
	 * 
	 * @param ordenador
	 */
	public void addItensToOrdenador(OrdenadorDeItens ordenador) {
		for (Item item : itens) {
			ordenador.addItem(item);
		}
	}

	/**
	 * Retona detalhes do item de acordo com o nome pesquisado
	 * 
	 * @param nomeItem
	 * @return
	 * @throws ItemNaoEncontradoException
	 */
	public String pesquisarDetalhesItem(String nomeItem) throws ItemNaoEncontradoException {
		Item item = getItem(nomeItem);
		return item.toString();
	}

	/**
	 * Retorna o tamanho da coleção
	 * 
	 * @return
	 */
	public int lenghtItens() {
		return itens.size();
	}

	public void emprestarItem(Emprestimo emprestimo) throws ItemEmprestadoNoMomento {
		if (this.itensDadosEmprestados.add(emprestimo.getItem())) {
			this.historicoEmprestimos.add(emprestimo);
		} else {
			throw new ItemEmprestadoNoMomento();
		}
	}

	public void receberItemEmprestou(Emprestimo emprestimo) {
		emprestimo.setIsDevolvido();
	}

	public void pegarItemEmprestado(Item item) {
		this.itensPegosEmprestados.add(item);
	}

	public void devolverItemEmprestado(Emprestimo emprestimo) {
		this.historicoEmprestimos.add(emprestimo);
	}

	public String listaItensEmprestadosOrdenados() {
		List<Emprestimo> listEmprestimo = new ArrayList<>();
		listEmprestimo.addAll(historicoEmprestimos);
		Collections.sort(listEmprestimo, new ComparatorEmprestimo());
		return lista(listEmprestimo);
	}

	private String lista(List<Emprestimo> listEmprestimo) {
		String lista = "Emprestimos: ";
		boolean guarda = true;

		for (Emprestimo emprestimo : listEmprestimo) {
			if (emprestimo.getDonoItem().getNome().equals(this.getNome())) {
				lista += emprestimo.toString();
				guarda = false;
			}
		}

		if (guarda)
			lista = "Nenhum item emprestado";
		return lista;
	}

	public String listarItensPegosEmprestados() {
		String list = "Emprestimos pegos: ";
		if (itensPegosEmprestados.size() > 0) {
			for (Item item : itensPegosEmprestados) {
				list += getEmprestimo(item);
			}
		}else
			list = "Nenhum item pego emprestado";
		return list;
	}

	private String getEmprestimo(Item item) {
		String empr = null;
		for (Emprestimo emprestimo : historicoEmprestimos) {
			if (emprestimo.getItem().equals(item))
				empr = emprestimo.toString();
		}
		return empr;
	}

}
