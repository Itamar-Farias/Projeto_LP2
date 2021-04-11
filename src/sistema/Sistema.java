package sistema;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import emprestimo.Emprestimo;
import exceptions.EmprestimoNaoEncontrado;
import exceptions.ItemEmprestadoNoMomento;
import exceptions.ItemNaoEncontradoException;
import exceptions.UsuarioInvalidoException;
import exceptions.UsuarioJaCadastradoException;
import itens.Item;
import itens.OrdenadorDeItens;
import usuario.Usuario;

/**
 * 
 * @author itamar
 *
 */
public class Sistema {
	private Set<Usuario> usuarios;
	private ArrayList<Emprestimo> emprestimos;

	public Sistema() {
		this.usuarios = new HashSet<>();
		this.emprestimos = new ArrayList<>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) throws UsuarioJaCadastradoException {
		Usuario usuario = new Usuario(nome, telefone, email);
		if (!usuarios.add(usuario)) {
			throw new UsuarioJaCadastradoException();
		}

	}

	public String getInfoUsuario(String nome, String telefone, String atributo) throws UsuarioInvalidoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		return usuario.getInfoUsuario(atributo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws UsuarioInvalidoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		usuario.setAtualiza(atributo, valor);
	}

	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		this.usuarios.remove(usuario);
	}

	public Usuario pesquisaUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
				return usuario;
			}
		}
		throw new UsuarioInvalidoException();
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws Exception {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		usuario.cadastrarEletronico(nomeItem, preco, plataforma);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) throws Exception {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		return usuario.getInfoItem(nomeItem, atributo);

	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws Exception {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		usuario.cadastrarJogoTabuleiro(nomeItem, preco);

	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);

		usuario.adicionarPecaPerdida(nomeItem, nomePeca);

	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws Exception {
		Usuario usuario = pesquisaUsuario(nome, telefone);

		usuario.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);

	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws Exception {
		Usuario usuario = pesquisaUsuario(nome, telefone);

		usuario.cadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);

	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {

		Usuario usuario = pesquisaUsuario(nome, telefone);

		usuario.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);

	}

	public void removerItem(String nome, String telefone, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);

		usuario.removerItem(nomeItem);

	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws Exception {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		usuario.atualizarItem(nomeItem, atributo, valor);

	}

	public String listarItensOrdenadosPorNome() {
		OrdenadorDeItens ordenador = new OrdenadorDeItens();
		for (Usuario usuario : usuarios) {
			usuario.addItensToOrdenador(ordenador);
		}
		return ordenador.getItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		OrdenadorDeItens ordenador = new OrdenadorDeItens();
		for (Usuario usuario : usuarios) {
			usuario.addItensToOrdenador(ordenador);
			;
		}
		return ordenador.getItensOrdenadosPorValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem)
			throws ItemNaoEncontradoException, UsuarioInvalidoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		return usuario.pesquisarDetalhesItem(nomeItem);
	}

	public void registrarEmprestimo(String donoItem, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestomo, int periodo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, ItemEmprestadoNoMomento, ParseException {

		Usuario dono = pesquisaUsuario(donoItem, telefoneDono);
		Usuario requerente = pesquisaUsuario(nomeRequerente, telefoneRequerente);
		Item item = dono.getItem(nomeItem);
		Emprestimo emprestimo = new Emprestimo(dono, requerente, item, dataEmprestomo, periodo);
		dono.emprestarItem(emprestimo);
		requerente.pegarItemEmprestado(emprestimo.getItem());
		emprestimos.add(emprestimo);

	}


	public void devolverItem(String donoItem, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws UsuarioInvalidoException,
			ItemNaoEncontradoException, ItemEmprestadoNoMomento, EmprestimoNaoEncontrado, ParseException {

		Usuario dono = pesquisaUsuario(donoItem, telefoneDono);
		Usuario requerente = pesquisaUsuario(nomeRequerente, telefoneRequerente);
		Item item = dono.getItem(nomeItem);
		Emprestimo emprestimoProcurado = new Emprestimo(dono, requerente, item, dataEmprestimo, 7);
		Emprestimo emprestimoAchado = getEmprestimo(emprestimoProcurado);
		emprestimoAchado.setDataDevolucao(dataDevolucao);
		dono.receberItemEmprestou(emprestimoAchado);
		requerente.devolverItemEmprestado(emprestimoAchado);
		;
		emprestimos.add(emprestimoAchado);
	}

	private Emprestimo getEmprestimo(Emprestimo emprestimoProcurado) throws EmprestimoNaoEncontrado {

		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.equals(emprestimoProcurado)) {
				return emprestimo;
			}
		}

		throw new EmprestimoNaoEncontrado();
	}

	public String listaItensEmprestadosEmOrdem(String nome, String telefone) throws UsuarioInvalidoException {
		Usuario usuario = pesquisaUsuario(nome, telefone);
		return usuario.listaItensEmprestadosOrdenados();
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return getUsuario(nome, telefone).listarItensPegosEmprestados();
	}

	private Usuario getUsuario(String nome, String telefone) {
		Usuario user = null;
		
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone))
					user = usuario;
		}
		return user;
	}

	
}
