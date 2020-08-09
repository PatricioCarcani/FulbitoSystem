package fulbito.app.modelos.dao;

import org.springframework.data.repository.CrudRepository;

import fulbito.app.modelos.entidades.Usuario;

// Interface para manejar las operacion de BD relacionadas con el cliente
// parametros: estructura de la base datos (la clase a trabajar con el cliente) y el tipo del identificador (en este caso, Long por el ID)
public interface IUsuarioDao extends CrudRepository<Usuario, Long>  {

}
