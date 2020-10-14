package fulbito.app.chat.modelos.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mensaje")
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 9079349765090513262L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String texto;

}
