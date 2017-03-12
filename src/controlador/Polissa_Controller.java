package controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Asseguradora;
import modelo.Client;
import modelo.Polissa;
import modelo.Vehicle;

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

    public Polissa Buscar(Long idPolissa) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Polissa p = (Polissa) em.find(Polissa.class, idPolissa);

        System.out.println("close");
        em.close();

        return p;
    }

    public void BuscarPerClientLlista(Client client) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de Client");
        Query query = em.createNamedQuery("cercaPolizasCliente", Polissa.class);
        query.setParameter("cliente", client.getId());
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
    }

    public void imprimirPersona(Polissa p) {
        System.out.println(p);
    }

    public Vehicle buscarVehicle(long vehicleId) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de vehicle per id per asignar-lo a la polissa: ");
        Vehicle p = (Vehicle) em.find(Vehicle.class, vehicleId);
        System.out.println(p);
        System.out.println("close");
        em.close();
        return p;
    }

    public Asseguradora buscarAsseguradora(long aseguradoraId) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de asseguradora per id per asignar-lo a la polissa: ");
        Asseguradora a = (Asseguradora) em.find(Asseguradora.class, aseguradoraId);
        System.out.println(a);
        System.out.println("close");
        em.close();
        return a;
    }

    public Client buscarClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de client per id per asignar-lo a la polissa: ");
        Client c = (Client) em.find(Client.class, id);
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }

    public Polissa BuscarPerVehicle(Long idVehicle) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de vehicle, per eliminar després la poliza per poder eliminar el vehicle en questio: ");
        Query query = em.createNamedQuery("cercaPolizaPerVehicle", Polissa.class);
        query.setParameter("vehicle", idVehicle);
        Polissa v = (Polissa) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }
    
    public Polissa BuscarPerClient(Long idClient) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de vehicle, per eliminar després la poliza per poder eliminar el vehicle en questio: ");
        Query query = em.createNamedQuery("cercaPolizasCliente", Polissa.class);
        query.setParameter("cliente", idClient);
        Polissa v = (Polissa) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }
}
