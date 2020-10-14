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
import fulbito.app.modelos.entidades.Usuario;
import fulbito.app.modelos.servicios.CanchaService;
import fulbito.app.modelos.servicios.ParticipanteEventoService;
import fulbito.app.modelos.servicios.UsuarioService;

@Controller
public class ChatController {

    @Autowired
    private IMensajeService mensajeService;
    
    @Autowired
    private CanchaService canchaService;
    
    @Autowired
    private ParticipanteEventoService participanteEventoService;
    
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
                    System.out.println("LOS TRAJO BIEN");
                    String resultado = "";
                    
                    for ( ParticipanteEvento pe : todosLosParticipanteEvento) {
                        
                        // USAR STRINGBUILDER, PORQUE SE GUARDAN UN SOLO TEXTO
                        if ( pe.getIdEvento() == 1 ) {
                            
                            // LISTAR TODOS LOS QUE TENGAN EVENTO 1
                            // nota: no se puede dejar una linea (ej: \n)                      
                            resultado += "✅" + pe.getUsuario().getNombreUsuario() + " "; // BORRAR
                            System.out.println( pe.getUsuario().getNombreUsuario());
                            
                        }
                        
                    }
                    
                    mensajeDeBot.setTexto(resultado);
                    
                    System.out.println( "Fin comando @lista");

                    break; 
                    
                case "@mesumo":  
                    System.out.println( "Comando recibido: @mesumo");
                    
                    // aca se supone que va a leer los datos del usuario actual LOGUEADO, asi que: TODO despues del login
                    Usuario usuario = new Usuario();
                    // fecha y hora ahora
                    usuario.setNombreUsuario("nombreHardcodeado");
                    usuario.setMail("mailtrucho@aaa.com");
                    usuario.setFechaUltimaModificacion(new Date());
                    usuario.setPassword("test");
                    
                    ParticipanteEvento participanteEvento = new ParticipanteEvento();
                    // hardocodeado para usar siempre el mismo evento
                    participanteEvento.setIdEvento(1L);
                    // idem, lo toma del usuario arriba
                    participanteEvento.setUsuario(usuario);
                    participanteEventoService.guardar(participanteEvento);
                    
                    mensajeDeBot.setTexto("Felicitaciones por anotarte " + usuario.getNombreUsuario() + ", vas a jugar!" ); 
                    break;    
                    
                case "@mebajo":  
                    System.out.println( "Comando recibido: @mebajo");
                    
                    // harcodeado, en realidad tiene que buscar en BD tu usuario y ponerlo como parametro
                    // BORRA POR EL ID, Y ESTA PERFECTO! ACLARACION: NO BORRA EL ID_EVENTO O UD_USUARIO, QUIZAS HAYA QUE AGREGARLE ESTA LOGICA
                    participanteEventoService.borrar(18L);
                    
                    mensajeDeBot.setTexto("Te diste de baja, ya no vas a jugar!" ); 
                    break; 
                    
                case "@ayuda":  
                    System.out.println( "Comando recibido: @ayuda");
                    
                    // harcodeado, en realidad tiene que buscar en BD tu usuario y ponerlo como parametro
                    // BORRA POR EL ID, Y ESTA PERFECTO! ACLARACION: NO BORRA EL ID_EVENTO O UD_USUARIO, QUIZAS HAYA QUE AGREGARLE ESTA LOGICA
                    //HARDCODEAR
                    
                    String comandos = "";
                    comandos = "@cancha : muestra toda la información de la cancha | " + 
                               "@mapa : muestra mapa de la cancha | " + 
                               "@plata : muestra precio de la cancha | " + 
                               "@fecha : fecha del partido | " + 
                               "@hora : muestra horario del evento | " + 
                               "@lista : lista numerada de participantes, con id de jugador y nombre | " + 
                               "@mesumo : se agrega el jugador a la lista del evento | " + 
                               "@mebajo : se elimina a el jugador de la lista del evento | " + 
                               "@ayuda : listado de comandos disponibles";                
                                        
                    mensajeDeBot.setTexto(comandos); 
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
