package exceptions;

public class UsuarioJaCadastradoException extends Exception{
	/**
	 * @author itamar
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioJaCadastradoException() {
		super("Usuario ja cadastrado");
	}
}
