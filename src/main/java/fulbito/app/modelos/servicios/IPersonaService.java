package fulbito.app.modelos.servicios;

import java.util.List;

import fulbito.app.modelos.entidades.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();
	
	public List<Persona> insertar();
	
	public List<Persona> borrarPorId();
	
	public List<Persona> modificar();

}
