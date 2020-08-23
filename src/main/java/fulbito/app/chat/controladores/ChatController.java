package fulbito.app.chat.controladores;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import fulbito.app.chat.modelos.entidades.Mensaje;
import fulbito.app.chat.modelos.servicios.IMensajeService;
import fulbito.app.modelos.servicios.IUsuarioService;

@Controller
public class ChatController {

    @Autowired
    private IMensajeService mensajeService;
    
    // usado para historial
    @Autowired
    private SimpMessagingTemplate websocket;

    // tiene el prefijo app/
    @MessageMapping("/mensaje")
    // tiene el prefijo chat/
    // aca se envia la respuesta, que le llega a todos los clientes suscriptos
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje(Mensaje mensaje) {


        System.out.println("Mensaje recibido en el backend");
        
        // TODO: SWITCH Y VINCULARLO A UN ARRAY DE LA TABLA COMANDOS-ALGO
        if( "/cancha".equals(mensaje.getTexto()) ) {
            // logica de voy a la API y traiga una lista de cancha o una sola o lo que sea
            mensaje.setUsuario("FulbitoBot");
            mensaje.setTexto("la cancha que en Paseo Alcorta y Pringles");
        }
        //antes de guardarlo,hacer la verificacion de si el texto empieza con / y ver si es un comando
        // traer la ista de comandos, guardarla, e iterarla
        // guardar en BD
        mensajeService.guardar(mensaje);

        return mensaje;

    }
    
    @MessageMapping("/historial")
    public void historial(){
        
        System.out.println("Mensajes listados");
        // ver si se saca la ultima barraen historial/
        websocket.convertAndSend("/chat/historial/", mensajeService.listar());
        
    }    
    
    // cada cliente va a tener una subscripcion al chat historial
    // se puede personalizar por nombre de usuario de ser necesario
    /*
    @MessageMapping("/historial")
    @SendTo("/chat/historial")
    public List<Mensaje> enviaHistorial(){
        
        System.out.println("Mensajes listados");
        return mensajeService.listar();
        
    }*/

}
