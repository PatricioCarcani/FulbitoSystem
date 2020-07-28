package fulbito.app.modelos.servicios;

import java.util.List;

import fulbito.app.modelos.entidades.Persona;

public interface IPersonaService {

	// SELECT...
	public List<Persona> listar();
	
	// SELECT... WHERE ID=?
	public Persona listarPorId(Long id);
	
	// INSERT...
	public Persona guardar(Persona persona);
	
	// UPDATE...
	public Persona modificar(Persona persona, Long id);
	
	// DELETE...
	public void borrar(Long id);

}
