
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "Clientes")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientId" , unique = true)
    private long id;
    
    @Column(name = "nif", length = 9, nullable = false)
    private String nif;
    
    @Column(name = "nomClient", length = 50)
    private String nom;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "adrecaId")
    private Adreca adreca;
    
    @OneToMany(mappedBy = "vehicleId")
    private Vehicle vehicle;
    
    @OneToOne(mappedBy = "prenedor")
    private Polissa polissa;

    public Client() {
    }

    public Client(String nif, String nom) {       
        this.nif = nif;
        this.nom = nom;
    }

    
    
}
