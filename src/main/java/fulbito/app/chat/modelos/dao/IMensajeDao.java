package fulbito.app.chat.modelos.dao;

import org.springframework.data.repository.CrudRepository;

import fulbito.app.chat.modelos.entidades.Mensaje;

public interface IMensajeDao extends CrudRepository<Mensaje, Long> {

}
