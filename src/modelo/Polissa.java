/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table (name = "Polissas", indexes = {@Index(columnList = "prenedor", name = "indexPrenedor")})
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "polissaId", unique = true)
    private Long idPolissa;
    
    @Column(name = "numeroPolissa", length = 10)
    private String numero;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", nullable = false)
    private Client prenedor;
    
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleId", nullable =  false)
    private Vehicle vehicle;
    
    @Column (name = "dataInici", nullable = false)
    private Date dataInici;
    
    @Column (name = "dataFi", nullable = false)
    private Date dataFi;
    
    @Column (name = "tipus")
    private boolean tipus;
    
    @Column (name = "prima")
    private double prima;

    public Polissa() {
    }

    public Polissa(String numero, Date dataInici, Date dataFi, boolean tipus, double prima) {
        this.numero = numero;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
    }

    public Long getIdPolissa() {
        return idPolissa;
    }

    public void setIdPolissa(Long idPolissa) {
        this.idPolissa = idPolissa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Client getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public boolean isTipus() {
        return tipus;
    }

    public void setTipus(boolean tipus) {
        this.tipus = tipus;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idPolissa);
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
        final Polissa other = (Polissa) obj;
        if (!Objects.equals(this.idPolissa, other.idPolissa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "idPolissa=" + idPolissa + ", numero=" + numero + ", prenedor=" + prenedor + ", vehicle=" + vehicle + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + '}';
    } 

}