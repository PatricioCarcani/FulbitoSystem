package fulbito.app.modelos.dao;

import org.springframework.data.repository.CrudRepository;

import fulbito.app.modelos.entidades.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>  {

}
