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
    private ArrayList<ArrayList<Double>> filas;
    private ArrayList<ArrayList<Double>> columnas;

    public Matriz() {
        filas = new ArrayList<>();
        columnas = new ArrayList<>();
    }

    public Matriz(ArrayList<ArrayList<Double>>  filas, ArrayList<ArrayList<Double>>  columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public ArrayList<ArrayList<Double>>  getFilas() {
        return filas;
    }
    public ArrayList<Double> getFila(int i){
        return filas.get(i);
    }

    public void setFilas(ArrayList<ArrayList<Double>>  fila) {
        this.filas = filas;
    }

    public ArrayList<ArrayList<Double>>  getColumnas() {
        return columnas;
    }
    public ArrayList<Double> getColumna(int j){
        return filas.get(j);
    }

    public void setColumnas(ArrayList<ArrayList<Double>>  columna) {
        this.columnas = columnas;
    }
    public void cambioFila(Matriz m){
        
    }
    
    
}
