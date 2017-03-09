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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "Vehicles", indexes = {@Index(columnList = "matricula", name = "indexMatricula")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId", unique = true)
    private long vehicleId;

    @Column(name = "matricula", length = 7, nullable = false)
    private String matricula;

    @Column(name = "marcaModel", length = 150)
    private String marcaModel;
    
    @Column (name = "anyFabricacio")
    private int anyFabricacio;    
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client propietari;
    
    @OneToOne(mappedBy = "vehicle")
    private Polissa polissa;

    public Vehicle() {
    }

    public Vehicle(long vehicleId, String matricula, String marcaModel, int anyFabricacio, Client propietari, Polissa polissa) {
        this.vehicleId = vehicleId;
        this.matricula = matricula;
        this.marcaModel = marcaModel;
        this.anyFabricacio = anyFabricacio;
        this.propietari = propietari;
        this.polissa = polissa;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarcaModel() {
        return marcaModel;
    }

    public void setMarcaModel(String marcaModel) {
        this.marcaModel = marcaModel;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }

    public Polissa getPolissa() {
        return polissa;
    }

    public void setPolissa(Polissa polissa) {
        this.polissa = polissa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.vehicleId ^ (this.vehicleId >>> 32));
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
        final Vehicle other = (Vehicle) obj;
        if (this.vehicleId != other.vehicleId) {
            return false;
        }
        return true;
    }

    

    
    
}
