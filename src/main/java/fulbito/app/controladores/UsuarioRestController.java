package fulbito.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fulbito.app.modelos.entidades.Usuario;
import fulbito.app.modelos.servicios.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listar(){
		return usuarioService.listar();		
	}

	@GetMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK) //devuelve un response 200
	public Usuario listarPorId(@PathVariable Long id){
		return usuarioService.listarPorId(id);		
	}
	
	@PostMapping("/usuarios") //es la misma URL de mapeo porque se hace un POST en lugar de un GET
	@ResponseStatus(HttpStatus.CREATED) //devuelve un response 201
	public Usuario guardar(@RequestBody Usuario usuario){
		return usuarioService.guardar(usuario);		
	}
	
	@PutMapping("/usuarios/{id}") //es la misma URL de mapeo porque se hace un PUT en lugar de un GET
	@ResponseStatus(HttpStatus.CREATED) //devuelve un response 201
	public Usuario modificar(@RequestBody Usuario usuario, @PathVariable Long id){
		
		// busco y traiga al usuario de la base
		Usuario usuarioActual = usuarioService.listarPorId(id);
		// la sobreescribo con los datos recibidos
		usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
		usuarioActual.setMail(usuario.getMail());
		usuarioActual.setFechaUltimaModificacion(usuario.getFechaUltimaModificacion());
		usuarioActual.setPassword(usuario.getPassword());
		
		return usuarioService.guardar(usuarioActual);
	}
	
	@DeleteMapping("/usuarios/{id}") //es la misma URL de mapeo porque se hace un DELETE en lugar de un GET
	@ResponseStatus(HttpStatus.NO_CONTENT) //devuelve un response 204
	public void borrar(@PathVariable Long id){
		
		usuarioService.borrar(id);	
			
	}	
}