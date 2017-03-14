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
    private ArrayList<Double> fila;
    private ArrayList<Double> columna;

    public Matriz() {
        fila = new ArrayList<>();
        columna = new ArrayList<>();
    }

    public Matriz(ArrayList<Double> fila, ArrayList<Double> columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public ArrayList<Double> getFila() {
        return fila;
    }

    public void setFila(ArrayList<Double> fila) {
        this.fila = fila;
    }

    public ArrayList<Double> getColumna() {
        return columna;
    }

    public void setColumna(ArrayList<Double> columna) {
        this.columna = columna;
    }
    
    
    
}
