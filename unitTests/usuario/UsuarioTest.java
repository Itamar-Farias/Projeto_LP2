package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author itamar
 *
 */
public class UsuarioTest {

	private Usuario usuario;

	/**
	 * Cria um novo usuario
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario("Itamar", "(83) 9914-0464", "itamar.farias@ccc.ufcg.edu.br");

	}

	/**
	 * Teste para verificar se dois usarios são iguais
	 */
	@Test
	public void equalsTest() {
		Usuario usuario1 = new Usuario("Itamar", "(83) 9914-0464", "itamar.farias@ccc.ufcg.edu.br");
		Usuario usuario2 = new Usuario("Damião", "(83) 8884-0564", "damiao.costa@ccc.ufcg.edu.br");
		assertEquals(usuario, usuario1);
		assertFalse(usuario1.equals(usuario2));
	}

	/**
	 * Teste para verificar retornar o usuário de acordo com o atributo recebido
	 */
	@Test
	public void testGetInfoUsuario() {
		assertEquals("Itamar", usuario.getInfoUsuario("nome"));
		assertEquals("Itamar", usuario.getInfoUsuario("NoMe"));
		assertEquals("(83) 9914-0464", usuario.getInfoUsuario("telefone"));
		assertEquals("(83) 9914-0464", usuario.getInfoUsuario("TeLeFoNe"));
		assertEquals("itamar.farias@ccc.ufcg.edu.br", usuario.getInfoUsuario("email"));
		assertEquals("itamar.farias@ccc.ufcg.edu.br", usuario.getInfoUsuario("EmAiL"));

	}

	/**
	 * Teste para verificar se o usuário foi atualizado
	 */
	@Test
	public void testSetAtualiza() {
		usuario.setAtualiza("telefone", "(83) 98823-5343");
		assertEquals("(83) 98823-5343", usuario.getTelefone());
		usuario.setAtualiza("email", "itamarfarias@outlook.com");
		assertEquals("itamarfarias@outlook.com", usuario.getEmail());

	}

