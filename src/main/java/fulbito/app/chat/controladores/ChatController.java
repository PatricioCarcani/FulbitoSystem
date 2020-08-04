package fulbito.app.chat.controladores;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import fulbito.app.chat.modelos.Mensaje;

@Controller
public class ChatController {
	
	//tiene el prefijo app/
	@MessageMapping("/mensaje")
	//tiene el prefijo chat/
	// aca se envia la respuesta, que le llega a todos los clientes suscriptos
	@SendTo("/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		
	        mensaje.setUsuario(mensaje.getUsuario());
		mensaje.setTexto(mensaje.getTexto());
		System.out.println("Mensaje recibido en el backend");
		
		return mensaje;
		
	}

}
