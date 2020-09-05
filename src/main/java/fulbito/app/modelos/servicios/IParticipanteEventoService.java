package fulbito.app.modelos.servicios;

import java.util.List;

import fulbito.app.modelos.entidades.ParticipanteEvento;

public interface IParticipanteEventoService {

	// SELECT...
	public List<ParticipanteEvento> listar();
	
	// SELECT... WHERE ID=?
	public ParticipanteEvento listarPorId(Long id);
	
	// INSERT...
	public ParticipanteEvento guardar(ParticipanteEvento participanteEvento);
	
	// UPDATE...
	public ParticipanteEvento modificar(ParticipanteEvento persona, Long id);
	
	// DELETE...
	public void borrar(Long id);

}