	/**
	 * Teste para o cadastro de item do tipo eletronico
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCadastrarEletronico() throws Exception {
		usuario.cadastrarEletronico("Super Mario", 288.99, "PS3");
		assertEquals("JOGO ELETRONICO: Super Mario, R$ 288.99, Nao emprestado, PS3",
				usuario.pesquisarDetalhesItem("Super Mario"));

	}

	/**
	 * Teste para saber se a informação do item está correta
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInfoItem() throws Exception {
		usuario.cadastrarEletronico("Super Mario", 288.99, "PS3");
		assertEquals("288.99", usuario.getInfoItem("Super Mario", "preco"));
		usuario.cadastrarEletronico("Fifa 2017", 300, "PS4");
		assertEquals("Fifa 2017", usuario.getInfoItem("Fifa 2017", "NOME"));

	}

	/**
	 * Teste para cadastrar item do tipo jogo de tabuleiro
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCadastrarJogoTabuleiro() throws Exception {
		usuario.cadastrarJogoTabuleiro("GURPS", 300);
		assertEquals("JOGO DE TABULEIRO: GURPS, R$ 300.0, Nao emprestado, COMPLETO",
				usuario.pesquisarDetalhesItem("GURPS"));
	}

	/**
	 * Teste para cadastrar filme
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCadastrarBluRayFilme() throws Exception {
		usuario.cadastrarBluRayFilme("Paixão de Cristo", 358.99, 150, "Drama", "Livre", 2017);
		assertEquals("FILME: Paixão de Cristo, R$ 358.99, Nao emprestado, 150 min, Livre, Drama, 2017",
				usuario.pesquisarDetalhesItem("Paixão de Cristo"));

	}

	/**
	 * Teste para cadastrar show
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCadastrarBluRayShow() throws Exception {
		usuario.cadastrarBluRayShow("Pink Floyd", 100, 122, 19, "Roger Waters", "Livre");
		assertEquals("SHOW: Pink Floyd, R$ 100.0, Nao emprestado, 122 min, Livre, Roger Waters, 19 faixas",
				usuario.pesquisarDetalhesItem("Pink Floyd"));

	}

	/**
	 * Teste para cadastrar serie
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCadastrarBluRaySerie() throws Exception {
		usuario.cadastrarBluRaySerie("Vikings", 500, "Melhor série do ano", 51,
				"Não recomendado para menores de dezesseis anos", "Ação", 5);
		assertEquals(
				"SERIE: Vikings, R$ 500.0, Nao emprestado, 51 min, Não recomendado para menores de dezesseis anos, Ação, Temporada 5",
				usuario.pesquisarDetalhesItem("Vikings"));
	}

	/**
	 * Teste para saber se o item foi removido
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRemoverItem() throws Exception {
		usuario.cadastrarEletronico("Super Mario", 288.99, "PS3");
		usuario.cadastrarEletronico("Fifa 2017", 300, "PS4");
		assertEquals(2, usuario.lenghtItens());

		usuario.removerItem("Super Mario");
		assertEquals(1, usuario.lenghtItens());

		usuario.cadastrarEletronico("Super Mario", 288.99, "PS3");
		usuario.cadastrarJogoTabuleiro("GURPS", 300);
		usuario.cadastrarBluRayFilme("Paixão de Cristo", 358.99, 150, "Drama", "Livre", 2017);
		usuario.cadastrarBluRayShow("Pink Floyd", 100, 122, 19, "Roger Waters", "Livre");
		usuario.cadastrarBluRaySerie("Vikings", 500, "Melhor série do ano", 51,
				"Não recomendado para menores de dezesseis anos", "Ação", 5);
		assertEquals(6, usuario.lenghtItens());

	}

	/**
	 * Teste para atualizar item de acordo com nome e atributo do mesmo
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAtualizarItem() throws Exception {
		usuario.cadastrarEletronico("Fifa 2017", 300, "PS4");
		assertEquals("Fifa 2017", usuario.getInfoItem("Fifa 2017", "NOME"));
		usuario.atualizarItem("Fifa 2017", "nome", "Soccer");
		assertEquals("Soccer", usuario.getInfoItem("Soccer", "NOME"));
		usuario.atualizarItem("Soccer", "Preco", "250");
		assertEquals("250.0", usuario.getInfoItem("Soccer", "preco"));

		usuario.cadastrarJogoTabuleiro("Damas", 150);
		assertEquals("Damas", usuario.getInfoItem("Damas", "nome"));
		usuario.atualizarItem("Damas", "nome", "Xadrez");
		assertEquals("Xadrez", usuario.getInfoItem("Xadrez", "nome"));
		usuario.atualizarItem("Xadrez", "Preco", "200");
		assertEquals("200.0", usuario.getInfoItem("Xadrez", "Preco"));

	}

	/**
	 * Teste para verificar se os detalhes do item estão de acordo com o nome do
	 * item
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPesquisarDetalhesItem() throws Exception {
		usuario.cadastrarEletronico("Fifa 2017", 300, "PS4");
		assertEquals("JOGO ELETRONICO: Fifa 2017, R$ 300.0, Nao emprestado, PS4",
				usuario.pesquisarDetalhesItem("Fifa 2017"));
		usuario.cadastrarJogoTabuleiro("Damas", 150);
		assertEquals("JOGO DE TABULEIRO: Damas, R$ 150.0, Nao emprestado, COMPLETO",
				usuario.pesquisarDetalhesItem("Damas"));
	}

	/**
	 * Teste para o toString
	 */
	@Test
	public void testToString() {
		assertEquals("Itamar, itamar.farias@ccc.ufcg.edu.br, (83) 9914-0464", usuario.toString());
	}

	/**
	 * Teste para verificar a quantidade de itens na coleção
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLenghtItens() throws Exception {
		usuario.cadastrarEletronico("Super Mario", 288.99, "PS3");
		usuario.cadastrarEletronico("Fifa 2017", 300, "PS4");
		assertEquals(2, usuario.lenghtItens());

		usuario.removerItem("Super Mario");
		assertEquals(1, usuario.lenghtItens());

		usuario.cadastrarEletronico("Super Mario", 288.99, "PS3");
		usuario.cadastrarJogoTabuleiro("GURPS", 300);
		usuario.cadastrarBluRayFilme("Paixão de Cristo", 358.99, 150, "Drama", "Livre", 2017);
		usuario.cadastrarBluRayShow("Pink Floyd", 100, 122, 19, "Roger Waters", "Livre");
		usuario.cadastrarBluRaySerie("Vikings", 500, "Melhor série do ano", 51,
				"Não recomendado para menores de dezesseis anos", "Ação", 5);
		assertEquals(6, usuario.lenghtItens());

	}

}
