/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajpa;

import controlador.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import modelo.*;

/**
 *
 * @author Jorge
 */
public class PersonaJPA {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");//Inicialitzem SimpleDateFormat per donar format a les dates de les polisses
            Adreca adre1 = new Adreca("Carrer Fals", 1, "Poblacion No existent");//Creem una Adreça pels usuaris
            Usuari usu1 = new Usuari("Eric12", "1324");//Creem un Usuari
            Client cli1 = new Client(0, "1234678-y", "Ericss", adre1);//Creem un client i li assignem la adreça
            Asseguradora ase1 = new Asseguradora(0, "Mapfre2", "45784d");//Creem una asseguradora
            //Inicialitzem tots els controladors
            Polissa_Controller pc = new Polissa_Controller();
            Usuari_Controller uc = new Usuari_Controller();
            Client_Controller cc = new Client_Controller();
            Vehicle_Controller vc = new Vehicle_Controller();
            Asseguradora_Controller asc = new Asseguradora_Controller();
            /**
             * Aqui farem tot lo relacionat amb l'usuari
             */
            System.out.print("Insertem un usuari: ");
            uc.Insertar(usu1);//Insertem un usuari
            System.out.println(usu1);
            Usuari usuModificar = uc.Buscar("Eric12"); //Creem un nou usuari per Modificar, buscant per la id a la BBDD
            System.out.println("Modifiquem un usuari: ");
            System.out.println("Abans: " + usuModificar);
            usuModificar.setPass("456");//Modifiquem algun valor del usuari
            uc.Modificar(usuModificar);//Apliquem les modificacion a la BBDD
            System.out.println("Despres: " + usuModificar);
            System.out.println("Cerca de usuari per id: " + uc.Buscar("Eric12"));//Realitzem una cerca per ID a la BBDD buscant un usuari
            Usuari usuEliminar = uc.Buscar("Eric12");//Creem un usuari per eliminar, el qual tindra el format del usuari que busquem a la BBDD
            System.out.println("Eliminar usuari: ");
            uc.Eliminar(usuEliminar);//Eliminem el usuari de la BBDD
            System.out.println("Si busquem ara ja no existeix: " + uc.Buscar("Eric12"));
            /**
             * Aqui farem tot lo relacionat amb els clients
             */
            System.out.print("Insertem un client: ");
            cc.Insertar(cli1);//Insertem el client creat per defect.
            System.out.println(cli1);
            Client cliModificar = cc.Buscar(2221L);//Creem un usuari per modificar un usuari de la BBDD el qual cerquem
            System.out.println("Modifiquem un client: ");
            System.out.println("Abans: " + cliModificar);
            cliModificar.setNif("111111A");//Modifiquem algun valor del objecte usuari
            cc.Modificar(cliModificar);//Apliquem els canvis del usuari a la BBDD
            System.out.println("Despres: " + cliModificar);
            System.out.println("Cerca de client per id: " + cc.Buscar(cliModificar.getId()));//Cerca realitza per ID al client

            System.out.print("Eliminem un client: ");
            Client cliEliminar = cc.Buscar(cliModificar.getId());//Creem un nou client per obtenir l'objecte i poder fer tot lo seguent:
            /*A l'hora d'eliminar un Client, primer hem d'eliminar la Polissa que te, i per consquent també deixar de fer referencia a aquest client als diferents vehicles als quals esta vinculat (els que te a les polisses basicament)*/
            List<Polissa> polissasAmbClient = pc.BuscarPerClientLlista(cliEliminar.getId());//Obtenim una llista de les polisses del client
            for (Polissa polissa : polissasAmbClient) { //Recorrem la llista
                Vehicle vehiTeureClient = polissa.getVehicle(); //Obtenim el vehicle de cada polissa
                vehiTeureClient.setPropietari(null);//Li canviem el propietari a null
                vc.Modificar(vehiTeureClient);//Modifiquem
            }

