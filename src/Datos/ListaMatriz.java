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

    public double[][] getInversa(double[][] Matriz) {
    
    double det=1/determinante(Matriz);
    
    double[][] matrizN=matrizAdjunta(Matriz);
    
    multiplicarMatriz(det,matrizN);
    
    return matrizN;
}
    public double[][] matrizAdjunta(double [][] Matriz){
    
    return MatrizTranspuesta(matrizCofactores(Matriz));
}
    public double[][] matrizCofactores(double[][] Matriz){
    double[][] nm=new double[Matriz.length][Matriz.length];

    for(int i=0;i<Matriz.length;i++) {
        
        for(int j=0;j<Matriz.length;j++) {
            
            double[][] det=new double[Matriz.length-1][Matriz.length-1];
            
            double detValor;
            
            for(int k=0;k<Matriz.length;k++) {
                if(k!=i) {
                    for(int l=0;l<Matriz.length;l++) {
                        if(l!=j) {
                        int indice1=k<i ? k : k-1 ;
                        int indice2=l<j ? l : l-1 ;
                        det[indice1][indice2]=Matriz[k][l];
                        }
                    }
                }
            }
            detValor=determinante(det);
            nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
        }
    }
    return nm;
}
    public void multiplicarMatriz(double n, double[][] Matriz) {
    for(int i=0;i<Matriz.length;i++)
        
        for(int j=0;j<Matriz.length;j++)
            Matriz[i][j]*=n;
}
 public double[][] MatrizTranspuesta(double [][] Matriz){
    double[][]NuevaMatriz=new double[Matriz[0].length][Matriz.length];
    for(int i=0; i<Matriz.length; i++)
    {
        for(int j=0; j<Matriz.length; j++)
            NuevaMatriz[i][j]=Matriz[j][i];
    }
    return NuevaMatriz;
}
 public double determinante(double[][] Matriz)
{
    double det;
    if(Matriz.length==2)
    {
        det=(Matriz[0][0]*Matriz[1][1])-(Matriz[1][0]*Matriz[0][1]);
        return det;
    }
    double suma=0;
    for(int i=0; i<Matriz.length; i++){
    double[][] nm=new double[Matriz.length-1][Matriz.length-1];
        for(int j=0; j<Matriz.length; j++){
            if(j != i){
                for(int k = 1; k < Matriz.length; k++){
                int indice = -1;
                if(j < i)
                indice = j;
                else if(j > i)
                indice = j-1;
                nm[indice][k-1]=Matriz[j][k];
                }
            }
        }
        if(i%2==0)
        suma += Matriz[i][0] * determinante(nm);
        else
        suma -= Matriz[i][0] * determinante(nm);
    }
    return suma;
}

    public void setInversa(Matriz inversa) {
        this.inversa = inversa;
    }
    public int  size(){
        return matrices.size();
    }
    public void duplicar(){
        Matriz m = new Matriz(new ArrayList<ArrayList<Fraccion>>(getUltimo().getMatriz()));
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
