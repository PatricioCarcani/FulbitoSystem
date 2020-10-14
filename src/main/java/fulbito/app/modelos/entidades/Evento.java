package fulbito.app.modelos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "evento")
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4351805222416656386L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_evento")
	private String nombreEvento;
	@Column(name = "id_cancha")
	private Long idCancha;
	@Column(name = "id_usuario_creador")
	private Long idUsuarioCreador;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_evento")
	private Date fechaEvento;
	@Column(name = "esta_activo")
	private Boolean estaActivo;
	
}
