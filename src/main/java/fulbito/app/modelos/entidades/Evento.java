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
	
	
	public Evento() {}

	public Evento(String nombreEvento, Long idCancha, Long idUsuarioCreador, Date fechaEvento, Boolean estaActivo) {
		super();
		this.nombreEvento = nombreEvento;
		this.idCancha = idCancha;
		this.idUsuarioCreador = idUsuarioCreador;
		this.fechaEvento = fechaEvento;
		this.estaActivo = estaActivo;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getid() {
		return id;
	}

	public void setnombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getnombreEvento() {
		return nombreEvento;
	}

	public void setidcancha(Long idCancha) {
		this.idCancha = idCancha;
	}

	public Long getidCancha() {
		return idCancha;
	}

	public void setidUsuarioCreador(Long idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}

	public Long getidUsuarioCreador() {
		return idUsuarioCreador;
	}

	public void setfechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Date getfechaEvento() {
		return fechaEvento;
	}

	public void setestaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public Boolean getestaActivo() {
		return estaActivo;
	}

}
