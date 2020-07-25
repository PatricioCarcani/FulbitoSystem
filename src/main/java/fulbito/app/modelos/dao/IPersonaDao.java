package fulbito.app.modelos.dao;

import org.springframework.data.repository.CrudRepository;

import fulbito.app.modelos.entidades.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
