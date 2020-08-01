package fulbito.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //habilita el servidor/broker de Spring
//hereda metodos de mensajeria (STOMP)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		registry.addEndpoint("/chat-websocket") //url para conectarse desde el frontend
		// SE PUEDE ESPECIFICAR EL PUERTO DEL FRONT (ej., http://localhost:5500)
		.setAllowedOrigins("*") //para evitar problemas de CORS con el front
		.withSockJS(); //libreria de protocolo websocket

	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {

		registry.enableSimpleBroker("/chat/"); //prefijo para el nombre de los eventos (ej., chat/suscribirse)
		registry.setApplicationDestinationPrefixes("/app"); //prefijo del destino del mensaje
		
	}
	

}
