/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Jorge
 */
@Entity
@NamedQueries({
@NamedQuery(name="PersonaNom", query="SELECT p FROM Persona p WHERE p.nombre=:nombre"),
@NamedQuery(name="PersonaCognom", query="SELECT p FROM Persona p WHERE p.nombre=:cognom")
})
//@NamedQuery(name=Persona.CONSULTA, query="SELECT p FROM Persona p WHERE p.nombre=:nombre")})
@Table(name = "M6UF2_PERSONES")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personaId")
    private Long id;
    
    @Transient
    public static final String CONSULTA = "PersonaNombre";
    
    @Column(name = "personaNombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "personaApellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(unique = true)
    private String email;

    @Column(length = 9)
    private String telefono;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "direccioId")
    private Direccio direccio;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellidos, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccio getDireccio() {
        return direccio;
    }

    public void setDireccio(Direccio direccio) {
        this.direccio = direccio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{ nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + ", direccio=" + direccio + '}';
    }

}
