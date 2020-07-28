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
	//CORREGIR @Column(name="tipo_dni")
	private int id_persona;
	//CORREGIR @Column(name="tipo_dni")
	private String nombre_usuario;
	private String mail;
	@Temporal(TemporalType.DATE)
	//CORREGIR @Column(name="tipo_dni")
	private Date fecha_ultima_modificacion;
	private String password;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setFecha_ultima_modificacion(Date fecha_ultima_modificacion) {
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
	}

	public Date getFecha_ultima_modificacion() {
		return fecha_ultima_modificacion;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
