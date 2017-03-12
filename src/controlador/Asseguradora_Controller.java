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

    /**
     * Metode utilitzat insertar una Asseguradora a la BBDD
     *
     * @param p
     */
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

    /**
     * Metode utilitzat per modificar una Asseguradora que arriba per parametre
     * a la BBDD
     *
     * @param p
     */
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

    /**
     * Metode utilitzat per eliminar una Asseguradora de la BBDD
     *
     * @param p
     */
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

    /**
     * Metode utilitzat per buscar una asseguradora pel seu id i torna un
     * objecte Asseguradora.
     *
     * @param id
     * @return
     */
    public Asseguradora Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Asseguradora p = (Asseguradora) em.find(Asseguradora.class, id);

        System.out.println("close");
        em.close();

        return p;
    }

}
