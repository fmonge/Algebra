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
    public Matriz(String M){
        
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
        ArrayList<Double> columna= new ArrayList<Double>();
        for (int i = 0; i < matriz.size(); i++) {
            
            for (int k = 0; k < matriz.get(i).size(); k++) {
                if (k==j){
                    columna.add(matriz.get(i).get(k));
                
                }
                
            }
            
        }
        return columna;
    }
    public void cambioFila(int filan,int filam){
        matriz.set(filan, matriz.get(filam));
    }
    public void multiplicacionEscalar(Double escalar){
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(i).size(); j++) {
                matriz.get(i).set(j,matriz.get(i).get(j)*escalar ); 
                matriz.get(i).get(j);
            }
            
        }
    
    }
    public void aplicarTranspuesta(){
        
        ArrayList<ArrayList<Double>> matriztmp = new ArrayList<>(); 
        for (int i = 0; i < matriz.size(); i++) {
            matriztmp.add(this.getcolumna(i));
            
        }
        matriz = matriztmp;
    
    }
    
    
}
