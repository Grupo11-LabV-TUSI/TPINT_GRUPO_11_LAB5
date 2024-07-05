package frgp.utn.edu.ar.entidad;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "Provincia")
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvincia")
    private int idProvincia;

    @Column(name = "Descripcion", length = 20, nullable = false)
    private String descripcion;

    // Constructores

    public Provincia() {
        // Constructor vacío requerido por JPA
    }

    public Provincia(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método toString

    @Override
    public String toString() {
        return "Provincia{" +
                "idProvincia=" + idProvincia +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
