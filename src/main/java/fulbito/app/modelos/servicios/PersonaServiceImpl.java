package fulbito.app.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fulbito.app.modelos.dao.IPersonaDao;
import fulbito.app.modelos.entidades.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly=true) // puede omitirse, porque ya la hereda
	public List<Persona> listar() {

		return (List<Persona>) personaDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true) // puede omitirse, porque ya la hereda
	public Persona listarPorId(Long id) {
		
		//sino lo encuentra devuelve null
		return personaDao.findById(id).orElse(null);
				
	}

	@Override
	@Transactional
	public Persona guardar(Persona persona) {

		return personaDao.save(persona);
		
	}
	
	@Override
	@Transactional
	public Persona modificar(Persona persona, Long id) {
		
		return personaDao.save(persona);
		
	}	

	@Override
	@Transactional
	public void borrar(Long id) {
		
		personaDao.deleteById(id);
	}



}
