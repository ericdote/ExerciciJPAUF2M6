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
            Adreca adre1 = new Adreca("Carrer Fals",1,"Poblcaion No existent");
            Usuari usu1 = new Usuari("Eric12", "1324");
            Client cli1 = new Client(0, "1234678-x", "Eric", adre1);
            Vehicle vehi1 = new Vehicle(0, "AAAA111", "A", 1996, cli1, null);
            Asseguradora ase1 = new Asseguradora(0, "Mapfre", "45784F");
            Polissa poli1 = new Polissa(0, "1", vehi1, cli1, sdf.parse("09-03-2017"), sdf.parse("09-03-2017"), true, 0, ase1);
             
            

            Usuari_Controller uc = new Usuari_Controller();
            uc.Insertar(usu1);
            
            Client_Controller cc = new Client_Controller();
            cc.Insertar(cli1);
            
            Vehicle_Controller vc = new Vehicle_Controller();
            vc.Insertar(vehi1);
            
            Asseguradora_Controller asc = new Asseguradora_Controller();
            asc.Insertar(ase1);
            
//            cc.imprimirPersona(cc.BuscarPerNom("Eric"));
            Polissa_Controller pc = new Polissa_Controller();
            pc.Insertar(poli1);
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
