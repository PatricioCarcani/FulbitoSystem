package fulbito.app.modelos.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cancha")
public class Cancha implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4351805222416656386L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String mapa;
	private String mail;
	private double precio;
	
	public Cancha() {}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}
}
