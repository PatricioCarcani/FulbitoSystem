package fulbito.app.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fulbito.app.modelos.dao.ICanchaDao;
import fulbito.app.modelos.entidades.Cancha;

@Service
public class CanchaServiceImpl implements ICanchaService{

	@Autowired
	private ICanchaDao canchaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cancha> listar() {

		return (List<Cancha>) canchaDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true) 
	public Cancha listarPorId(Long id) {
		
	//Si no existe entonces asigna Null.
		return canchaDao.findById(id).orElse(null);
				
	}
	/*
	@Override
	@Transactional
	public Cancha guardar(Cancha cancha) {

		return canchaDao.save(cancha);	
	}
	
	@Override
	@Transactional
	public Cancha modificar(Cancha cancha, Long id) {
		
		return canchaDao.save(cancha);	
	}	

	@Override
	@Transactional
	public void borrar(Long id) {
		
		canchaDao.deleteById(id);
	}
	*/


}