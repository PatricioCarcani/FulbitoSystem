package fulbito.app.chat.modelos.servicios;

import java.util.List;

import fulbito.app.chat.modelos.entidades.Mensaje;

public interface IMensajeService {
    
    public List<Mensaje> listar();
    
    public Mensaje guardar(Mensaje mensaje);    

}
