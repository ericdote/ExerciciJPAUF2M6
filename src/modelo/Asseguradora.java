/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table (name = "Asseguradores")
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long asseguradoraId;

    @Column(name = "nom", length = 100, nullable = false, unique = true)
    private String nom;
    
    @Column (name = "cif")
    private String cif;

    public Asseguradora() {
    }

    public Asseguradora(String nom, String cif) {
        this.nom = nom;
        this.cif = cif;
    }

    public Long getAsseguradoraId() {
        return asseguradoraId;
    }

    public void setAsseguradoraId(Long asseguradoraId) {
        this.asseguradoraId = asseguradoraId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.asseguradoraId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asseguradora other = (Asseguradora) obj;
        if (!Objects.equals(this.asseguradoraId, other.asseguradoraId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "asseguradoraId=" + asseguradoraId + ", nom=" + nom + ", cif=" + cif + '}';
    }
    
    
}
