package fulbito.app.chat.modelos;

import java.io.Serializable;

public class Mensaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9079349765090513262L;
	
	private String texto;
	private Long fecha;
	
	public Mensaje() {}
	
	public Mensaje(String texto, Long fecha) {
		super();
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	
	

}
