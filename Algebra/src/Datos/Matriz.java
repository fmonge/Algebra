
package Datos;

import java.util.ArrayList;

/**
 *
 * @author Curso
 */
public class Matriz {
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
        matriz.set(filaN, matriz.get(filaM));
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
    public void sumaFila(Fraccion escalarN,int filaN ,int filaM){
        ArrayList<Fraccion> filatmp = escalarPorFila(escalarN, filaN);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp.get(i)+matriz.get(filaM).get(i));
            
        }
    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void sumaFila(int filaN,Fraccion escalarM,int filaM){

        ArrayList<Fraccion> filatmp = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, matriz.get(filaN).get(i)+filatmp.get(i));
            
        }
    }
    
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void sumaFila(Fraccion escalarN,int filaN,Fraccion escalarM,int filaM){  
        ArrayList<Fraccion> filatmp1 = escalarPorFila(escalarN, filaN);
        ArrayList<Fraccion> filatmp2 = escalarPorFila(escalarM, filaM);
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
    public void restaFila(Fraccion escalarN,int filaN ,int filaM){
        ArrayList<Fraccion> filatmp = escalarPorFila(escalarN, filaN);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp.get(i)-matriz.get(filaM).get(i));
            
        }

    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void restaFila(int filaN,Fraccion escalarM,int filaM){
        ArrayList<Fraccion> filatmp = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, matriz.get(filaN).get(i)-filatmp.get(i));
            
        }
    }
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void restaFila(Fraccion escalarN,int filaN,Fraccion escalarM,int filaM){
        ArrayList<Fraccion> filatmp1 = escalarPorFila(escalarN, filaN);
        ArrayList<Fraccion> filatmp2 = escalarPorFila(escalarM, filaM);
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            matriz.get(filaN).set(i, filatmp2.get(i)-filatmp1.get(i));
            
        }
    }
    public void imprimirMatriz(){
        for (int i = 0; i < matriz.size(); i++) {
            System.out.println(matriz.get(i).toString());
            
        }
    
    }
}
