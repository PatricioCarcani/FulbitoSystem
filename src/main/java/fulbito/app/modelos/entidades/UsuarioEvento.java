package fulbito.app.modelos.entidades;


		
	import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="usuario_evento")
	public class UsuarioEvento implements Serializable {
		
		/**
		 * DEFINIR PRIMARY KEY COMPUESTA EN SPRING. O LLEVA UNA PK EXTRA?
		 */
		private static final long serialVersionUID = -4351805222416656386L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_evento")
		private Long idEvento;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_usuario")
		private Long idUsuario;
		private String equipo;
		private String responsabilidades;
		
		
		public UsuarioEvento(){}
		
		// revisar este contrcutor
		public UsuarioEvento(Long idEvento, Long idUsuario, String equipo, String responsabilidades) {
			super();
			this.idEvento = idEvento;
			this.idUsuario = idUsuario;
			this.equipo = equipo;
			this.responsabilidades = responsabilidades;
		}



		public Long getIdEvento() {
			return idEvento;
		}
		public void setIdEvento(Long idEvento) {
			this.idEvento = idEvento;
		}
		public Long getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}
		public String getEquipo() {
			return equipo;
		}
		public void setEquipo(String equipo) {
			this.equipo = equipo;
		}
		public String getResponsabilidades() {
			return responsabilidades;
		}
		public void setResponsabilidades(String responsabilidades) {
			this.responsabilidades = responsabilidades;
		}
	
		
	}
