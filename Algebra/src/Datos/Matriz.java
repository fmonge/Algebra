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
    public void cambioFila(int filaN,int filaM){
        matriz.set(filaN, matriz.get(filaM));
    }
    //multiplica el numero de entrada por cada elemento de la matriz
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
    //Operacion para multiplicar un numero por una fila de la matriz 
    public ArrayList<Double> escalarPorFila(Double n,int fila){
        ArrayList<Double> filatmp = new ArrayList<>();
        for (int i = 0; i < matriz.get(fila).size(); i++) {
            filatmp.add( matriz.get(fila).get(i)*n);
            
        }      
        return  filatmp;
    }

    //En este caso la suma de las filas es sin muplicacion al inicio Ejemplo [F1-->F2]
    public void sumaFila(int filaN,int filaM){ 
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, matriz.get(filaN).get(i)+matriz.get(filaN).get(i));
            
        }

    }
    //En este caso  la  filaN lleva multiplicacion al inicio Ejemplo: 3F1-->F2
    public void sumaFila(Double escalarN,int filaN ,int filaM){
        ArrayList<Double> filatmp = escalarPorFila(escalarN, filaN);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp.get(i)+matriz.get(filaM).get(i));
            
        }
    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void sumaFila(int filaN,Double escalarM,int filaM){

        ArrayList<Double> filatmp = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, matriz.get(filaN).get(i)+filatmp.get(i));
            
        }
    }
    
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void sumaFila(Double escalarN,int filaN,Double escalarM,int filaM){  
        ArrayList<Double> filatmp1 = escalarPorFila(escalarN, filaN);
        ArrayList<Double> filatmp2 = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp2.get(i)+filatmp1.get(i));
            
        }
    }
        //En este caso la suma de las filas es sin muplicacion al inicio Ejemplo [F1-->F2]
    public void restaFila(int filaN,int filaM){ 
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, matriz.get(filaN).get(i)-matriz.get(filaN).get(i));
            
        }

    }
    //En este caso  la  filaN lleva multiplicacion al inicio Ejemplo: 3F1-->F2
    public void restaFila(Double escalarN,int filaN ,int filaM){
        ArrayList<Double> filatmp = escalarPorFila(escalarN, filaN);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp.get(i)-matriz.get(filaM).get(i));
            
        }

    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void restaFila(int filaN,Double escalarM,int filaM){
        ArrayList<Double> filatmp = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, matriz.get(filaN).get(i)-filatmp.get(i));
            
        }
    }
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void restaFila(Double escalarN,int filaN,Double escalarM,int filaM){
        ArrayList<Double> filatmp1 = escalarPorFila(escalarN, filaN);
        ArrayList<Double> filatmp2 = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp2.get(i)-filatmp1.get(i));
            
        }
    }
}
