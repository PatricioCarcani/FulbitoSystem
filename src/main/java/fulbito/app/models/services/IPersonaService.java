package fulbito.app.models.services;

import java.util.List;

import fulbito.app.models.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();
	
	public List<Persona> insertar();
	
	public List<Persona> borrarPorId();
	
	public List<Persona> modificar();

}
