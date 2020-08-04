package fulbito.app.chat.modelos;

import java.io.Serializable;

public class Mensaje implements Serializable {

    private static final long serialVersionUID = 9079349765090513262L;

    private String usuario;
    private String texto;

    public Mensaje() {
    }

    public Mensaje(String usuario, String mensaje) {
        super();
        this.usuario = usuario;
        this.texto = texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
