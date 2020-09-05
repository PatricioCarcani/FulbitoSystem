package fulbito.app.chat.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fulbito.app.chat.modelos.dao.IMensajeDao;
import fulbito.app.chat.modelos.entidades.Mensaje;

@Service
public class MensajeServiceImpl implements IMensajeService {
    
    @Autowired
    private IMensajeDao mensajeDao;

    @Override
    @Transactional(readOnly=true)
    public List<Mensaje> listar() {

        // ver si es necesario hacer un sort by id
        return (List<Mensaje>) mensajeDao.findAll();
        
    }

    @Override
    @Transactional
    public Mensaje guardar(Mensaje mensaje) {

        return mensajeDao.save(mensaje);
        
    }

}
