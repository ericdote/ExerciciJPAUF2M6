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
            Calendar cale;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Adreca adre1 = new Adreca("Carrer Fals", 1, "Poblacion No existent");
//            Usuari usu1 = new Usuari("Eric12", "1324");
            Client cli1 = new Client(1302L, "1234678yx", "Eric", adre1);
//            Vehicle vehi1 = new Vehicle(1301L, "AAAA111", "ABC", 1996, cli1, null);
//            Asseguradora ase1 = new Asseguradora(721L, "Mapfre2", "45784d");
//            Polissa poli1 = new Polissa(1L, "1", vehi1, cli1, sdf.parse("09-03-2017"), sdf.parse("09-03-2017"), true, 0, ase1);
            Polissa_Controller pc = new Polissa_Controller();
            Usuari_Controller uc = new Usuari_Controller();
            Client_Controller cc = new Client_Controller();
            Vehicle_Controller vc = new Vehicle_Controller();
            Asseguradora_Controller asc = new Asseguradora_Controller();
//            System.out.println(cli);
//            System.out.print("Creem una direccio: ");
//            System.out.println(adre1);
//            System.out.print("Insertem un usuari: ");
//            uc.Insertar(usu1);
//            System.out.println(usu1);
//            System.out.println("Modifiquem un usuari: ");
//            System.out.println("Abans: " + usu1);
//            usu1.setPass("456");
//            uc.Modificar(usu1);
//            System.out.println("Despres: " + usu1);
//            System.out.println("Cerca de usuari per id: " + uc.Buscar("Eric12"));
//            System.out.println("Eliminar usuari: ");
//            uc.Eliminar(usu1);
//            System.out.println("Si busquem ara ja no existeix: " + uc.Buscar("Eric12"));
//
//            System.out.print("Insertem un client: ");
//            cc.Insertar(cli1);
//            System.out.println(cli1);
            Client cliModificar = cc.Buscar(1302L);
//            System.out.println("Modifiquem un client: ");
//            System.out.println("Abans: " + cliModificar);
            cliModificar.setNif("111111A");
//            cc.Modificar(cliModificar);
//            System.out.println("Despres: " + cliModificar);
            System.out.println("Cerca de client per id: " +  cc.Buscar(cliModificar.getId()));
             Client cliEliminar = cc.Buscar(cliModificar.getId());
             Polissa polissaEliminarPerClient = pc.BuscarPerClient(cliEliminar.getId());//ACABAR ESTO TENGO QUE RECUPERAR UNA LISTA Y ELIMINAR TODAS LAS POLIZAS RELACIONADAS CON EL CLIENTE PARA PODER ELIMINARLO
             System.out.println(polissaEliminarPerClient);
//             System.out.println(cliEliminar);
//            System.out.print("Eliminem un client: ");
//            cc.Eliminar(cliEliminar);
//            System.out.println("Si busquem ara ja no existeix: " + cc.Buscar(cliEliminar.getId()));
//            cc.imprimirPersona(cc.BuscarPerNom("Eric"));
//            Client cliPerVehicle = vc.BuscarClient(1722L);
//            Vehicle vehi1 = new Vehicle(0, "213457", "A", 1998, cliPerVehicle, null);           
//            vc.Insertar(vehi1);
//            System.out.println(vehi1);
//            Vehicle vehiModificar = vc.Buscar(1721L);
//            System.out.println("Modifiquem un Vehicle: ");
//            System.out.println("Abans: " + vehiModificar);
//            vehiModificar.setMarcaModel("ABC");
//            vc.Modificar(vehiModificar);
//            System.out.println("Despres: " + vehiModificar);
//            Vehicle vehiPerEliminar = vc.Buscar(1521L);
//            System.out.println("Eliminem un vehicle, pero abans hem d'eliminar una polissa ja que esta el vehicle vinculat a aquesta: ");
//            Polissa poliEliminar = pc.BuscarPerVehicle(vehiPerEliminar.getVehicleId());
//            pc.Eliminar(poliEliminar);            
//            vc.Eliminar(vehiPerEliminar);
//            System.out.println("Si busquem ara no existeix: " + vc.Buscar(vehiPerEliminar.getVehicleId()));
//
//            System.out.print("Insertem una asseguradora: ");
//            asc.Insertar(ase1);
//            System.out.println(ase1);
//            Asseguradora aseModificar = asc.Buscar(1101L);
//            System.out.println("Modificar una asseguradora: ");
//            System.out.println("Abans: " + aseModificar);
//            aseModificar.setNom("Mahfre");
//            asc.Modificar(aseModificar);
//            System.out.println("Despres: " + aseModificar);
//            System.out.println("Cerca d'una asseguradora per la seva id: " + asc.Buscar(aseModificar.getAsseguradoraId()));
//            System.out.println("Eliminem una asseguradora: ");
//            asc.Eliminar(aseModificar);
//            System.out.println("Si busquem ara no la trobem: " + asc.Buscar(aseModificar.getAsseguradoraId()));
//            Vehicle vehi = pc.buscarVehicle(2141L);
//            Asseguradora ase = pc.buscarAsseguradora(721L);
//            Client cli = pc.buscarClient(1302L);
//            Polissa poliCreacio = new Polissa(0, "fesd", vehi, cli, sdf.parse("09-03-2018"), sdf.parse("09-03-2018"), true, 0, ase);
//            System.out.print("Insertem una polissa: ");
//            pc.Insertar(poliCreacio);
//            System.out.println(poliCreacio);
//            Polissa poliModifi = pc.Buscar(2161L);
//            System.out.println("Modifiquem una polissa: ");
//            System.out.println("Abans: " + poliModifi);
//            poliModifi.setNumero("4578");
//            pc.Modificar(poliModifi);
//            System.out.println("Despres: " + poliModifi);
//            System.out.println("Cerca d'una polissa: " + pc.Buscar(poliModifi.getIdPolissa()));
//            System.out.println("Eliminem una polissa: ");
//            pc.Eliminar(pc.Buscar(poliModifi.getIdPolissa()));
//            System.out.println("I com podem veure ja no existeix: " + pc.Buscar(poliModifi.getIdPolissa()));
//
//            Client pruebaClient = new Client();
//            pruebaClient.setId(601L);
//            pc.BuscarPerClient(pruebaClient);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
