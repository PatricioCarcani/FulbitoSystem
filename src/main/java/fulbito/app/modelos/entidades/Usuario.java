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
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//CORREGIR @Column(name="id_persona")
	private Long idPersona;
	//CORREGIR @Column(name="nombre_usuario")
	private String nombreUsuario;
	private String mail;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ultima_modificacion")
	private Date fechaUltimaModificacion;
	private String password;
	
	public Usuario(Long idPersona, String nombreUsuario, String mail, Date fechaUltimaModificacion,
			String password) {
		super();
		this.idPersona = idPersona;
		this.nombreUsuario = nombreUsuario;
		this.mail = mail;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
