package fulbito.app.modelos.repository;

import org.springframework.data.repository.CrudRepository;

import fulbito.app.modelos.entidades.Usuario;

// Interface para manejar las operacion de BD relacionadas con el cliente
// parametros: estructura de la base datos (la clase a trabajar con el cliente) y el tipo del identificador (en este caso, Long por el ID)
public interface UsuarioRepository extends CrudRepository<Usuario, Long>  {

}
