/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        try {
            for (int i = 0; i < this.getUltimo().getFila(0).size(); i++) {
                ArrayList<Fraccion> filatmp = new ArrayList<>();
                for (int j = 0; j < this.getUltimo().getFila(0).size(); j++) {
                    Fraccion f = new Fraccion(this.getUltimo().getFila(i).get(j).getNominador(),this.getUltimo().getFila(i).get(j).getDenominador());
                    filatmp.add(f);

            }
            m.añadirFila(filatmp);      
        }
        matrices.add(m);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"si aqui");
        }
        
        
        
        
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
                s=s+matrices.get(i).imprimirMatriz()
                    +System.lineSeparator()+"----------------------------------------------------------------------"+System.lineSeparator();
            }
        }
        return s;
    }
    
    
}
