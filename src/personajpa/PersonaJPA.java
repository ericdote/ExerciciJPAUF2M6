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
//            Calendar cale;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Adreca adre1 = new Adreca("Carrer Fals", 1, "Poblacion No existent");
//////            Usuari usu1 = new Usuari("Eric12", "1324");
            Client cli1 = new Client(681L, "1234678-x", "Eric", adre1);
            Vehicle vehi1 = new Vehicle(701, "AAAA111", "ABC", 1996, cli1, null);
            Asseguradora ase1 = new Asseguradora(721, "Mapfre2", "45784d");
            Polissa poli1 = new Polissa(741, "1", vehi1, cli1, sdf.parse("09-03-2017"), sdf.parse("09-03-2017"), true, 0, ase1);
            Polissa_Controller pc = new Polissa_Controller();

//            System.out.print("Creem una direccio: ");
//            System.out.println(adre1);
//            System.out.print("Insertem un usuari: ");
//            Usuari_Controller uc = new Usuari_Controller();
////            uc.Insertar(usu1);
////            System.out.println(usu1);
//            System.out.println("Modifiquem un usuari: ");
////            System.out.println("Abans: " + usu1);
////            usu1.setPass("456");
////            uc.Modificar(usu1);
////            System.out.println("Despres: " + usu1);
//            System.out.println("Cerca de usuari per id: " + uc.Buscar("Eric12"));
//            System.out.println("Eliminar usuari: ");
//            uc.Eliminar(usu1);
//            System.out.println("Si busquem ara ja no existeix: " + uc.Buscar("Eric12"));

//            System.out.print("Insertem un client: ");
//            Client_Controller cc = new Client_Controller();
//            cc.Insertar(cli1);
//            System.out.println(cli1);
//            System.out.println("Modifiquem un client: ");
//            System.out.println("Abans: " + cli1);
//            cli1.setNif("111111A");
//            cc.Modificar(cli1);
//            System.out.println("Despres: " + cli1);
//            System.out.println("Cerca de client per id: " + cc.Buscar(781L));
//            System.out.print("Eliminem un client: ");
//            cc.Eliminar(cli1);
//            System.out.println("Si busquem ara ja no existeix: " + cc.Buscar(781L));
//            cc.imprimirPersona(cc.BuscarPerNom("Eric"));
            Vehicle_Controller vc = new Vehicle_Controller();
//            System.out.print("Insertem un Vehicle: ");
//            vc.Insertar(vehi1);
//            System.out.println(vehi1);
//            System.out.println("Modifiquem un Vehicle: ");
//            System.out.println("Abans: " + vehi1);
//            vehi1.setMarcaModel("ABC");
//            vc.Modificar(vehi1);
//            System.out.println("Despres: " + vehi1);
//              System.out.println("Cerca d'un vehicle: " + vc.Buscar(701L));
            System.out.println("Eliminem un vehicle, pero abans hem d'eliminar una polissa ja que esta el vehicle vinculat a aquesta: ");
            pc.Eliminar(poli1);
            vc.Eliminar(vehi1);
            System.out.println("Si busquem ara no existeix: " + vc.Buscar(701L));

//            Asseguradora_Controller asc = new Asseguradora_Controller();
//            System.out.print("Insertem una asseguradora: ");
//            asc.Insertar(ase1);
//            System.out.println(ase1);
//            System.out.println("Modificar una asseguradora: ");
//            System.out.println("Abans: " + ase1);
//            ase1.setNom("Mahfre");
//            asc.Modificar(ase1);
//            System.out.println("Despres: " + ase1);
//              System.out.println("Cerca d'una asseguradora per la seva id: " + asc.Buscar(1121L));
//              System.out.println("Eliminem una asseguradora: ");
//              asc.Eliminar(ase1);
//              System.out.println("Si busquem ara no la trobem: " + asc.Buscar(1121L));
//            System.out.print("Insertem una polissa: ");
//            pc.Insertar(poli1);
//            System.out.println(poli1);
//            
//            Client pruebaClient = new Client();https://github.com/ericdote/ExerciciJPAUF2M6.git
//            pruebaClient.setId(601L);
//            pc.BuscarPerClient(pruebaClient);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
