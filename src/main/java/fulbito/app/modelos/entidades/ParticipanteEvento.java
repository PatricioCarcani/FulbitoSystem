package fulbito.app.modelos.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participante_evento")
public class ParticipanteEvento implements Serializable {

    /**
     * DEFINIR PRIMARY KEY COMPUESTA EN SPRING. O LLEVA UNA PK EXTRA?
     */
    private static final long serialVersionUID = -4351805222416656386L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;    

    // hacer onetomany -REVISAR-
    @Column(name = "id_evento")
    private Long idEvento;
    
    // hacer onetomany
    @Column(name = "id_usuario")
    private Long idUsuario;   
    
    
    public ParticipanteEvento() {
    }

    public ParticipanteEvento(Long idEvento, Long idUsuario) {
        super();
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }



    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }    
    
    

}
