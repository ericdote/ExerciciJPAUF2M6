/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@NamedQueries({
@NamedQuery(name="cercaPolizasCliente", query="SELECT p FROM Polissa p WHERE p.cliente.id:cliente"),
@NamedQuery(name="asignarVehicle", query="SELECT v FROM Vehicle v WHERE v.vehicleId=:vehicleId"),
@NamedQuery(name="asignarAsseguradora", query="SELECT a FROM Asseguradora a WHERE a.asseguradoraId=:aseguradoraId"),
@NamedQuery(name="asignarClient", query="SELECT c FROM Client c WHERE c.id=:id"),
@NamedQuery(name="cercaPolizaPerVehicle", query="SELECT p FROM Polissa p WHERE p.vehicle.vehicleId=:vehicle")})
@Table (name = "Polissas", indexes = {@Index(columnList = "clientId", name = "indexPrenedor")})
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "polissaId", unique = true)
    private long idPolissa;
    
    @Column(name = "numeroPolissa", length = 10)
    private String numero;   
    
    @OneToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;
    
    @ManyToOne 
    @JoinColumn(name = "clientId")
    private Client cliente;
    
    @Column (name = "dataInici", nullable = false)
    private Date dataInici;
    
    @Column (name = "dataFi", nullable = false)
    private Date dataFi;
    
    @Column (name = "tipus")
    private boolean tipus;
    
    @Column (name = "prima")
    private double prima;
    
    @ManyToOne
    @JoinColumn(name = "asseguradoraId")
    private Asseguradora asseguradora;

    public Polissa() {
    }

    public Polissa(long idPolissa, String numero, Vehicle vehicle, Client cliente, Date dataInici, Date dataFi, boolean tipus, double prima, Asseguradora asseguradora) {
        this.idPolissa = idPolissa;
        this.numero = numero;
        this.vehicle = vehicle;
        this.cliente = cliente;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
        this.asseguradora = asseguradora;
    }

    public long getIdPolissa() {
        return idPolissa;
    }

    public void setIdPolissa(long idPolissa) {
        this.idPolissa = idPolissa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
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

    public Asseguradora getAsseguradora() {
        return asseguradora;
    }

    public void setAsseguradora(Asseguradora asseguradora) {
        this.asseguradora = asseguradora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.idPolissa ^ (this.idPolissa >>> 32));
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
        if (this.idPolissa != other.idPolissa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "idPolissa=" + idPolissa + ", numero=" + numero + ", vehicle=" + vehicle + ", cliente=" + cliente + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + ", asseguradora=" + asseguradora + '}';
    }

    

   

    
   

   
}