
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
    public Matriz(ArrayList<ArrayList<Fraccion>> matriz) {
        this.matriz  = matriz;     
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
    public Fraccion getElement(int i , int j){
        return matriz.get(i).get(j);
    }
    public void setElement(Fraccion f ,int i ,int j){
        matriz.get(i).set(j, f);
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
    public void multiplicacionEscalar(Fraccion escalar){
        Fraccion f = new Fraccion(1, 1);
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(i).size(); j++) {
                matriz.get(i).set(j, f.operacion(escalar, matriz.get(i).get(j),'*')) ;
            }
            
        }
    
    }
    public void iniciarMatriz(int t){
        for (int i = 0; i < t; i++) {
            matriz.add(new ArrayList<Fraccion>());
            for (int j = 0; j < t; j++) {
                matriz.get(i).add(new Fraccion(0,1));
                
            }
            
        }
    
    }
    public Matriz producto(Matriz a, Matriz b){
        Matriz temp = new Matriz();
        
        int size = a.getFila(0).size();
        temp.iniciarMatriz(size);
        for (int x=0; x < size; x++)
            for (int y=0; y < size; y++)
                for (int z=0; z<size; z++)
                {  
                    Fraccion f  = new Fraccion(1, 1);
                    System.out.println(x+"y"+z+"-"+ z+"y"+y);
                    f = f.operacion(a.getElement(x, z), b.getElement(z, y), '*');
                    f = f.operacion(temp.getElement(x, y), f, '+');
                    temp.setElement(f, x, y);
                    
               }
        return temp;
    }
    public Matriz Adjunta(Matriz m){
        return Transpuesta(Cofactores(m));
    }
    public Matriz Inversa(Matriz m){
        Fraccion det = new Fraccion(1, 1);
        Matriz n = m.Adjunta(m);
        det.operacion(new Fraccion(1, 1), m.determinante(m), '/');
        m.multiplicacionEscalar(det);
        return n;
    }
    public Matriz Cofactores(Matriz a){     
    Matriz nn = new Matriz();
        int size = a.getFila(0).size();
        nn.iniciarMatriz(size);

        for(int i=0;i<size;i++) {        
            for(int j=0;j<size;j++) {           
                Matriz det = new Matriz();
                det.iniciarMatriz(size-1);


                Fraccion detValor;

                for(int k=0;k<size;k++) {
                    if(k!=i) {
                        for(int l=0;l<a.getFila(0).size();l++) {
                            if(l!=j) {
                            int indice1=k<i ? k : k-1 ;
                            int indice2=l<j ? l : l-1 ;
                            Fraccion f = a.getElement(k,l);
                            det.setElement(f, indice1, indice2);
                            }
                        }
                    }
                }
                detValor=det.determinante(det);
                Fraccion f = new Fraccion(1,1);
                f= detValor.operacion(detValor, new Fraccion((int)Math.pow(-1, i+j+2), 1), '*');
                nn.setElement(f, i, i)  ;          
            }
        }
        return nn;
}
    public Matriz Transpuesta(Matriz m){
        Matriz transpuesta = new Matriz();
        transpuesta.iniciarMatriz(m.getFila(0).size());
        ArrayList<ArrayList<Fraccion>> matriztmp = new ArrayList<>(); 
        for (int i = 0; i < m.getFila(0).size(); i++) {
            for (int j = 0; j < m.getFila(0).size(); j++) {            
                transpuesta.setElement(m.getFila(j).get(i), i, j);
            }
            
        }
        return transpuesta;
    
    }
    //Operacion para multiplicar un numero por una fila de la matriz 
    public ArrayList<Fraccion> escalarPorFila(Fraccion n,int fila){
        ArrayList<Fraccion> filatmp = new ArrayList<>();
        for (int i = 0; i < matriz.get(fila).size(); i++) {
            Fraccion f = new Fraccion(1, 1);
            matriz.get(fila).set(i,f.operacion(n, matriz.get(fila).get(i),'*' ));
            
        }      
        return  filatmp;
    }

    //En este caso la suma de las filas es sin muplicacion al inicio Ejemplo [F1-->F2]
    public void sumaFila(int filaN,int filaM){ 
        for (int i = 0; i < matriz.size(); i++) {
            Fraccion f = new Fraccion(1, 1);
            System.out.println(""+matriz.get(filaN).get(i).getDenominador()+"/"+matriz.get(filaN).get(i).getNominador());
            Fraccion f2 = new Fraccion(matriz.get(filaN).get(i).getNominador(),matriz.get(filaN).get(i).getDenominador());
            Fraccion f3 = new Fraccion(matriz.get(filaM).get(i).getNominador(),matriz.get(filaM).get(i).getDenominador());
            f = f.operacion(f2, f3, '+');             
            matriz.get(filaM).set(i, f);
            
        }
    
        
        
        

    }
    public Matriz sumaMatriz(Matriz a,Matriz b){
        Matriz Matriztmp = new Matriz();
        Fraccion f = new Fraccion(1, 1);
        for (int i = 0; i < a.getFila(i).size(); i++) {
            ArrayList<Fraccion> filatmp = new ArrayList<>();
            for (int j = 0; j < a.getFila(i).size(); j++) {
                filatmp.add(f.operacion(a.getFila(i).get(j), b.getFila(i).get(j),'+' ));
                
            }
            Matriztmp.añadirFila(filatmp);      
        }
        return Matriztmp;
            
        }
    public Fraccion determinante(Matriz m){
        Fraccion f = new Fraccion(1, 1);
        if (m.getFila(0).size()==2){
            f = f.operacion(f.operacion(m.getFila(0).get(0),m.getFila(1).get(1),'*') ,f.operacion(m.getFila(1).get(0),m.getFila(0).get(1),'*'),'-');
            return f;
        }
        Fraccion suma = new Fraccion(0,1);
        for (int i = 0; i < m.getFila(0).size(); i++) {
            Matriz m1 = new Matriz();
            m1.iniciarMatriz(m.getFila(0).size()-1);
            for (int j = 0; j < m.getFila(0).size(); j++) {
                if(j != i){
                    for (int k = 1; k < m.getFila(0).size(); k++) {
                         int indice = -1;
                         if(j < i)
                         indice = j;
                         else if(j > i)
                         indice = j-1;
                         m1.getFila(i).set(k-1, m.getFila(j).get(k));
                         
                    }
            }
            
        }
        Fraccion f2 = new Fraccion(1, 1);
        if(i%2==0){
          suma.operacion(suma,f2.operacion(m.getElement(i, 0),m1.determinante(m), '*'),'+');
                  }
        else{
          suma.operacion(suma,f2.operacion(m.getElement(i, 0),m1.determinante(m), '*'),'-');
        }
        }
        return suma;
    }
     public Matriz restaMatriz(Matriz a,Matriz b){
        Matriz Matriztmp = new Matriz();
        Fraccion f = new Fraccion(1, 1);
        for (int i = 0; i < a.getFila(i).size(); i++) {
            ArrayList<Fraccion> filatmp = new ArrayList<>();
            for (int j = 0; j < a.getFila(i).size(); j++) {
                filatmp.add(f.operacion(a.getFila(i).get(j), b.getFila(i).get(j),'-' ));
                
            }
            Matriztmp.añadirFila(filatmp);      
        }
        return Matriztmp;
            
        }
        
    //En este caso  la  filaN lleva multiplicacion al inicio Ejemplo: 3F1-->F2
    public void sumaFila(Fraccion escalarN,int filaN ,String o,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(1, 1);
            f = f.operacion(f.operacion(matriz.get(filaN).get(i),escalarN,'*'), matriz.get(filaM).get(i), '+');
            matriz.get(filaM).set(i, f);   
        }
    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void sumaFila(String o,int filaN,Fraccion escalarM,int filaM){
            for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(1,1);
                f = f.operacion(matriz.get(filaN).get(i),f.operacion(matriz.get(filaM).get(i), escalarM,'*'), '+');              
                matriz.get(filaM).set(i, f);   
             }
    }
    
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void sumaFila(Fraccion escalarN,int filaN,Fraccion escalarM,int filaM){  
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(1, 1);
                f = f.operacion(f.operacion(matriz.get(filaN).get(i), escalarN,'*'),f.operacion(matriz.get(filaM).get(i), escalarM,'*'), '+');                
                matriz.get(filaM).set(i, f);   
             }
    }
        //En este caso la suma de las filas es sin muplicacion al inicio Ejemplo [F1-->F2]
    public void restaFila(int filaN,int filaM){ 
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(1,1);
            f = f.operacion(matriz.get(filaM).get(i), matriz.get(filaN).get(i), '-');
            matriz.get(filaM).set(i, f);   
        }

    }
    //En este caso  la  filaN lleva multiplicacion al inicio Ejemplo: 3F1-->F2
    public void restaFila(Fraccion escalarN,int filaN ,String o,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
            Fraccion f = new Fraccion(1,1);
            f = f.operacion(f.operacion(matriz.get(filaM).get(i), escalarN,'*'), matriz.get(filaN).get(i), '-');            
            matriz.get(filaM).set(i, f);   
        }

    }
    //En este casola filaM lleva multiplicacion al inicio [Ejemplo F1-->3F2]
    public void restaFila(String o,int filaN,Fraccion escalarM,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(1,1);
                f = f.operacion(matriz.get(filaM).get(i),f.operacion(matriz.get(filaN).get(i), escalarM,'*'), '-');
                matriz.get(filaM).set(i, f);   
             }
    }
    
    //En este caso filaN y filaM llevan multiplicacion al inicio [Ejemplo 4F1-->5F2]
    public void restaFila(Fraccion escalarN,int filaN,Fraccion escalarM,int filaM){
        for (int i = 0; i < matriz.get(filaN).size(); i++) {
                Fraccion f = new Fraccion(1,1);
                f = f.operacion(f.operacion(matriz.get(filaM).get(i), escalarN,'*'),f.operacion(matriz.get(filaN).get(i), escalarM,'*'), '-');
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
