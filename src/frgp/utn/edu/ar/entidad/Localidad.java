package frgp.utn.edu.ar.entidad;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Entity
@Table(name = "Localidad")
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocalidad")
    private int idLocalidad;

    @Column(name = "Descripcion", length = 50, nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idProvincia", nullable = false)
    private Provincia provincia;

    // Constructores

    public Localidad() {
        // Constructor vacío requerido por JPA
    }

    public Localidad(int idLocalidad, String descripcion, Provincia provincia) {
    	this.idLocalidad=idLocalidad;
        this.descripcion = descripcion;
        this.provincia = provincia;
    }
    
    
    
    public Localidad(String descripcion, Provincia provincia) {
        this.descripcion = descripcion;
        this.provincia = provincia;
    }

    // Getters y Setters

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    // Método toString

    @Override
    public String toString() {
        return "Localidad{" +
                "idLocalidad=" + idLocalidad +
                ", descripcion='" + descripcion + '\'' +
                ", provincia=" + provincia +
                '}';
    }
}
