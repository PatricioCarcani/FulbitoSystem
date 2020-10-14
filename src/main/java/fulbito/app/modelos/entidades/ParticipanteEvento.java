package fulbito.app.modelos.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "participante_evento")
public class ParticipanteEvento implements Serializable {

    /**
     * DEFINIR PRIMARY KEY COMPUESTA EN SPRING. O LLEVA UNA PK EXTRA?
     */
    private static final long serialVersionUID = -4351805222416656386L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;    

    /** en realidad es asi, pero rompe en @lista, y no necesitamos estos datos por ahora
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id") 
    // id_evento
    private Evento idEvento;    
    */
    
    @Column(name = "id_evento")
    private Long idEvento;
    
    /** funciona pero no graba
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    //id_usuario"
    private Usuario idUsuario;   
    */
    
    /** funciona y graba
     */

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", nullable = true)    
    //@PrimaryKeyJoinColumn
    private Usuario usuario;
    
    

   
    

}
