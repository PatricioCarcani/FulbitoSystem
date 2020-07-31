package fulbito.app.modelos.servicios;

import java.util.List;
import fulbito.app.modelos.entidades.Usuario;

public interface IUsuarioService {

	// SELECT...
	public List<Usuario> listar();
	
	// SELECT... WHERE ID=?
	public Usuario listarPorId(Long id);
	
	// INSERT...
	public Usuario guardar(Usuario usuario);
	
	// UPDATE...
	public Usuario modificar(Usuario usuario, Long id);
	
	// DELETE...
	public void borrar(Long id);
	
}
