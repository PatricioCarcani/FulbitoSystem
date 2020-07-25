package fulbito.app.modelos.servicios;

import java.util.List;

import fulbito.app.modelos.entidades.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();
	
	public Persona listarPorId(Long id);
	
	public Persona guardar(Persona persona);
	
	public Persona modificar(Persona persona, Long id);
	
	public void borrar(Long id);

}
