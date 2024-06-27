package frgp.utn.edu.ar.entidad;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "Nacionalidad")
public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNacionalidad")
    private int idNacionalidad;

    @Column(name = "Descripcion", length = 50, nullable = false)
    private String descripcion;

    // Constructores

    public Nacionalidad() {
        // Constructor vacío requerido por JPA
    }

    public Nacionalidad(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
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
        return "Nacionalidad{" +
                "idNacionalidad=" + idNacionalidad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
