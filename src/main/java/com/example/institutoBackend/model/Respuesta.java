package com.example.institutoBackend.model;

public class Respuesta {
    private final Estado estado;
    private final String mensaje;

    public Estado getEstado() {
        return this.estado;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Respuesta)) {
            return false;
        } else {
            Respuesta other = (Respuesta)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$estado = this.getEstado();
                Object other$estado = other.getEstado();
                if (this$estado == null) {
                    if (other$estado != null) {
                        return false;
                    }
                } else if (!this$estado.equals(other$estado)) {
                    return false;
                }

                Object this$mensaje = this.getMensaje();
                Object other$mensaje = other.getMensaje();
                if (this$mensaje == null) {
                    if (other$mensaje != null) {
                        return false;
                    }
                } else if (!this$mensaje.equals(other$mensaje)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Respuesta;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $estado = this.getEstado();
        result = result * 59 + ($estado == null ? 43 : $estado.hashCode());
        Object $mensaje = this.getMensaje();
        result = result * 59 + ($mensaje == null ? 43 : $mensaje.hashCode());
        return result;
    }

    public String toString() {
        Estado var10000 = this.getEstado();
        return "Respuesta(estado=" + var10000 + ", mensaje=" + this.getMensaje() + ")";
    }

    public Respuesta(final Estado estado, final String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }
}
