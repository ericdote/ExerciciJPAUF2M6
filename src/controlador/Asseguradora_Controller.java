package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Asseguradora;

/**
 *
 * @author Eric
 */
public class Asseguradora_Controller {
    
        public void Insertar(Asseguradora p) {
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

    public void Modificar(Asseguradora p) {
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

    public void Eliminar(Asseguradora p) {
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

    public Asseguradora Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Asseguradora p = (Asseguradora) em.find(Asseguradora.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
    public Asseguradora BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery("ClientNom",Asseguradora.class);
        query.setParameter("nom", nom);
        Asseguradora p = (Asseguradora) query.getSingleResult();
        System.out.println("close");
        em.close();

        return p;
    }

    public void imprimirPersona(Asseguradora p) {
        System.out.println(p);
    }
    
    
}
