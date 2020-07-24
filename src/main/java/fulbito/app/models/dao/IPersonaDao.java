package fulbito.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import fulbito.app.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
