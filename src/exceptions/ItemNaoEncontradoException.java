package exceptions;
/**
 * 
 * @author itamar
 *
 */
public class ItemNaoEncontradoException extends Exception {
	public ItemNaoEncontradoException() {
		super("Item nao encontrado");
	}
}
