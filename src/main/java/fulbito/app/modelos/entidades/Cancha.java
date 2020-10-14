package fulbito.app.modelos.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
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
	
}
