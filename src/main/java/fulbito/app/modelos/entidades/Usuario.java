package fulbito.app.modelos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -56325219821013784L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    // @Email // valida el campo
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ultima_modificacion")
    private Date fechaUltimaModificacion;

    @Column(name = "password")
    private String password;

    // --------------------------------------------

    // VINCULO COMO FK DE PART.EVENTO
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    //@PrimaryKeyJoinColumn    
//    private ParticipanteEvento participanteEvento;
//
//    public ParticipanteEvento getParticipanteEvento() {
//        return participanteEvento;
//    }
//
//    public void setParticipanteEvento(ParticipanteEvento participanteEvento) {
//        this.participanteEvento = participanteEvento;
//    }

}
