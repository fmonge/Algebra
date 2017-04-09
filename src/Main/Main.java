/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Datos.Fraccion;
import Datos.Matriz;
import GUI.Principal;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Main {
    public static void main(String[] args) {
        Fraccion a = new Fraccion(555,5);
        Fraccion b = new Fraccion(5,50);
        Fraccion c = new Fraccion(1,1);
        System.out.println("Operaciones con fracciones");        
        c = c.operacion(a, b, '+');
        System.err.println("-->"+c.toString());
        c = c.operacion(a, b, '-');
        System.err.println("-->"+c.toString());
        c = c.operacion(a, b, '*');
        System.err.println("-->"+c.toString());
        c = c.operacion(a, b, '/');
        System.err.println("-->"+c.toString());
        
        System.out.println("Operaciones con Matrice de fracciones");
        
        ArrayList<Integer> test0 = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> test1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Fraccion>> test2 = new ArrayList<ArrayList<Fraccion>>();
        test0.set(0, 1);
        test1.set(0, test0);
                
        Matriz ma = new Matriz();
        
        //matriz c = new Matriz(Fraccion(1,1);
        
        
        //Principal p = new Principal();
        //p.setVisible(true);
        
    }
    
}
