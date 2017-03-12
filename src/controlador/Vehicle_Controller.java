/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Adreca;
import modelo.Client;
import modelo.Usuari;
import modelo.Vehicle;

/**
 *
 * @author Eric
 */
public class Vehicle_Controller {

    /**
     * Metode utilitzat per insertar Vehicles que li arriben per parametre a la
     * BBDD
     *
     * @param p
     */
    public void Insertar(Vehicle p) {
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
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode utilitzat per modificar vehicles que li arriben per parametre a la
     * BBDD
     *
     * @param v
     */
    public void Modificar(Vehicle v) {
        // Recupera el entity manager
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(v);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode que elimina el vehicle que li arriba per parametre de la BBDD
     *
     * @param v
     */
    public void Eliminar(Vehicle v) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(v) ? v : em.merge(v));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode que permet buscar un vehicle per la seva id y el torna
     *
     * @param id
     * @return
     */
    public Vehicle Buscar(long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Vehicle c = (Vehicle) em.find(Vehicle.class, id);

        System.out.println("close");
        em.close();

        return c;
    }

    /**
     * Metode que busca un client per la id i el retorna per després asignar-lo
     * a un vehicle.
     *
     * @param id
     * @return
     */
    public Client BuscarClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de client per id per asignar-lo a la un vehicle: ");
        Client c = (Client) em.find(Client.class, id);
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }

    /**
     * Metode utilitzat per cercar vehicles per matricula
     *
     * @param matricula
     * @return
     */
    public Vehicle cercaVehicleMatricula(String matricula) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per matricula");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery("cercaVehicleMatricula", Vehicle.class);
        query.setParameter("matricula", matricula);
        Vehicle v = (Vehicle) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }

}
