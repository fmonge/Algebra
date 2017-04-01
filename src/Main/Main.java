/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  */
package Main;

import Datos.Fraccion;
import GUI.Principal;

/**
 *
 * @author Alexis
 */
public class Main {
    public static void main(String[] args) {
        // ejemplo de ops de fracciones
        Fraccion a = new Fraccion(5,5);
        Fraccion b = new Fraccion(5,5);
        Fraccion c = new Fraccion(1,1);
        c = c.operacion(a, b, '+');
        System.err.println("-->"+c.toString());
        c = c.operacion(a, b, '-');
        System.err.println("-->"+c.toString());
        //Principal p = new Principal();
        // p.setVisible(true);      
    }
    
}
