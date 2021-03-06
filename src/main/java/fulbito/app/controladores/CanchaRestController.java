package fulbito.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fulbito.app.modelos.entidades.Cancha;
import fulbito.app.modelos.servicios.CanchaService;

@RestController
@RequestMapping("/api")
public class CanchaRestController {
	
	@Autowired
	private CanchaService canchaService;
	
	@GetMapping("/canchas")
	public List<Cancha> listar(){
		return canchaService.listar();		
	}

	// solo usamos este porque esta harcodeado para listar la unica cancha que hay
	@GetMapping("/canchas/{id}")
	@ResponseStatus(HttpStatus.OK) //devuelve un response 200
	public Cancha listarPorId(@PathVariable Long id){
		return canchaService.listarPorId(id);		
	}	
	
	@PostMapping("/canchas") //es la misma URL de mapeo porque se hace un POST en lugar de un GET
	@ResponseStatus(HttpStatus.CREATED) //devuelve un response 201
	public Cancha guardar(@RequestBody Cancha cancha){
	        return canchaService.guardar(cancha);         
	}
	//public Cancha guardar(Cancha cancha);
	
	//public Cancha modificar(Cancha cancha, Long id);
	
	//public void borrar(Long id);
	
	
}