            pc.EliminarPolissasPerClient(pc.BuscarPerClientLlista(cliEliminar.getId())); //Hem d'eliminar abans les polisses a les que esta relacionat el Client, degut que te relacio i si no, no podem eliminar el client
            cc.Eliminar(cliEliminar);//Per ultim, un cop ja no hi han cap tipus de relacio entre taules, eliminem el Client.
            System.out.println("Si busquem ara ja no existeix: " + cc.Buscar(cliEliminar.getId()));
            cc.imprimirPersona(cc.BuscarPerNom("Eric2"));//Cerca del client pel nom que te
            pc.BuscarPerClientLlista(cc.BuscarPerNom("Eric2").getId());//Cerca de les polisses que te un usuari
            /**
             * Aqui farem tot lo relacionat amb els Vehicles
             */
            Client cliPerVehicle = vc.BuscarClient(2261L);//Busquem un client per asignar despres al vehicle
            Vehicle vehi1 = new Vehicle(0, "213578", "AB", 1995, cliPerVehicle, null); //Declarem un objecte Vehicle i li asignem els seus valors, juntament amb el client que li hem assignat.
            vc.Insertar(vehi1);//Insertem el vehicle a la BBDD
            System.out.println(vehi1);
            Vehicle vehiModificar = vc.Buscar(1721L); //Creem un nou objecte Vehicle apartir d'una cerca que realitzem a la BBDD per l'ID per modificar
            System.out.println("Modifiquem un Vehicle: ");
            System.out.println("Abans: " + vehiModificar);
            vehiModificar.setMarcaModel("ABC");//Modifiquem algun valor del vehicle.
            vc.Modificar(vehiModificar);//Apliquem la modificacio a la BBDD
            System.out.println("Despres: " + vehiModificar);
            Vehicle vehiPerEliminar = vc.Buscar(2141L);//Creem un nou objecte per eliminar un vehicle i cercem per ID
            System.out.println("Eliminem un vehicle, pero abans hem d'eliminar una polissa ja que esta el vehicle vinculat a aquesta: ");
            Polissa poliEliminar = pc.BuscarPerVehicle(vehiPerEliminar.getVehicleId()); //Busquem la polissa a la qual esta vinculat el vehicle
            pc.Eliminar(poliEliminar);//Eliminem la polissa
            vc.Eliminar(vehiPerEliminar);//Eliminem el vehicle un cop ja no te cap relacio amb cap altre taula.
            System.out.println("Si busquem ara no existeix: " + vc.Buscar(vehiPerEliminar.getVehicleId()));
            System.out.println(pc.BuscarPerVehicle(vc.Buscar(2141L).getVehicleId()));//Realitzem una cerca de polissas que te el vehicle
            /**
             * Aqui va tot lo relacionat amb les asseguradores
             */
            System.out.print("Insertem una asseguradora: ");
            asc.Insertar(ase1);//Insertem a la BBDD la asseguradora que hem creat
            System.out.println(ase1);
            Asseguradora aseModificar = asc.Buscar(789L);//Busquem la asseguradora pel seu ID i la fiquem a un nou objecte Asseguradora
            System.out.println("Modificar una asseguradora: ");
            System.out.println("Abans: " + aseModificar);
            aseModificar.setNom("Mahfre");
            asc.Modificar(aseModificar);//Realitzem alguna modificacio a la asseguradora
            System.out.println("Despres: " + aseModificar);
            System.out.println("Cerca d'una asseguradora per la seva id: " + asc.Buscar(aseModificar.getAsseguradoraId()));//Cerca de asseguradora per ID
            System.out.println("Eliminem una asseguradora: ");
            asc.Eliminar(aseModificar);//Eliminem una asseguradora de la BBDD
            System.out.println("Si busquem ara no la trobem: " + asc.Buscar(aseModificar.getAsseguradoraId()));
            /**
             * Aqui va tot lo relacionat amb les Polisses
             */
            Vehicle vehi = pc.buscarVehicle(2301L);//Declarem un vehicle que cerquem
            Asseguradora ase = pc.buscarAsseguradora(789L);//Declarem una Asseguradora que cerquem
            Client cli = pc.buscarClient(2261L);//Declarem un client que cerquem
            Polissa poliCreacio = new Polissa(0, "fesd", vehi, cli, sdf.parse("09-03-2018"), sdf.parse("09-03-2018"), true, 0, ase);//Creem una polissa nova amb les seves dades(i els objectes que hem cercat anteriorment. El camp de tipus esta en boolean i significa: true TERCERS, false TOT RISC
            System.out.print("Insertem una polissa: ");
            pc.Insertar(poliCreacio);//Insertem la polissa creada a la BBDD
            System.out.println(poliCreacio);
            Polissa poliModifi = pc.Buscar(2321L);//Creem un objecte polissa per modificar una polissa que cerquem.
            System.out.println("Modifiquem una polissa: ");
            System.out.println("Abans: " + poliModifi);
            poliModifi.setNumero("4578");//Modifiquem algun atribut de la polissa
            pc.Modificar(poliModifi);//Apliquem la modificacio a la Polissa
            System.out.println("Despres: " + poliModifi);
            System.out.println("Cerca d'una polissa: " + pc.Buscar(poliModifi.getIdPolissa()));//Realitzem una cerca d'una polissa per ID
            System.out.println("Eliminem una polissa: ");
            pc.Eliminar(pc.Buscar(poliModifi.getIdPolissa()));//Eliminem una polissa per ID
            System.out.println("I com podem veure ja no existeix: " + pc.Buscar(poliModifi.getIdPolissa()));
            System.out.println("Mostrar totes les polisses: ");
            pc.imprimirLista(pc.ConsultaTots());//Imprimim totes les polisses.
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
