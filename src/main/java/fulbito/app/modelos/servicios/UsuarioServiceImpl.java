package fulbito.app.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fulbito.app.modelos.entidades.Usuario;
import fulbito.app.modelos.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioDao;
	
	@Override
	@Transactional(readOnly=true) // puede omitirse, porque ya la hereda
	public List<Usuario> listar() {
		
		return (List<Usuario>) usuarioDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true) // puede omitirse, porque ya la hereda
	public Usuario listarPorId(Long id) {
		
		//sino lo encuentra devuelve null
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public Usuario modificar(Usuario usuario, Long id) {
		
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		
		usuarioDao.deleteById(id);
		
	}

}
