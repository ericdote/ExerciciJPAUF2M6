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
import modelo.Usuari;

/**
 *
 * @author Eric
 */
public class Usuari_Controller {

    /**
     * Metode que inserta un usuari a la BBDD que li entra per parametre
     *
     * @param p
     */
    public void Insertar(Usuari p) {
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
     * Metode que modifica un usuari que li entra per parametre i l'inserta a la
     * BBDD
     *
     * @param p
     */
    public void Modificar(Usuari p) {
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
     * Metode que elimina un usuari que li arriba per parametre a la BBDD
     *
     * @param p
     */
    public void Eliminar(Usuari p) {
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
     * Metode que busca un client per ID a la BBDD i el retorna en objecte
     * d'usuari
     *
     * @param usu
     * @return
     */
    public Usuari Buscar(Usuari usu) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Usuari p = (Usuari) em.find(Usuari.class, usu.getNom());
        

        System.out.println("close");
        em.close();

        return p;
    }
    

}
