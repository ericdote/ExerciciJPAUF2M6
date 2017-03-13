package controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Asseguradora;
import modelo.Client;
import modelo.Persona;
import modelo.Polissa;
import modelo.Vehicle;

/**
 *
 * @author Eric
 */
public class Polissa_Controller {

    /**
     * Metode que inserta una polissa a la BBDD que li arriba per parametre
     *
     * @param p
     */
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

    /**
     * Metode que modifica una Polissa que li arriba per parametre a la BBDD
     *
     * @param p
     */
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

    /**
     * Metode que elimina una Polissa a la BBDD que li arriba per parametre
     *
     * @param p
     */
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

    /**
     * Metode utilitzat per buscar una polissa apartir del seu id, i la retorna
     * en forma de objecte.
     *
     * @param idPolissa
     * @return
     */
    public Polissa Buscar(Long idPolissa) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Polissa p = (Polissa) em.find(Polissa.class, idPolissa);

        System.out.println("close");
        em.close();

        return p;
    }

    /**
     * Metode utlitzat pero obtenir una llista de polisses que te el client, per
     * aixo li arriba un ID per parametre per filtrar. Retorna la llista de
     * polisses que te el client.
     *
     * @param id
     * @return
     */
    public List BuscarPerClientLlista(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de Client");
        Query query = em.createNamedQuery("cercaPolizasCliente", Polissa.class);
        query.setParameter("id", id);
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
    }

    /**
     * Metode que li arriba una llista amb totes les polisses de X client, per
     * eliminar les polisses que estan viculades a ell.
     *
     * @param lista
     */
    public void EliminarPolissasPerClient(List lista) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        for (Object object : lista) {
            em.remove(em.contains(object) ? object : em.merge(object));
        }

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
//        System.out.println("Busqueda per id de Client");
//        Query query = em.createNamedQuery("eliminaPolizasCliente", Polissa.class);
//        query.setParameter("id", id);
//        em.remove(em.contains(id) ? id : em.merge(id));
//        System.out.println("Eliminado");
//        System.out.println("close");
//        em.close();
    }

    /**
     * Metode que li arriba l'ID del vehicle per parametre per buscar la polissa
     * a la qual esta relacionat X vehicle. Retorna la polissa.
     *
     * @param idVehicle
     * @return
     */
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

    /**
     * Metode que li arriba la ID d'un vehicle per parametre i retorna el
     * objecte Vehicle sencer. Aquest metode l'utilitzem per vincular un vehicle
     * a una polissa.
     *
     * @param vehicleId
     * @return
     */
    public Vehicle buscarVehicle(long vehicleId) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de vehicle per id per asignar-lo a la polissa: ");
        Vehicle p = (Vehicle) em.find(Vehicle.class, vehicleId);
        System.out.println(p);
        System.out.println("close");
        em.close();
        return p;
    }

    /**
     * Metode que li arriba la ID d'una Asseguradora per parametre i retorna el
     * objecte Asseguradora sencer. Aquest metode l'utilitzem per vincular una
     * Asseguradora a una polissa.
     *
     * @param aseguradoraId
     * @return
     */
    public Asseguradora buscarAsseguradora(long aseguradoraId) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de asseguradora per id per asignar-lo a la polissa: ");
        Asseguradora a = (Asseguradora) em.find(Asseguradora.class, aseguradoraId);
        System.out.println(a);
        System.out.println("close");
        em.close();
        return a;
    }

    /**
     * Metode que li arriba la ID d'una Client per parametre i retorna el
     * objecte Client sencer. Aquest metode l'utilitzem per vincular una Client
     * a una polissa.
     *
     * @param id
     * @return
     */
    public Client buscarClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de client per id per asignar-lo a la polissa: ");
        Client c = (Client) em.find(Client.class, id);
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }

    /**
     * Metode utilitzat per consultar totes les polisses, un cop totes obtenides
     * les retorna en una llista de polisses.
     *
     * @return
     */
    public List<Polissa> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Consulta");
        Query q = em.createQuery("FROM Polissa");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }

    /**
     * Metode utilitzat per imprimir la llista de polisses que li arriba per
     * parametre.
     *
     * @param lista
     */
    public void imprimirLista(List<Polissa> lista) {
        System.out.println("Numero de polisses= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
    public List buscarAsseguradoraPolissa(long id){
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de Polissa");
        Query query = em.createNamedQuery("cercaPolizaAsseguradora", Polissa.class);
        query.setParameter("id", id);
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
    }
}
