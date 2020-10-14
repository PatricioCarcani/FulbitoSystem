package fulbito.app.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fulbito.app.modelos.entidades.ParticipanteEvento;
import fulbito.app.modelos.entidades.Usuario;
import fulbito.app.modelos.repository.ParticipanteEventoRepository;
import fulbito.app.modelos.repository.UsuarioRepository;

@Service
public class ParticipanteEventoServiceImpl implements ParticipanteEventoService {

	@Autowired
	private ParticipanteEventoRepository participanteEventoDao;
	
	@Override
	@Transactional(readOnly=true) // puede omitirse, porque ya la hereda
	public List<ParticipanteEvento> listar() {
		
		return (List<ParticipanteEvento>) participanteEventoDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true) // puede omitirse, porque ya la hereda
	public ParticipanteEvento listarPorId(Long id) {
		
		//sino lo encuentra devuelve null
		return participanteEventoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ParticipanteEvento guardar(ParticipanteEvento participanteEvento) {
		
		return participanteEventoDao.save(participanteEvento);
	}

	@Override
	@Transactional
	public ParticipanteEvento modificar(ParticipanteEvento participanteEvento, Long id) {
		
		return participanteEventoDao.save(participanteEvento);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		
	    participanteEventoDao.deleteById(id);
		
	}

}
