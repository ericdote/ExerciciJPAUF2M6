/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajpa;

import controlador.*;
import java.util.List;
import javax.persistence.Persistence;
import modelo.*;

/**
 *
 * @author Jorge
 */
public class PersonaJPA {

    public static void main(String[] args) {
        try {
            
            Adreca adre1 = new Adreca();
            adre1.setCarrer("Falso");
            adre1.setNumero(0);
            adre1.setPoblacio("Montcada");
            System.out.println(adre1);
            Adreca_Controller ac = new Adreca_Controller();
            ac.Insertar(adre1);

            
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
