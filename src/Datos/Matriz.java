
package Datos;

import java.util.ArrayList;

/**
 *
 * @author Curso
 */
public class Matriz  {
    private ArrayList<ArrayList<Fraccion>> matriz;
    
    public Matriz() {
        matriz = new ArrayList<ArrayList<Fraccion>>();        
    }
    public void añadirFila(ArrayList<Fraccion> array){
        this.matriz.add(array);   
    }
    public ArrayList<ArrayList<Fraccion>> getMatriz() {
        return matriz;
    }     
    public Fraccion multiplicarFraccion( Fraccion f1,  Fraccion f2){
        
        int d = f1.getDenominador()*f2.getDenominador();
        int n = f1.getNominador()*f2.getNominador();
        
        return new Fraccion(d, n);
    }
    public ArrayList<Fraccion> getFila(int i){
        return matriz.get(i);
    }
    public ArrayList<Fraccion> getcolumna(int j){
        ArrayList<Fraccion> columna= new ArrayList<Fraccion>();
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
        ArrayList<Fraccion> tmp1 = matriz.get(filaM);
        ArrayList<Fraccion> tmp2 = matriz.get(filaN);
        matriz.set(filaN, tmp1);
        matriz.set(filaM, tmp2);
    }
    //multiplica el numero de entrada por cada elemento de la matriz
    public void multiplicacionEscalar(int  escalar){   
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(i).size(); j++) {
                matriz.get(i).get(j).setNominador(matriz.get(i).get(j).getNominador()*escalar);
            }
            
        }
    
    }
    public void aplicarTranspuesta(){
        
        ArrayList<ArrayList<Fraccion>> matriztmp = new ArrayList<>(); 
        for (int i = 0; i < matriz.size(); i++) {
            matriztmp.add(this.getcolumna(i));
            
        }
        matriz = matriztmp;
    
    }
    //Operacion para multiplicar un numero por una fila de la matriz 
    public ArrayList<Fraccion> escalarPorFila(Fraccion n,int fila){
        ArrayList<Fraccion> filatmp = new ArrayList<>();
        for (int i = 0; i < matriz.get(fila).size(); i++) {
            Fraccion f = new Fraccion(0, 0);
            matriz.get(fila).set(i,f.operacion(n, matriz.get(fila).get(i),'*' ));
            
        }      
        return  filatmp;
    }

    //En este caso la suma de las filas es sin muplicacion al inicio Ejemplo [F1-->F2]
    public void sumaFila(int filaN,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(0, 0);
            f = f.operacion(matriz.get(filaN).get(i), matriz.get(filaM).get(i), '+');
            System.out.println(f.toString()+"asdkijhashjgfd");
            matriz.get(filaM).set(i, f);
        }
    }
    
    //En este caso  la  filaN lleva multiplicacion al inicio Ejemplo: 3F1-->F2
    public void sumaFila(Fraccion escalarN,int filaN ,String o,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(0, 0);
            f = f.operacion(f.operacion(matriz.get(filaN).get(i),escalarN,'*'), matriz.get(filaM).get(i), '+');
            matriz.get(filaM).set(i, f);   
        }
    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void sumaFila(String o,int filaN,Fraccion escalarM,int filaM){
            for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(0, 0);
                f = f.operacion(matriz.get(filaN).get(i),f.operacion(matriz.get(filaM).get(i), escalarM,'*'), '+');              
                matriz.get(filaM).set(i, f);   
             }
    }
    
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void sumaFila(Fraccion escalarN,int filaN,Fraccion escalarM,int filaM){  
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(0, 0);
                f = f.operacion(f.operacion(matriz.get(filaN).get(i), escalarN,'*'),f.operacion(matriz.get(filaM).get(i), escalarM,'*'), '+');                
                matriz.get(filaM).set(i, f);   
             }
    }
        //En este caso la suma de las filas es sin muplicacion al inicio Ejemplo [F1-->F2]
    public void restaFila(int filaN,int filaM){ 
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(0, 0);
            f = f.operacion(matriz.get(filaN).get(i), matriz.get(filaM).get(i), '-');
            matriz.get(filaM).set(i, f);   
        }

    }
    //En este caso  la  filaN lleva multiplicacion al inicio Ejemplo: 3F1-->F2
    public void restaFila(Fraccion escalarN,int filaN ,String o,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(0, 0);
            f = f.operacion(f.operacion(matriz.get(filaN).get(i), escalarN,'*'), matriz.get(filaM).get(i), '-');            
            matriz.get(filaM).set(i, f);   
        }

    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void restaFila(String o,int filaN,Fraccion escalarM,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(0, 0);
                f = f.operacion(matriz.get(filaN).get(i),f.operacion(matriz.get(filaM).get(i), escalarM,'*'), '-');
                matriz.get(filaM).set(i, f);   
             }
    }
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void restaFila(Fraccion escalarN,int filaN,Fraccion escalarM,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(0, 0);
                f = f.operacion(f.operacion(matriz.get(filaN).get(i), escalarN,'*'),f.operacion(matriz.get(filaM).get(i), escalarM,'*'), '-');
                matriz.get(filaM).set(i, f);   
             }
    }
    public String imprimirMatriz(){
        String a = "";
        for (int i = 0; i < matriz.size(); i++) {
            a=a+matriz.get(i).toString()+System.lineSeparator();
            
        }
        return a;
    
    } 
    public int filasSize(){
       return  matriz.size();
    }
    public int columnasSize(){
        return matriz.get(0).size();
    }

    public void setMatriz(ArrayList<ArrayList<Fraccion>> matriz) {
        this.matriz = matriz;
    }

    
    
}
