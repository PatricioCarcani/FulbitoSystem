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

import fulbito.app.modelos.entidades.Persona;
import fulbito.app.modelos.servicios.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> listar(){
		return personaService.listar();		
	}
<<<<<<< HEAD

	@GetMapping("/personas/{id}")
	@ResponseStatus(HttpStatus.OK) //devuelve un response 200
	public Persona listarPorId(@PathVariable Long id){
		return personaService.listarPorId(id);		
	}
	
	@PostMapping("/personas") //es la misma URL de mapeo porque se hace un POST en lugar de un GET
	@ResponseStatus(HttpStatus.CREATED) //devuelve un response 201
	public Persona guardar(@RequestBody Persona persona){
		return personaService.guardar(persona);		
	}
	
	@PutMapping("/personas/{id}") //es la misma URL de mapeo porque se hace un PUT en lugar de un GET
	@ResponseStatus(HttpStatus.CREATED) //devuelve un response 201
	public Persona modificar(@RequestBody Persona persona, @PathVariable Long id){
		
		// busco y traiga a la persona de la bd
		Persona personaActual = personaService.listarPorId(id);
		// la sobreescribo con los datos recibidos
		personaActual.setNombre(persona.getNombre());
		personaActual.setApellido(persona.getApellido());
		personaActual.setTipoDni(persona.getTipoDni());
		personaActual.setDni(persona.getDni());
		personaActual.setSexo(persona.getSexo());
		personaActual.setFechaNacimiento(persona.getFechaNacimiento());
		
		return personaService.guardar(personaActual);
	}
	
	//ojo revisar
	@DeleteMapping("/personas/{id}") //es la misma URL de mapeo porque se hace un PUT en lugar de un GET
	@ResponseStatus(HttpStatus.NO_CONTENT) //devuelve un response 204
	public void borrar(@PathVariable Long id){
		
		personaService.borrar(id);	
		
	}
	
=======
	/*
	 * INSERT INTO public.persona(
	nombre, apellido, tipo_dni, dni, sexo, fecha_nacimiento)
	VALUES ('pepe', 'pateatraseros', 'DNI', '33460632', 'si por favor', '19/07/1988');
	 */
	
	/*
	 * prueba
	 * */
>>>>>>> 2da91c136c2e422fbfc1582ef6fd1256d6a8acfb
}
