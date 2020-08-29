package fulbito.app.modelos.servicios;

import java.util.List;

import fulbito.app.modelos.entidades.Cancha;

public interface ICanchaService {
	
	public List<Cancha> listar();
	
	public Cancha listarPorId(Long id);
	
	public Cancha guardar(Cancha cancha);
	
	//public Cancha modificar(Cancha cancha, Long id);
	
	//public void borrar(Long id);
	
	
}