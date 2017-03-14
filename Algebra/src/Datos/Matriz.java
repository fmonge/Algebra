/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author Curso
 */
public class Matriz {
    private ArrayList<ArrayList<Double>> matriz;
  
    public Matriz() {
        matriz = new ArrayList<ArrayList<Double>>();
        
    }

    public Matriz(ArrayList<ArrayList<Double>> matriz ) {
       this.matriz = matriz;
    }

    public ArrayList<ArrayList<Double>> getMatriz() {
        return matriz;
    }

    public void setMatriz(ArrayList<ArrayList<Double>> matriz) {
        this.matriz = matriz;
    }
    public ArrayList<Double> getFila(int i){
        return matriz.get(i);
    }
    public ArrayList<Double> getcolumna(int j){
        ArrayList<Double> matriztmp= new ArrayList<Double>();
        for (int i = 0; i < matriz.size(); i++) {
            
            for (int k = 0; k < matriztmp.get(i); k++) {
                if (k==j){
                    matriztmp.add(matriz.get(i).get(k));
                
                }
                
            }
            
        }
        return matriztmp;
    }
    public void cambioFila(Matriz M,int fn,int fm){
        matriz.set(fn, M.getFila(fm));
    }
    
    
}
