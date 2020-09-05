package fulbito.app.chat.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import fulbito.app.chat.modelos.entidades.Mensaje;
import fulbito.app.chat.modelos.servicios.IMensajeService;
import fulbito.app.modelos.entidades.Cancha;
import fulbito.app.modelos.entidades.ParticipanteEvento;
import fulbito.app.modelos.servicios.ICanchaService;
import fulbito.app.modelos.servicios.IParticipanteEventoService;
import fulbito.app.modelos.servicios.IUsuarioService;

@Controller
public class ChatController {

    @Autowired
    private IMensajeService mensajeService;
    
    @Autowired
    private ICanchaService canchaService;
    
    @Autowired
    private IParticipanteEventoService participanteEventoService;
    
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
        // se guarda el mensaje original en BD
        mensajeService.guardar(mensaje);
        
        // validador de comandos (textos que empiezan con "@")
        if(mensaje.getTexto().startsWith("@")) {
            
            Mensaje mensajeDeBot = new Mensaje();
            mensajeDeBot.setUsuario("FulbitoBot");
            
            switch(mensaje.getTexto()){ 
            
                case "@cancha":
                    // traer solo la primer cancha (puede mejorarse y traer todas)
                    Cancha cancha = canchaService.listar().get(0);
                    // nota: no se puede dejar una linea (ej: \n)                      
                    mensajeDeBot.setTexto(cancha.getNombre() + " - "
                            + cancha.getDireccion() + " - "
                            + "Tel.: " + cancha.getTelefono() + " - "
                            // probe de usar un iframe pero no lo toma
                            + "Link mapa: " + cancha.getMapa() + " - "
                            + "Mail: " + cancha.getMail() + " - "
                            + "Precio: $" + cancha.getPrecio()
                            );
                    break;
                    
                case "@plata":  
                    // traer solo la primer cancha (puede mejorarse y traer todas)
                    Double precioCancha = canchaService.listar().get(0).getPrecio();
                    // nota: no se puede dejar una linea (ej: \n)                      
                    mensajeDeBot.setTexto("$" + precioCancha
                            // aca abajo se puede agregar la division precio / jugadores confirmados
                            //+ "Precio: $" + cancha.getPrecio()
                            );
                    break;
                    
                case "@mapa":  
                    // traer solo la primer cancha (puede mejorarse y traer todas)
                    String mapa = canchaService.listar().get(0).getMapa();
                    // nota: no se puede dejar una linea (ej: \n)                      
                    mensajeDeBot.setTexto("Link del mapa:" + mapa);
                    break;                     
                    
                case "@fecha":  
                    mensajeDeBot.setTexto("Se juega el viernes 29 a las 19hs."); 
                    break;
                    
                case "@hora":  
                    mensajeDeBot.setTexto("Se juega a las 19hs."); 
                    break;

                case "@lista":
                    
                    System.out.println( "Comando recibido: @lista");
                    // TODO: QUE NO TRAIGA SOLO EL PRIMER EVENTO, SINO QUE BUSQUE TODOS BAJO EVENTO '1', y luego hacer un foreach o ver
                    // traer solo la primer cancha (puede mejorarse y traer todas)
                    List<ParticipanteEvento> todosLosParticipanteEvento = participanteEventoService.listar();
                    
                    String resultado = "";
                    
                    for ( ParticipanteEvento pe : todosLosParticipanteEvento) {
                        
                        // USAR STRINGBUILDER, PORQUE SE GUARDAN UN SOLO TEXTO
                        if ( pe.getIdEvento() == 1 ) {
                            
                            // LISTAR TODOS LOS QUE TENGAN EVENTO 1
                            // nota: no se puede dejar una linea (ej: \n)                      
                            // ESTO VA -> mensajeDeBot.setTexto( "Usuario: " + pe.next().getIdUsuario() );
                            resultado += "Usuario: " + pe.getIdUsuario() + "\n"; // BORRAR
                            // alternativa si no salen los mapeos to-many: Usuarioservice.getporid(1)
                            System.out.println( pe.getIdUsuario());
                            
                        }
                        
                    }
                    
                    mensajeDeBot.setTexto(resultado);
                    
                    System.out.println( "Fin comando @lista");

                    break;                    
                    
                default:   
                    mensajeDeBot.setTexto("El comando ingresado es incorrecto.");  
            }
            
            mensajeService.guardar(mensajeDeBot);
            return mensajeDeBot;
            
        }
        
        // TODO: SWITCH Y VINCULARLO A UN ARRAY DE LA TABLA COMANDOS-ALGO
        // traer la ista de comandos, guardarla, e iterarla

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
