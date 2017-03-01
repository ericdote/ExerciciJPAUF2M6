package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "Adreca")
public class Adreca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adrecaId", nullable = false, unique = true)
    private Long id;

    @Column(name = "carrer", length = 50, nullable = false)
    private String carrer;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "poblacio", length = 50, nullable = false)
    private String polbacio;

    @OneToOne(mappedBy = "adreca")
    private Client client;

    public Adreca() {
    }

    public Adreca(String carrer, int numero, String polbacio) {
        this.carrer = carrer;
        this.numero = numero;
        this.polbacio = polbacio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPolbacio() {
        return polbacio;
    }

    public void setPolbacio(String polbacio) {
        this.polbacio = polbacio;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Adreca other = (Adreca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adreca{" + "id=" + id + ", carrer=" + carrer + ", numero=" + numero + ", polbacio=" + polbacio + ", client=" + client + '}';
    }
    
    

    
    
    
    

}
