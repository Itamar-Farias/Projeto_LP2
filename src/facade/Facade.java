package facade;

import java.text.ParseException;

import exceptions.EmprestimoNaoEncontrado;
import exceptions.ItemEmprestadoNoMomento;
import exceptions.ItemNaoEncontradoException;
import exceptions.UsuarioInvalidoException;
import exceptions.UsuarioJaCadastradoException;
import sistema.Sistema;
import usuario.Usuario;
/**
 * 
 * @author itamar
 *
 */
public class Facade {

	private Sistema sistema;

	public Facade() {
		sistema = new Sistema();
	}

	public void iniciarSistema() {

	}

	public void cadastrarUsuario(String nome, String telefone, String email) throws UsuarioJaCadastradoException {
		this.sistema.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) throws UsuarioInvalidoException {
		return this.sistema.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		this.sistema.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws UsuarioInvalidoException {
		this.sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws Exception {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws Exception {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) throws Exception {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws Exception {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws Exception {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
	}

	public void removerItem(String nome, String telefone, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		sistema.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws Exception {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem)
			throws ItemNaoEncontradoException, UsuarioInvalidoException {
		return sistema.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	public void registrarEmprestimo(String donoItem, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, ItemEmprestadoNoMomento, ParseException {
		sistema.registrarEmprestimo(donoItem, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
	}
	
	public void devolverItem(String donoItem, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) throws UsuarioInvalidoException, ItemNaoEncontradoException, ItemEmprestadoNoMomento, EmprestimoNaoEncontrado, ParseException {
		sistema.devolverItem(donoItem, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) throws UsuarioInvalidoException {
		return sistema.listaItensEmprestadosEmOrdem(nome, telefone);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return sistema.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	public void fecharSistema() {

	}

}
