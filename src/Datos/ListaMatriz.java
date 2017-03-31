/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class ListaMatriz {
    private String nombre="";
    private ArrayList<Matriz> matrices= new ArrayList<Matriz>();
    private Matriz inversa = new Matriz();
    ArrayList<String> operaciones = new ArrayList<>();
    public void agregarOperacion(String op){
        operaciones.add(op);
    }
    public ArrayList<String> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<String> operaciones) {
        this.operaciones = operaciones;
    }
    public ArrayList<Matriz> getMatrices() {
        return matrices;
    }

    public void setMatrices(ArrayList<Matriz> matrices) {
        this.matrices = matrices;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void agregarMatriz(Matriz m){
        matrices.add(m);
    }

    public Matriz getInversa() {
        return inversa;
    }

    public void setInversa(Matriz inversa) {
        this.inversa = inversa;
    }
    public int  size(){
        return matrices.size();
    }
    public void duplicar(){
        Matriz m = new Matriz();
        ArrayList<ArrayList<Fraccion>> a = new ArrayList<>(getUltimo().getMatriz());
        m.setMatriz(a);
        matrices.add(m);
    }
    public Matriz getUltimo(){
        return matrices.get(matrices.size()-1);
    }

    public void imprimir(){
        for (int i = 0; i < matrices.size(); i++) {
            System.out.println(""+i);
            System.out.println(matrices.get(i).imprimirMatriz());
            System.out.println("---------------------------------------------------------------");
        }
    }
    public String imprimirTXT(){
        String s = "";
        for (int i = 0; i < matrices.size(); i++) {
            if (i != matrices.size()-1){
                s=s+matrices.get(i).imprimirMatriz()+System.lineSeparator()+"Operacion:"+operaciones.get(i)
                    +System.lineSeparator()+"----------------------------------------------------------------------"+System.lineSeparator();
            }
            else{
                s=s+matrices.get(i).imprimirMatriz()+System.lineSeparator()
                    +System.lineSeparator()+"----------------------------------------------------------------------"+System.lineSeparator();

            }
            
            
        }
        return s;
    }
    
    
}
