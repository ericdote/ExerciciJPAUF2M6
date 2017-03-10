package controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Client;
import modelo.Polissa;
/**
 *
 * @author Eric
 */
public class Polissa_Controller {
    
    public void Insertar(Polissa p) {
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

    public void Modificar(Polissa p) {
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

    public void Eliminar(Polissa p) {
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

    public Polissa Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Polissa p = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
    public void BuscarPerClient(Client client) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de Client");
        Query query = em.createNamedQuery("cercaPolizasCliente",Polissa.class);
        query.setParameter("cliente", client.getId());
        List<Polissa> lista = (List<Polissa>)query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
    }
    

    public void imprimirPersona(Polissa p) {
        System.out.println(p);
    }
    
}
