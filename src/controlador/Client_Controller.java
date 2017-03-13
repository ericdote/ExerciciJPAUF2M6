package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Client;
import modelo.Polissa;
import modelo.Vehicle;

public class Client_Controller {

    /**
     * Metode que permet insertar un client que li arriba per parametre a una
     * BBDD
     *
     * @param p
     */
    public void Insertar(Client p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode que li arriba per parametre un Client per modificar-lo i
     * actualitzar-lo a la BBDD.
     *
     * @param p
     */
    public void Modificar(Client p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode utilitzat per eliminar un client de la BBDD
     *
     * @param p
     */
    public void Eliminar(Client p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode utilitzat per buscar un client per la seva id i tornar el objecte
     * sencer.
     *
     * @param id
     * @return
     */
    public Client Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Client c = (Client) em.find(Client.class, id);

        System.out.println("close");
        em.close();

        return c;
    }

    /**
     * Metode que li arriba el nom del client per parametre i retorna el objecte
     * client sencer relacionat amb el nom
     *
     * @param nom
     * @return
     */
    public Client BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery("cercaClientNom", Client.class);
        //El primero es ? el segundo es el parametro que le llega al metodo
        query.setParameter("nom", nom);
        Client c = (Client) query.getSingleResult();
        System.out.println("close");
        em.close();
        return c;
    }

    /**
     * Metode utilitzat per imprimir un client
     *
     * @param c
     */
    public void imprimirPersona(Client c) {
        System.out.println(c);
    }
    
    public List<Vehicle> obtenirVehiclesClient(long id){
        EntityManager  em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de vehicles que te un client");
        Query query = em.createNamedQuery("cercaVehiclesClient", Vehicle.class);
        query.setParameter("id", id);
        List<Vehicle> lista = (List<Vehicle>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
    }

}
