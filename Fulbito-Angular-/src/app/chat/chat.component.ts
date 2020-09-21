import { Component, OnInit } from '@angular/core';
// importar stompjs y sockjs
import {Client} from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import {Mensaje} from './models/mensaje';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  // creamos atributo cliente stomp
  private client: Client;
  conectado: boolean = false;
  mensaje: Mensaje = new Mensaje();
  mensajes: Mensaje[] = [];

  constructor() { }

  ngOnInit(): void {
    // se inicia el cliente desde el principio
    this.client = new Client();
    this.client.webSocketFactory = () => {
      // ruta al websocket (es igual al endpoint en Spring)
      return new SockJS("http://localhost:8082/chat-websocket");
    }

    //escuchar cuando nos conectamos
    this.client.onConnect = (frame) => {

      console.log('Conectados: ' + this.client.connected + ' : ' + frame);
      this.conectado=true;

      //nos subscribimos a evento chat
      this.client.subscribe('/chat/mensaje', e => {
        let mensaje: Mensaje = JSON.parse(e.body) as Mensaje;
        this.mensajes.push(mensaje);
        console.log(mensaje);
      })

      // aavisar que tal usuario se conecto
      // TODO: Leerla de las credenciales de JWT
      this.mensaje.usuario = 'usuario';
      this.mensaje.texto  = "ha iniciado sesión"
      this.client.publish({ destination: '/app/mensaje', body: JSON.stringify(this.mensaje) });
      // vaciar texto
      this.mensaje.texto= '';

      // suscribirse al historial
      this.client.subscribe('/chat/historial/', e => {
        const historial = JSON.parse(e.body) as Mensaje[];
        this.mensajes = historial;
      })

      // notificar al broker que queremos traer el historial
      this.client.publish({ destination: '/app/historial'});

    } // cierra onConnect

    this.client.onDisconnect = (frame) => {
      console.log('Desconectados: ' + !this.client.connected + ' : ' + frame);
      this.conectado = false;
      // resetar atributos de la clase
      this.mensaje = new Mensaje();
      this.mensajes = [];
    }    

  }

  conectar(): void {
        // metodo para conectarse
        this.client.activate();
  }

  desconectar(): void {
    // metodo para conectarse
    this.client.deactivate();
  }

  enviarMensaje(): void {
    this.client.publish({ destination: '/app/mensaje', body: JSON.stringify(this.mensaje) });
    // vaciar texto
    this.mensaje.texto= '';
  }

}
